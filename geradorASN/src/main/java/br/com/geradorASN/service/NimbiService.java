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

@Transactional
@Service("nimbiService")
public class NimbiService {
	
	private static final Logger log = LoggerFactory.getLogger(NimbiService.class);
	
	private static String PARAMETRO_DATA_CORTE = "DataCorte";
	
	private static String PARAMETRO_TIPO_NOTA = "TipoNota";
	
	private static String PARAMETRO_MODELO_NOTA = "ModeloNota";
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	
	private static String NOME_ALIAS_XML_ENTRADA = "PedGeraArquivo";
	
	@Autowired
	private ParametroDao parametroRepository;

	@Autowired
	private RestNimbiConfig restNimbiConfig;
	
	@Autowired
	private TriangulusService triangulusService;

	@Autowired
	private RestService restService;
	
	public List<Gerado> gerarASN() throws RestErrorException, ParseException {
		
		return gerarXML(consultarNimbi());
		
	} 
	
	private List<Gerado> gerarXML(NotaFiscalEletronicaNimbiResponse notaFiscalEletronica) throws ParseException, RestErrorException {
		
		List<Gerado> listaGerado = new ArrayList<Gerado>();
		
		notaFiscalEletronica.getNfeResponse().forEach(notaFiscal -> {
			
			PedGeraArquivo xmlObject = new PedGeraArquivo()
					.setSerie(getSerie(notaFiscal.getReference()))
					.setNota(getNota(notaFiscal.getReference()))
					.setFilial(getFilial(notaFiscal.getSupplier().getSupplierCNPJ()))
					.setTipo(getParametroByChave(PARAMETRO_TIPO_NOTA))
					.setModelo(getParametroByChave(PARAMETRO_MODELO_NOTA));
			
			try {
				listaGerado.add(triangulusService.consultarDetalhesNotaFiscalTriangulus(CharMatcher.breakingWhitespace()
				            .removeFrom(createXtream().toXML(xmlObject))));
				
			} catch (ParseException ex) {
				ex.printStackTrace();
			} catch (RestErrorException ex) {
				ex.printStackTrace();
			}
			
		});
		
		return listaGerado;
	}

	@SuppressWarnings("unchecked")
	private NotaFiscalEletronicaNimbiResponse consultarNimbi() throws RestErrorException, ParseException {

		UriComponents uri = restNimbiConfig.getUriPeriodo(getParametroByChave(PARAMETRO_DATA_CORTE), getDataHoje());
		
		log.info("Endpoint de consulta ao Nimbi: {}", uri.toUriString());
		ResponseEntity<NotaFiscalEletronicaNimbiResponse> response = (ResponseEntity<NotaFiscalEletronicaNimbiResponse>) 
				(restService.request(uri, 
						restNimbiConfig.getHeaders(),
						HttpMethod.GET,
				"parameters", 
				NotaFiscalEletronicaNimbiResponse.class));
		
		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

		return response.getBody();

	}
	
	private String getParametroByChave(String parametro) {
		return parametroRepository.getParametroByChave(parametro).get(0).getValor();
	}
	
	private String getDataHoje() {
		return (new SimpleDateFormat(FORMATO_DATA_ENTRADA)).format(new Date());
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
	
	private XStream createXtream() {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(NOME_ALIAS_XML_ENTRADA, PedGeraArquivo.class);
		Class<?>[] classes = new Class[] { PedGeraArquivo.class };
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(classes);
		
		return xstream;
	}

}