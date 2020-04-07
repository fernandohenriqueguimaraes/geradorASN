package br.com.geradorASN.controller;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;

import br.com.geradorASN.dao.EmpresaDao;
import br.com.geradorASN.dao.ProdutoDao;
import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.Enum.TipoProdutoEnum;
import br.com.geradorASN.entity.rest.v1.get.response.NotaFiscalEletronicaNimbiResponse;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.EmpresaService;
import br.com.geradorASN.service.NimbiService;
import br.com.geradorASN.service.ProdutoService;

/**
 * Classe controladora da geração de ASN
 * 
 * @author fernandohenriqueguimaraes
 *
 */
@RestController
public class GeradorASNController {
	
	private static final Logger log = LoggerFactory.getLogger(GeradorASNController.class);

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired 
	private NimbiService nimbiService;
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody  
	public List<Produto> carregarProdutos() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			produtos = produtoService.carregarDados();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return produtos;
		
	}
	
	@RequestMapping(value="/empresas", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody  
	public List<Empresa> carregarEmpresas() {
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		try {
			empresas = empresaService.carregarDados();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empresas;
		
	}
	
	@RequestMapping(value="/gerarASN", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody  
	public String consultarNimbi() {
		
		String response = StringUtils.EMPTY;
		
		try {
			response = nimbiService.gerarASN();
		} catch (RestErrorException | ParseException e) {
			e.printStackTrace();
		}
		return response;
		
	}
}
