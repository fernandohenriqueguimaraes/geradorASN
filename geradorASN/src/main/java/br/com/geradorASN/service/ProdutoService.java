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
public class ProdutoService implements geradorASNService<Produto> {
	
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
			produtos.add(produtoExtraido.setPartNumber(produto[0]).setCai(produto[1]).setCad(produto[2])
					.setModelo(produto[3]).setTipoProduto(TipoProdutoEnum.toTipoProdutoEnum(produto[4])).setUnidadeMedida(produto[5])
					.setVolume(new BigDecimal(produto[6])).setAltura(new BigDecimal(produto[7]))
					.setLargura(new BigDecimal(produto[8])).setComprimento(new BigDecimal(produto[9])));
			
			log.info("Persistindo todos o PRODUTO:" + produtoExtraido.toString());
			produtoRepository.save(produtoExtraido);
			
		}
		
		return produtos;
		
	}

}
