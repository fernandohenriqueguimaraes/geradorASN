package br.com.geradorASN.service;

import java.beans.XMLEncoder;
import java.text.ParseException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.config.RestTriangulusProd;

@Transactional
@Service("triangulusService")
public class TriangulusService {
	
	private static final Logger log = LoggerFactory.getLogger(TriangulusService.class);
	
	private static String NOME_ALIAS_XML_SAIDA = "Gerado";

	@Autowired
	RestTriangulusProd restTriangulusConfig;
	
	@Autowired
	private RestService restService;
	
	public Gerado consultarDetalhesNotaFiscalTriangulus(String xml) throws ParseException, RestErrorException {
		
		UriComponents uri = restTriangulusConfig.getUriXML(xml);
		
		log.info("Endpoint de consulta ao Triangulus: {}", uri.toUriString());
		
		@SuppressWarnings("unchecked")
		ResponseEntity<String> response = (ResponseEntity<String>) 
				(restService.request(uri, 
						restTriangulusConfig.getHeaders(),
						HttpMethod.GET,
						"parameters", 
						String.class));
		
		String fixedXml = StringUtils.replaceEach(CharMatcher.breakingWhitespace()
	            .removeFrom(response.getBody()), new String[]{"&lt;","&quot;","&apos;","&gt;", "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><stringxmlns=\"http://www.triangulus.com.br/\">", "</string>"}, new String[]{"<","\"","'",">", StringUtils.EMPTY, StringUtils.EMPTY});
		
		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), fixedXml);

	return (Gerado) createXtream().fromXML(fixedXml);

	}
	
	private XStream createXtream() {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(NOME_ALIAS_XML_SAIDA, Gerado.class);
		Class<?>[] classes = new Class[] { Gerado.class };
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(classes);
		
		return xstream;
	}
	
}
