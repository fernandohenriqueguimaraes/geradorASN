package br.com.geradorASN.service.config;

import java.text.ParseException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class RestConfig {
	
	private String protocol;
	private String host;
	private String port;
	
	public RestConfig(String protocol, String host, String port) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
	}

	protected UriComponents getUriComponents(String path) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme(protocol)
				.host(host)
				.port(port)
				.path(path)
				.build();
		return uri;
	}
	
	public abstract UriComponents getUriPeriodo(String strInicio, String strFim) throws ParseException;	
	public abstract HttpHeaders getHeaders();
}
