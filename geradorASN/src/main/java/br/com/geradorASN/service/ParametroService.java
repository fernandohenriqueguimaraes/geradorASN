package br.com.geradorASN.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.dao.ParametroDao;
import br.com.geradorASN.util.DataUtil;

@Transactional
@Service("parametroService")
public class ParametroService {
	
	@Autowired
	private ParametroDao parametroRepository;
	
	public static String PARAMETRO_DATA_CORTE = "DataCorte";
	
	public String getParametroByChave(String parametro) {
		return parametroRepository.getParametroByChave(parametro).get(0).getValor();
	}
	
	public void updateParametroDataCorte() {
		parametroRepository.updateParametroDataCorte(DataUtil.getDataHoje(), PARAMETRO_DATA_CORTE);
	}

}
