package br.com.geradorASN.service.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponents;

import br.com.geradorASN.config.CredenciaisProd;

public class RestNimbiProd extends RestConfig {
	
	private static final String PROTOCOL 	= "https";
	private static final String HOST 		= "api001.nimbi.com.br";
	private static final String PORT 		= "443";
	
	private static final String GET_PATH	= "API/rest/NFe/ResponseProcess/v1"; 
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public RestNimbiProd() {
		super(PROTOCOL, HOST, PORT);
	}

	public UriComponents getUriPeriodo(String strInicio, String strFim) throws ParseException {
		
		Date dtInicio 				= sdf.parse(strInicio);
		Date dtFim 					= sdf.parse(strFim);
		
		SimpleDateFormat sdf 		= new SimpleDateFormat("yyyy-MM-dd");
		String dtInicioFormatada 	= sdf.format(dtInicio);
		String dtFimFormatada 		= sdf.format(dtFim);
		
		String path = GET_PATH + "?StartDate=" + dtInicioFormatada + "&EndDate=" + dtFimFormatada;
		return getUriComponents(path);
	}

	public HttpHeaders getHeaders() {
		return CredenciaisProd.getHeaders();
	}
	
}
