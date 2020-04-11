package br.com.geradorASN.exception.handler;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RestError {

	@SerializedName("StatusCode")
	private Integer statusCode;

	@SerializedName("Errors")
	private List<String> errors;

	private String requestURI;

	private String request;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "{\"statusCode\":\"" + statusCode + "\",\"errors\":\"" + errors + "\"}";
	}

}
