package br.com.geradorASN.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.MapeamentoDados;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.Relatorio;
import br.com.geradorASN.entity.Enum.RelatorioStatusEnum;
import br.com.geradorASN.entity.Enum.TipoProdutoEnum;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.exception.EmpresaNotFoundException;
import br.com.geradorASN.exception.ProdutoNotFoundException;
import br.com.geradorASN.exception.RestErrorException;

@Transactional
@Service("geradorASNService")
public class GeradorASNService {

	private static final Logger log = LoggerFactory.getLogger(GeradorASNService.class);

	@Autowired
	private NimbiService nimbiService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private RelatorioService relatorioService;

	@Autowired
	private ZipService zipService;

	public List<AdvancedShipmentNotificationPost> gerarASN() throws RestErrorException, ParseException, IOException,
			ClassNotFoundException, EmpresaNotFoundException, ProdutoNotFoundException {

		List<AdvancedShipmentNotificationPost> advancedShipmentNotificationPostList = nimbiService.complementarInfoAdvancedShipmentNotificationPost(gerarRelatorio(
				zipService.consultarArquivosZip(nimbiService.consultarXMLCaminhoZip())));

		parametroService.updateParametroDataCorte();

		return advancedShipmentNotificationPostList;

	}

	private List<AdvancedShipmentNotificationPost> gerarRelatorio(
			List<MapeamentoDados> mapeamentoDadosList) throws EmpresaNotFoundException, ProdutoNotFoundException{
		
		List<AdvancedShipmentNotificationPost> listaNFeASN = new ArrayList<AdvancedShipmentNotificationPost>();
		
		mapeamentoDadosList.forEach(mapeamento -> {
			
				String cnpj = mapeamento.getNfeNimbi().getSupplier().getSupplierCNPJ();
				List<Empresa> empresas = empresaService.getEmpresaByCnpj(cnpj);
			
			if (empresas.isEmpty()) {
				throw new EmpresaNotFoundException("CNPJ não encontrado na tabela Empresa.");
			}
			
			List<Produto> produtos = produtoService.getProdutoByCad(mapeamento.getCodigoProduto());
			
			if (produtos.isEmpty()) {
				throw new ProdutoNotFoundException("CAD Michelan não encontrado na tabela Produto.");
			}
			
			Empresa empresa = empresas.get(0);
			Produto produto = produtos.get(0);
			
			if (empresa.isGeraASN() && !produto.getTipoProduto().equals(TipoProdutoEnum.MEMS.getDescricao())) {
				
				relatorioService.salvarRelatorio(new Relatorio()
						.setReference(mapeamento.getNfeNimbi().getReference())
						.setStatus(RelatorioStatusEnum.ASN_GERADO.getDescricao()));	
				listaNFeASN.add(mapeamento.getAdvancedShipmentNotificationPost());
			
			} else  {
				relatorioService.salvarRelatorio(new Relatorio()
						.setReference(mapeamento.getNfeNimbi().getReference())
						.setStatus(RelatorioStatusEnum.NAO_SE_APLICA.getDescricao()));

			} 
			
		});
		
		return listaNFeASN;

	}

}
