package br.com.geradorASN.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.geradorASN.dao.ParametroDao;
import br.com.geradorASN.entity.rest.v1.get.response.NotaFiscalEletronicaNimbiResponse;
import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.entity.xml.PedGeraArquivo;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.config.RestNimbiConfig;
import br.com.geradorASN.util.DataUtil;
import br.com.geradorASN.util.XMLUtil;

@Transactional
@Service("nimbiService")
public class NimbiService {

	private static final Logger log = LoggerFactory.getLogger(NimbiService.class);

	private static String PARAMETRO_TIPO_NOTA = "TipoNota";

	private static String PARAMETRO_MODELO_NOTA = "ModeloNota";

	private static String CLASSE_PED_GERA_ARQUIVO = "PedGeraArquivo";

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private RestNimbiConfig restNimbiConfig;

	@Autowired
	private TriangulusService triangulusService;

	@Autowired
	private RestService restService;

	public List<Gerado> consultarArquivosZip() throws RestErrorException, ParseException, ClassNotFoundException {
		return consultarXMLCaminhoZip(consultarXMLNotaFiscalEletronicaNimbi());
	}

	private List<Gerado> consultarXMLCaminhoZip(NotaFiscalEletronicaNimbiResponse notaFiscalEletronica)
			throws ParseException, RestErrorException {

		List<Gerado> listaGerado = new ArrayList<Gerado>();
		String nota = parametroService.getParametroByChave(PARAMETRO_TIPO_NOTA);
		String modelo = parametroService.getParametroByChave(PARAMETRO_MODELO_NOTA);

		notaFiscalEletronica.getNfeResponse().forEach(notaFiscal -> {

			PedGeraArquivo xmlObject = new PedGeraArquivo().setSerie(getSerie(notaFiscal.getReference()))
					.setNota(getNota(notaFiscal.getReference()))
					.setFilial(getFilial(notaFiscal.getSupplier().getSupplierCNPJ())).setTipo(nota).setModelo(modelo);

			try {
				
				listaGerado.add(triangulusService.consultarXMLCaminhoZip(CharMatcher.breakingWhitespace()
						.removeFrom(XMLUtil.createXtream(CLASSE_PED_GERA_ARQUIVO).toXML(xmlObject))));

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

		return listaGerado;
	}

	@SuppressWarnings("unchecked")
	private NotaFiscalEletronicaNimbiResponse consultarXMLNotaFiscalEletronicaNimbi()
			throws RestErrorException, ParseException {

		UriComponents uri = restNimbiConfig.getUriPeriodo(parametroService.getParametroByChave(parametroService.PARAMETRO_DATA_CORTE),
				DataUtil.getDataHoje());

		log.info("Endpoint de consulta ao Nimbi: {}", uri.toUriString());
		ResponseEntity<NotaFiscalEletronicaNimbiResponse> response = (ResponseEntity<NotaFiscalEletronicaNimbiResponse>) (restService
				.request(uri, restNimbiConfig.getHeaders(), HttpMethod.GET, "parameters",
						NotaFiscalEletronicaNimbiResponse.class));

		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

		return response.getBody();

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
