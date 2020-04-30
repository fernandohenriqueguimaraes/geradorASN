package br.com.geradorASN.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.exception.handler.RestError;

@Service("restService")
public class RestService {

	private RestTemplate restTemplate;
	
	public RestService() {
		restTemplate = new RestTemplate();
	}

	public ResponseEntity<?> request(UriComponents uri, HttpHeaders headers, HttpMethod httpMethod, Object request, Class<?> clazz) throws RestErrorException {
		try {
			return restTemplate.exchange(uri.toUriString(), httpMethod, new HttpEntity<>(request, headers), clazz);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			RestError error = new RestError();
			error.setRequestURI(uri.toString());
			error.setRequest(request + "");
			error.setStatusCode(e.getStatusCode().value());
			error.setErrors(Arrays.asList(e.getMessage(), e.getCause() != null ? e.getCause().toString() : "", e.getResponseHeaders().toString()));
			throw new RestErrorException(error);
		}
	}

}
