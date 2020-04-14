package br.com.geradorASN.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.dao.ParametroDao;
import br.com.geradorASN.util.DataUtil;

@Transactional
@Service("parametroService")
public class ParametroService {
	
	private static final Logger log = LoggerFactory.getLogger(ParametroService.class);
	
	@Autowired
	private ParametroDao parametroRepository;
	
	public static String PARAMETRO_DATA_CORTE = "DataCorte";
	
	public String getParametroByChave(String parametro) {
		return parametroRepository.getParametroByChave(parametro).get(0).getValor();
	}
	
	public void updateParametroDataCorte() {
		String datahoje = DataUtil.getDataHoje();
		log.info("Atualizando o parâmetro" + PARAMETRO_DATA_CORTE + " para: " + datahoje);
		parametroRepository.updateParametroDataCorte(datahoje, PARAMETRO_DATA_CORTE);
	}

}
