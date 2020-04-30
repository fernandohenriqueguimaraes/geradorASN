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
import br.com.geradorASN.util.XMLUtil;

@Transactional
@Service("triangulusService")
public class TriangulusService {

	private static final Logger log = LoggerFactory.getLogger(TriangulusService.class);

	private static String CLASSE_GERADO = "Gerado";

	@Autowired
	RestTriangulusProd restTriangulusConfig;

	@Autowired
	private RestService restService;

	public Gerado consultarXMLCaminhoZip(String xml) throws ParseException, RestErrorException, ClassNotFoundException {

		UriComponents uri = restTriangulusConfig.getUriXML(xml);

		log.info("Endpoint de consulta ao Triangulus: {}", uri.toUriString());

		@SuppressWarnings("unchecked")
		ResponseEntity<String> response = (ResponseEntity<String>) (restService.request(uri,
				restTriangulusConfig.getHeaders(), HttpMethod.GET, "parameters", String.class));

		String fixedXml = tratamentoStringTriangulus(response.getBody());
		log.debug("Status Code: {}, Response: {}", response.getStatusCode(), fixedXml);

		return (Gerado) XMLUtil.createXtream(CLASSE_GERADO).fromXML(fixedXml);

	}

	private String tratamentoStringTriangulus(String xml) {
		return StringUtils.replaceEach(CharMatcher.breakingWhitespace().removeFrom(xml),
				new String[] { "&lt;", "&quot;", "&apos;", "&gt;", 
						"<?xmlversion=\"1.0\"encoding=\"utf-8\"?><stringxmlns=\"http://www.triangulus.com.br/\">",
						"</string>", "?xml=" },
				new String[] { "<", "\"", "'", ">", StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY});
	}

}
