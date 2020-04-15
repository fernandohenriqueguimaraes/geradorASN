package br.com.geradorASN.service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.CSVReader;

import br.com.geradorASN.dao.EmpresaDao;
import br.com.geradorASN.dao.ProdutoDao;
import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.Enum.TipoProdutoEnum;

@Transactional
@Service("produtoService")
public class ProdutoService implements GeradorTabelasService<Produto> {
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoService.class);
	
	private static String PRODUTO_SOURCE_PATH = "src/main/resources/produtos.csv";
	
	@Autowired
	private ProdutoDao produtoRepository;
	
	public List<Produto> carregarDados() throws IOException {
		
		List<Produto> produtos = new ArrayList<Produto>();

		@SuppressWarnings("deprecation")
		CSVReader reader = new CSVReader(new FileReader(PRODUTO_SOURCE_PATH), ';' , '"' , 1);
		List<String[]> produtoStringList = reader.readAll();
		
		for (String[] produto : produtoStringList) {
			log.info("Extraindo o PRODUTO: " + Arrays.toString(produto));
			Produto produtoExtraido = new Produto();
			produtoExtraido.setPartNumber(produto[0]).setCai(produto[1]).setCad(produto[2])
					.setModelo(produto[3]).setTipoProduto((produto[4])).setUnidadeMedida(produto[5])
					.setVolume(new BigDecimal(produto[6])).setAltura(new BigDecimal(produto[7]))
					.setLargura(new BigDecimal(produto[8])).setComprimento(new BigDecimal(produto[9]));
			
			List<Produto> produtoDb = getProdutoByCad(produtoExtraido.getCad());
			if (!getProdutoByCad(produtoExtraido.getCad()).isEmpty()) {
				produtos.add(produtoDb.get(0));
				log.error("CAD Michelan já encontrado na tabela Produto.");
				continue;
			}
			
			log.info("Persistindo todos o PRODUTO:" + produtoExtraido.toString());
			produtoRepository.save(produtoExtraido);
			
			produtos.add(produtoExtraido);
			
		}
		
		return produtos;
		
	}
	
	public List<Produto> getProdutoByCad(String cad) {
		return produtoRepository.getProdutoByCad(cad);
	}

}
