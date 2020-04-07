package br.com.geradorASN.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CredenciaisProd {

	private static final String CLIENTAPI_ID 	= "ClientAPI_ID";
	private static final String CLIENTAPI_KEY 	= "ClientAPI_Key";
	
	private static final String ID 				= "b0d4bbcf-ff2f-474c-81f3-40eb79026151";
	private static final String KEY 			= "ea3fdbe7-be1b-4437-b513-1fd13d008ee1";	

	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();            
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(CLIENTAPI_ID, ID);
		headers.set(CLIENTAPI_KEY, KEY);
		return headers;
	}

}

