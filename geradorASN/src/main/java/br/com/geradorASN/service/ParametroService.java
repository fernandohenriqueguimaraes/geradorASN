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
	
	public static String PARAMETRO_TIPO_NOTA = "TipoNota";

	public static String PARAMETRO_MODELO_NOTA = "ModeloNota";
	
	public static String PARAMETRO_RECLAIM_ESTIMATED_HOUR = "ReclaimEstimatedHour";
	
	public static String PARAMETRO_DIAS_ATUALIZACAO_NFE = "DiasAtualizacaoNFe";
	
	public static String PARAMETRO_SEQUENCIAL_ASN		= "SequencialASN";
	
	public String getParametroByChave(String parametro) {
		return parametroRepository.getParametroByChave(parametro).get(0).getValor();
	}
	
	public void atualizarParametro(String valor, String chave) {
		parametroRepository.updateParametro(valor, chave);
	}
	
	public void updateParametroDataCorte() {
		String datahoje = DataUtil.getDataHoje();
		log.info("Atualizando o parâmetro" + PARAMETRO_DATA_CORTE + " para: " + datahoje);
		parametroRepository.updateParametro(datahoje, PARAMETRO_DATA_CORTE);
	}

}
