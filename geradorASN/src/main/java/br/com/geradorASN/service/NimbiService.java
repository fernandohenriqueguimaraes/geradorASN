package br.com.geradorASN.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;

import br.com.geradorASN.dao.ParametroDao;
import br.com.geradorASN.entity.rest.v1.get.response.NotaFiscalEletronicaNimbiResponse;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.service.config.RestConfig;

@Transactional
@Service("nimbiService")
public class NimbiService {
	
	private static final Logger log = LoggerFactory.getLogger(NimbiService.class);
	
	private static String DATA_CORTE = "DataCorte";
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	
	@Autowired
	private ParametroDao parametroRepository;

	@Autowired
	private RestConfig restConfig;

	@Autowired
	private RestService restService;
	
	public String gerarASN() throws RestErrorException, ParseException {
		
		NotaFiscalEletronicaNimbiResponse responseBody = consultarNimbi();
		
		return responseBody.toString();
	} 

	@SuppressWarnings("unchecked")
	public NotaFiscalEletronicaNimbiResponse consultarNimbi() throws RestErrorException, ParseException {

		UriComponents uri = restConfig.getUriPeriodo(getDataCorte(), getDataHoje());
		
		log.info("Endpoint de consulta ao Nimbi: {}", uri.getPath());
		ResponseEntity<NotaFiscalEletronicaNimbiResponse> response = (ResponseEntity<NotaFiscalEletronicaNimbiResponse>) (restService.request(uri, HttpMethod.GET,
				"parameters", NotaFiscalEletronicaNimbiResponse.class));
		
		log.info("Status Code: {}, Response: {}", response.getStatusCode(), response.getBody());

		return response.getBody();

	}
	
	private String getDataCorte() {
		return parametroRepository.getParametroByChave(DATA_CORTE).get(0).getValor();
	}
	
	private String getDataHoje() {
		return (new SimpleDateFormat(FORMATO_DATA_ENTRADA)).format(new Date());
	}

}
