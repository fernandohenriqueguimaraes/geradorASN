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
import org.springframework.web.servlet.ModelAndView;

import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.Relatorio;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.exception.EmpresaNotFoundException;
import br.com.geradorASN.exception.ProdutoNotFoundException;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.EmpresaService;
import br.com.geradorASN.service.GeradorASNService;
import br.com.geradorASN.service.ParametroService;
import br.com.geradorASN.service.ProdutoService;
import br.com.geradorASN.service.RelatorioService;

/**
 * Classe controladora da geração de ASN
 * 
 * @author fernandohenriqueguimaraes
 *
 */
@RestController
@RequestMapping("/")
public class GeradorASNController {

	private static final Logger log = LoggerFactory.getLogger(GeradorASNController.class);

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ParametroService parametroService;
	
	@Autowired
	private RelatorioService relatorioService;

	@Autowired
	private GeradorASNService geradorASNService;
	
	@RequestMapping()
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("resultado");
		List<Relatorio>	resultados = relatorioService.listarResultados();
		String dataCorte = parametroService.getParametroByChave(ParametroService.PARAMETRO_DATA_CORTE);
		mv.addObject("resultados", resultados);
		mv.addObject("datacorte", dataCorte);
		return mv;
	}

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
	public ModelAndView gerarASN() {
				
		try {
			geradorASNService.gerarASN();
		} catch (RestErrorException | ParseException | IOException | ClassNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (EmpresaNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (ProdutoNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/");

	}
	
}
