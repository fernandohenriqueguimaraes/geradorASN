package br.com.geradorASN.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.MapeamentoDados;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.exception.RestErrorException;

@Transactional
@Service("geradorASNService")
public class GeradorASNService {

	private static final Logger log = LoggerFactory.getLogger(GeradorASNService.class);

	@Autowired
	private NimbiService nimbiService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ZipService zipService;

	public List<AdvancedShipmentNotificationPost> gerarASN()
			throws RestErrorException, ParseException, IOException, ClassNotFoundException {

		List<MapeamentoDados> mapeamentoDadosList = zipService.consultarArquivosZip(nimbiService.consultarXMLCaminhoZip());
		// parametroService.updateParametroDataCorte();

		return mapeamentoDadosList.stream().map(MapeamentoDados::getAdvancedShipmentNotificationPost)
				.collect(Collectors.toList());

	}

}
