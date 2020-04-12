package br.com.geradorASN.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.EmpresaService;
import br.com.geradorASN.service.GeradorASNService;
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
	private GeradorASNService geradorASNService;

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
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

	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
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

	@RequestMapping(value = "/gerarASN", method = RequestMethod.GET)
	@ResponseBody
	public List<Gerado> gerarASN() {
		List<Gerado> listaGerado = new ArrayList<Gerado>();
		try {
			listaGerado = (List<Gerado>) geradorASNService.consultarArquivosZip();
		} catch (RestErrorException | ParseException | IOException | ClassNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return listaGerado;

	}
}
