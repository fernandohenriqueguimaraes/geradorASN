package br.com.geradorASN.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;

import com.google.common.base.CharMatcher;

import br.com.geradorASN.entity.MapeamentoDados;
import br.com.geradorASN.entity.rest.v1.get.response.NotaFiscalEletronicaNimbiResponse;
import br.com.geradorASN.entity.rest.v3.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.entity.rest.v3.post.response.RetornoGeracaoASNPost;
import br.com.geradorASN.entity.rest.v4.get.response.OrdemPedidoNimbiResponse;
import br.com.geradorASN.entity.xml.PedGeraArquivo;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.config.RestNimbiConfig;
import br.com.geradorASN.util.DataUtil;
import br.com.geradorASN.util.XMLUtil;

@Transactional
@Service("nimbiService")
@SuppressWarnings("unchecked")
public class NimbiService {

	private static final Logger log = LoggerFactory.getLogger(NimbiService.class);

	private static String CLASSE_PED_GERA_ARQUIVO = "PedGeraArquivo";
	private static String STATUS_NOTA_FISCAL_VALIDADO = "01";

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private RestNimbiConfig restNimbiConfig;

	@Autowired
	private TriangulusService triangulusService;

	@Autowired
	private RestService restService;

	public List<MapeamentoDados> consultarXMLCaminhoZip()
			throws RestErrorException, ParseException, ClassNotFoundException {
		return consultarXMLCaminhoZip(consultarXMLNotaFiscalEletronicaNimbi());
	}

	private List<MapeamentoDados> consultarXMLCaminhoZip(NotaFiscalEletronicaNimbiResponse notaFiscalEletronica)
			throws ParseException, RestErrorException {

		List<MapeamentoDados> mapeamentoDadosList = new ArrayList<MapeamentoDados>();
		String nota = parametroService.getParametroByChave(ParametroService.PARAMETRO_TIPO_NOTA);
		String modelo = parametroService.getParametroByChave(ParametroService.PARAMETRO_MODELO_NOTA);

		notaFiscalEletronica.getNfeResponse().forEach(notaFiscal -> {

			try {

				if (notaFiscal.getStatus().equals(STATUS_NOTA_FISCAL_VALIDADO)) {
					PedGeraArquivo xmlObject = new PedGeraArquivo().setSerie(getSerie(notaFiscal.getReference()))
							.setNota(getNota(notaFiscal.getReference()))
							.setFilial(getFilial(notaFiscal.getSupplier().getSupplierCNPJ())).setTipo(nota)
							.setModelo(modelo);

					mapeamentoDadosList.add(new MapeamentoDados().setNfeNimbi(notaFiscal).setPedGeraArquivo(xmlObject)
							.setGerado((triangulusService.consultarXMLCaminhoZip(CharMatcher.breakingWhitespace()
									.removeFrom(XMLUtil.createXtream(CLASSE_PED_GERA_ARQUIVO).toXML(xmlObject))))));
				}
				
			} catch (ParseException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			} catch (RestErrorException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		});

		return mapeamentoDadosList;
	}

	public OrdemPedidoNimbiResponse consultarPedidoPorCodeERP(String erpCode)
			throws ParseException, RestErrorException {
		UriComponents uri = restNimbiConfig.getUriERPCode(erpCode);

		log.info("Endpoint de consulta ao Nimbi: {}", uri.toUriString());

		ResponseEntity<OrdemPedidoNimbiResponse> response = (ResponseEntity<OrdemPedidoNimbiResponse>) (restService
				.request(uri, restNimbiConfig.getHeaders(), HttpMethod.GET, "parameters",
						OrdemPedidoNimbiResponse.class));

		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

		return response.getBody();

	}

	private NotaFiscalEletronicaNimbiResponse consultarXMLNotaFiscalEletronicaNimbi()
			throws RestErrorException, ParseException {

		UriComponents uri = restNimbiConfig.getUriPeriodo(
				parametroService.getParametroByChave(ParametroService.PARAMETRO_DATA_CORTE), DataUtil.getDataHoje());

		log.info("Endpoint de consulta ao Nimbi: {}", uri.toUriString());
		ResponseEntity<NotaFiscalEletronicaNimbiResponse> response = (ResponseEntity<NotaFiscalEletronicaNimbiResponse>) (restService
				.request(uri, restNimbiConfig.getHeaders(), HttpMethod.GET, "parameters",
						NotaFiscalEletronicaNimbiResponse.class));

		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

		return response.getBody();

	}
	
	public ResponseEntity<RetornoGeracaoASNPost> postAdvancedShipmentNotificationPost(
			AdvancedShipmentNotificationPost advancedShipmentNotificationPost) throws ParseException, RestErrorException {
		
		UriComponents uri = restNimbiConfig.getUriPostAdvancedShipmentNotificationPost();
		
		log.info("Endpoint de POST ao Nimbi: {}", uri.toUriString());
        ResponseEntity<RetornoGeracaoASNPost> response = (ResponseEntity<RetornoGeracaoASNPost>) (restService
				.request(uri, restNimbiConfig.getHeaders(), HttpMethod.POST, advancedShipmentNotificationPost,
				        RetornoGeracaoASNPost.class));

		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());
		
		return response;
	}

	private String getFilial(String supplierCNPJ) {
		return supplierCNPJ.substring(supplierCNPJ.length() - 3);
	}

	private String getSerie(String reference) {
		String[] referenceSplit = reference.split("-");
		return referenceSplit[referenceSplit.length - 1];
	}

	private String getNota(String reference) {
		return reference.split("-")[0];
	}

}
