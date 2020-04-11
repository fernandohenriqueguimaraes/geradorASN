package br.com.geradorASN.service.config;

import java.text.ParseException;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class RestTriangulusConfig {

	private String protocol;
	private String host;
	
	public RestTriangulusConfig(String protocol, String host) {
		this.protocol = protocol;
		this.host = host;
	}

	protected UriComponents getUriComponents(String path) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme(protocol)
				.host(host)
				.path(path)
				.build();
		return uri;
	}
	
	public abstract UriComponents getUriXML(String xml) throws ParseException;	
	public abstract HttpHeaders getHeaders();
}
