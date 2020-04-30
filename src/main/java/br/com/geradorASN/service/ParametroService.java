package br.com.geradorASN.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	public static String PARAMETRO_DATA_CORTE;
	public static String PARAMETRO_TIPO_NOTA;
	public static String PARAMETRO_MODELO_NOTA;
	public static String PARAMETRO_RECLAIM_ESTIMATED_HOUR;
	public static String PARAMETRO_DIAS_ATUALIZACAO_NFE;
	public static String PARAMETRO_SEQUENCIAL_ASN;
	public static String PARAMETRO_LINK_BIBNET;

	public ParametroService(@Value("${br.com.geradorASN.service.ParametroService.DataCorte}") String dataCorte,
			@Value("${br.com.geradorASN.service.ParametroService.TipoNota}") String tipoNota,
			@Value("${br.com.geradorASN.service.ParametroService.ModeloNota}") String modeloNota,
			@Value("${br.com.geradorASN.service.ParametroService.ReclaimEstimatedHour}") String reclaimEstimatedHour,
			@Value("${br.com.geradorASN.service.ParametroService.DiasAtualizacaoNFe}") String diasAtualizacaoNFe,
			@Value("${br.com.geradorASN.service.ParametroService.SequencialASN}") String sequencialASN,
			@Value("${br.com.geradorASN.service.ParametroService.LinkBibnet}") String linkBibnet) {

		PARAMETRO_DATA_CORTE = dataCorte;
		PARAMETRO_TIPO_NOTA = tipoNota;
		PARAMETRO_MODELO_NOTA = modeloNota;
		PARAMETRO_RECLAIM_ESTIMATED_HOUR = reclaimEstimatedHour;
		PARAMETRO_DIAS_ATUALIZACAO_NFE = diasAtualizacaoNFe;
		PARAMETRO_SEQUENCIAL_ASN = sequencialASN;
		PARAMETRO_LINK_BIBNET = linkBibnet;

	}
	
	public String getLinkBibnet() {
		return PARAMETRO_LINK_BIBNET;
	}

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
