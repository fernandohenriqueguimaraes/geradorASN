package br.com.geradorASN.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.exception.RestErrorException;

@Transactional
@Service("geradorASNService")
public class GeradorASNService {

	@Autowired
	private NimbiService nimbiService;
	
	@Autowired
	private ParametroService parametroService;
	
	@Autowired
	private ZipService zipService;

	public List<Gerado> consultarArquivosZip() throws RestErrorException, ParseException, IOException, ClassNotFoundException {

		List<Gerado> listaGerado = new ArrayList<Gerado>();
		listaGerado = nimbiService.consultarArquivosZip();
		zipService.baixarArquivosZip(listaGerado);
		// parametroService.updateParametroDataCorte();
		return listaGerado;

	}
	


}
