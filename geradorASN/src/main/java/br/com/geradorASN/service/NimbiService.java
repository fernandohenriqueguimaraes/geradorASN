package br.com.geradorASN.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.geradorASN.dao.ParametroDao;
import br.com.geradorASN.entity.rest.v1.get.response.NotaFiscalEletronicaNimbiResponse;
import br.com.geradorASN.entity.xml.PedGeraArquivo;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.config.RestConfig;

@Transactional
@Service("nimbiService")
public class NimbiService {
	
	private static final Logger log = LoggerFactory.getLogger(NimbiService.class);
	
	private static String PARAMETRO_DATA_CORTE = "DataCorte";
	
	private static String PARAMETRO_TIPO_NOTA = "TipoNota";
	
	private static String PARAMETRO_MODELO_NOTA = "ModeloNota";
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	
	private static String NOME_ALIAS_XML = "PedGeraArquivo";
	
	private static String PREFIXO_NOME_XML = "NOTA_FISCAL_NR_";
	
	private static String BASE_XML_PATH = "src/main/resources/xmlNimbi/";
	
	@Autowired
	private ParametroDao parametroRepository;

	@Autowired
	private RestConfig restConfig;

	@Autowired
	private RestService restService;
	
	public String gerarASN() throws RestErrorException, ParseException {
		
		gerarXML(consultarNimbi());
		
		return StringUtils.EMPTY;
		
	} 
	
	private void gerarXML(NotaFiscalEletronicaNimbiResponse notaFiscalEletronica) {
		
		XStream xstream = createXtream();
		xstream.alias(NOME_ALIAS_XML, PedGeraArquivo.class);
		
		notaFiscalEletronica.getNfeResponse().forEach(notaFiscal -> {
			
			PedGeraArquivo xmlObject = new PedGeraArquivo()
					.setSerie(getSerie(notaFiscal.getReference()))
					.setNota(getNota(notaFiscal.getReference()))
					.setFilial(getFilial(notaFiscal.getSupplier().getSupplierCNPJ()))
					.setTipo(getParametroByChave(PARAMETRO_TIPO_NOTA))
					.setModelo(getParametroByChave(PARAMETRO_MODELO_NOTA));
			
			FileWriter fw;
			try {
				fw = new FileWriter(BASE_XML_PATH + PREFIXO_NOME_XML + xmlObject.getNota() + ".xml");
				fw.write(xstream.toXML(xmlObject));
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@SuppressWarnings("unchecked")
	private NotaFiscalEletronicaNimbiResponse consultarNimbi() throws RestErrorException, ParseException {

		UriComponents uri = restConfig.getUriPeriodo(getParametroByChave(PARAMETRO_DATA_CORTE), getDataHoje());
		
		log.info("Endpoint de consulta ao Nimbi: {}", uri.getPath());
		ResponseEntity<NotaFiscalEletronicaNimbiResponse> response = (ResponseEntity<NotaFiscalEletronicaNimbiResponse>) 
				(restService.request(uri, 
						HttpMethod.GET,
				"parameters", 
				NotaFiscalEletronicaNimbiResponse.class));
		
		log.info("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

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
		return new XStream(new DomDriver());
	}
	
	private Gson createGsonBuilder() {
		return  (new GsonBuilder()).setPrettyPrinting().create();
	}

}
