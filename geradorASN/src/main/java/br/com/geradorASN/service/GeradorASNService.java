package br.com.geradorASN.service;

import java.text.ParseException;
import java.util.ArrayList;
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

	public List<Gerado> consultarArquivosZip() throws RestErrorException, ParseException {

		List<Gerado> listaGerado = new ArrayList<Gerado>();
		listaGerado = nimbiService.consultarArquivosZip();

		return listaGerado;

	}

}
