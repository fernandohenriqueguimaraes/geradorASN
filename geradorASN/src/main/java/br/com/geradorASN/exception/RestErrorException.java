package br.com.geradorASN.exception;

import br.com.geradorASN.exception.handler.RestError;

public class RestErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private RestError error;

	public RestErrorException(RestError error) {
		this.error = error;
	}

	public RestError getError() {
		return error;
	}

}
