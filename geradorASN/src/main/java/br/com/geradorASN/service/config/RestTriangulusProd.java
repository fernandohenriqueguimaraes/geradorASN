package br.com.geradorASN.service.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import br.com.geradorASN.config.CredenciaisProd;

@Component
@Qualifier("restTriangulusProd")
public class RestTriangulusProd extends RestTriangulusConfig {

	private static final String PROTOCOL 	= "http";
	private static final String HOST 		= "nfe.triangulus.com.br";
	
	private static final String GET_PATH	= "WsDisponibilizaArquivo/wsDisponibilizaArquivo.asmx/PedGeraArquivo"; 
	
	@Autowired
	public RestTriangulusProd() {
		super(PROTOCOL, HOST);
	}

	@Override
	public UriComponents getUriXML(String xml) throws ParseException {
		
		String path = GET_PATH + "?xml=" + xml;
		return getUriComponents(path);
	}
	
	@Override
	public HttpHeaders getHeaders() {
		return CredenciaisProd.getHeadersForTriangulus();
	}

}
