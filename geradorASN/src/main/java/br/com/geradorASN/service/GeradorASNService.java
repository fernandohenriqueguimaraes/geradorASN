package br.com.geradorASN.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.Empresa;
import br.com.geradorASN.entity.MapeamentoDados;
import br.com.geradorASN.entity.Produto;
import br.com.geradorASN.entity.Relatorio;
import br.com.geradorASN.entity.Enum.RelatorioStatusEnum;
import br.com.geradorASN.entity.Enum.TipoProdutoEnum;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.entity.rest.v4.get.response.OrdemPedidoNimbiResponse;
import br.com.geradorASN.entity.rest.v4.get.response.OrderItems;
import br.com.geradorASN.exception.EmpresaNotFoundException;
import br.com.geradorASN.exception.ProdutoNotFoundException;
import br.com.geradorASN.exception.RestErrorException;
import br.com.geradorASN.util.DataUtil;

@Transactional
@Service("geradorASNService")
public class GeradorASNService {

	private static final Logger log = LoggerFactory.getLogger(GeradorASNService.class);

	private static String OBSERVATION_TEXT_DEFAULT_VALUE;
	private static String ASN_INITIAL_STATUS;
	private static String PREFIXO_CODIGO_ASN;
	private static String QUANTIDADE_DIGITOS_ASN;
	private static String CODIGO_SPECIAL_PROCESS_CODE;
	private static String CODIGO_SUPPLIER_COUNTRY_CODE;
	private static String DEFAULT_FRAGILE_LOAD_STATUS;
	private static String DEFAULT_TRANSPORTATION_MODE_CODE;
	private static String DEFAULT_TRANSPORTATION_TYPE;
	private static String DEFAULT_USERNAME;

	private Integer sequencial;

	@Autowired
	private NimbiService nimbiService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private RelatorioService relatorioService;

	@Autowired
	private ZipService zipService;

	public GeradorASNService(
			@Value("${br.com.geradorASN.service.GeradorASNService.ObservationTextValue}") String observationTextValue,
			@Value("${br.com.geradorASN.service.GeradorASNService.ASNInitialStatus}") String asnInitialStatus,
			@Value("${br.com.geradorASN.service.GeradorASNService.PrefixoCodigoASN}") String prefixoCodigoASN,
			@Value("${br.com.geradorASN.service.GeradorASNService.QuantidadeDigitosASN}") String quantidadeDigitosASN,
			@Value("${br.com.geradorASN.service.GeradorASNService.CodigoEspecialProcessCode}") String codigoEspecialProcessCode,
			@Value("${br.com.geradorASN.service.GeradorASNService.CodigoSupplierCountryCode}") String codigoSupplierCountryCode,
			@Value("${br.com.geradorASN.service.GeradorASNService.DefaultFragileLoadStatus}") String defaultFragileLoadStatus,
			@Value("${br.com.geradorASN.service.GeradorASNService.DefaultTransportationModeCode}") String defaultTransportationModeCode,
			@Value("${br.com.geradorASN.service.GeradorASNService.DefaultTransportationType}") String defaultTransportationType,
			@Value("${br.com.geradorASN.service.GeradorASNService.DefaultUsername}") String defaultUsername) {

		OBSERVATION_TEXT_DEFAULT_VALUE = observationTextValue;
		ASN_INITIAL_STATUS = asnInitialStatus;
		PREFIXO_CODIGO_ASN = prefixoCodigoASN;
		QUANTIDADE_DIGITOS_ASN = quantidadeDigitosASN;
		CODIGO_SPECIAL_PROCESS_CODE = codigoEspecialProcessCode;
		CODIGO_SUPPLIER_COUNTRY_CODE = codigoSupplierCountryCode;
		DEFAULT_FRAGILE_LOAD_STATUS = defaultFragileLoadStatus;
		DEFAULT_TRANSPORTATION_MODE_CODE = defaultTransportationModeCode;
		DEFAULT_TRANSPORTATION_TYPE = defaultTransportationType;
		DEFAULT_USERNAME = defaultUsername;

	}

	public List<AdvancedShipmentNotificationPost> gerarASN() throws RestErrorException, ParseException, IOException,
			ClassNotFoundException, EmpresaNotFoundException, ProdutoNotFoundException {

		List<AdvancedShipmentNotificationPost> advancedShipmentNotificationPostList = gerarRelatorio(
				zipService.consultarArquivosZip(nimbiService.consultarXMLCaminhoZip()));

		parametroService.updateParametroDataCorte();

		return advancedShipmentNotificationPostList;

	}

	private List<AdvancedShipmentNotificationPost> gerarRelatorio(List<MapeamentoDados> mapeamentoDadosList)
			throws EmpresaNotFoundException, ProdutoNotFoundException {

		sequencial = Integer.parseInt(parametroService.getParametroByChave(ParametroService.PARAMETRO_SEQUENCIAL_ASN));
		List<AdvancedShipmentNotificationPost> listaNFeASN = new ArrayList<AdvancedShipmentNotificationPost>();

		mapeamentoDadosList.forEach(mapeamento -> {

			String cnpj = mapeamento.getNfeNimbi().getSupplier().getSupplierCNPJ();
			List<Empresa> empresas = empresaService.getEmpresaByCnpj(cnpj);

			if (empresas.isEmpty()) {
				throw new EmpresaNotFoundException("CNPJ não encontrado na tabela Empresa.");
			}

			List<Produto> produtos = produtoService.getProdutoByCad(mapeamento.getCodigoProduto());

			if (produtos.isEmpty()) {
				throw new ProdutoNotFoundException("CAD Michelan não encontrado na tabela Produto.");
			}

			Empresa empresa = empresas.get(0);
			Produto produto = produtos.get(0);

			if (empresa.isGeraASN() && !produto.getTipoProduto().equals(TipoProdutoEnum.MEMS.getDescricao())) {

				mapeamento.getAdvancedShipmentNotificationPost().setNfeNumber(mapeamento.getNfeNimbi().getReference());
				mapeamento.getAdvancedShipmentNotificationPost().setAsnNumber(gerarSequencialASNNumber());
				mapeamento.setAdvancedShipmentNotificationPost(complementarInfoAdvancedShipmentNotificationPost(
						mapeamento.getAdvancedShipmentNotificationPost(), empresa, produto));

				relatorioService.salvarRelatorio(new Relatorio().setReference(mapeamento.getNfeNimbi().getReference())
						.setStatus(RelatorioStatusEnum.ASN_GERADO.getDescricao())
						.setNumeroASN(mapeamento.getAdvancedShipmentNotificationPost().getAsnNumber()));

				listaNFeASN.add(mapeamento.getAdvancedShipmentNotificationPost());

			} else {
				relatorioService.salvarRelatorio(new Relatorio().setReference(mapeamento.getNfeNimbi().getReference())
						.setStatus(RelatorioStatusEnum.NAO_SE_APLICA.getDescricao()));

			}

		});

		parametroService.atualizarParametro(sequencial.toString(), ParametroService.PARAMETRO_SEQUENCIAL_ASN);

		return listaNFeASN;

	}

	private AdvancedShipmentNotificationPost complementarInfoAdvancedShipmentNotificationPost(
			AdvancedShipmentNotificationPost advancedShipmentNotificationPost, Empresa empresa, Produto produto) {

		try {

			OrdemPedidoNimbiResponse pedidoResponse = nimbiService.consultarPedidoPorCodeERP(
					advancedShipmentNotificationPost.getASNItems().get(0).getPurchaseOrder().getERPCode());

			// Apenas para continuar testando, tirar validação depois
			if (!pedidoResponse.getPurchaseOrderGroupGetAPI().isEmpty()) {

				advancedShipmentNotificationPost.getIncoterm().setCode(
						pedidoResponse.getPurchaseOrderGroupGetAPI().get(0).getPurchaseOrder().getIncotermCode());
				advancedShipmentNotificationPost.getIncoterm().setDescription(pedidoResponse
						.getPurchaseOrderGroupGetAPI().get(0).getPurchaseOrder().getIncotermDescription());
				advancedShipmentNotificationPost.getCompany().setCountryCode(
						pedidoResponse.getPurchaseOrderGroupGetAPI().get(0).getPurchaseOrder().getBuyerCountryCode());
				advancedShipmentNotificationPost.getCompany().setFiscalIdentifier(
						pedidoResponse.getPurchaseOrderGroupGetAPI().get(0).getPurchaseOrder().getBuyerTaxNumber());
				advancedShipmentNotificationPost.getASNItems().get(0).getPurchaseOrder().setPurchaseOrderNumber(
						pedidoResponse.getPurchaseOrderGroupGetAPI().get(0).getPurchaseOrder().getId().toString());

				List<OrderItems> orderItems = pedidoResponse.getPurchaseOrderGroupGetAPI().get(0).getOrderItems()
						.stream()
						.filter(item -> advancedShipmentNotificationPost.getASNItems().get(0).getPurchaseOrder()
								.getPurchaseOrderItem().getPurchaseOrderItemNumber().equals(item.getLineERP()))
						.collect(Collectors.toList());

				advancedShipmentNotificationPost.getASNItems().get(0).getPurchaseOrder().getPurchaseOrderItem()
						.setSupplierItemNumber(orderItems.get(0).getCode());

				advancedShipmentNotificationPost.getASNItems().get(0).getUnitOfMeasurement()
						.setCode(orderItems.get(0).getUnitOfMeasureCode());
				advancedShipmentNotificationPost.getASNItems().get(0).getUnitOfMeasurement()
						.setDescription(orderItems.get(0).getUnitOfMeasureDescription());

				advancedShipmentNotificationPost.getASNItems().get(0).getPurchaseOrder().getPurchaseOrderItem()
						.setIsServiceType(true);
			}

			advancedShipmentNotificationPost.setObservationTEXT(OBSERVATION_TEXT_DEFAULT_VALUE);
			advancedShipmentNotificationPost.setAsnStatus(ASN_INITIAL_STATUS);
			advancedShipmentNotificationPost.setSpecialProcessCode(CODIGO_SPECIAL_PROCESS_CODE);
			advancedShipmentNotificationPost.setSupplierCountryCode(CODIGO_SUPPLIER_COUNTRY_CODE);
			advancedShipmentNotificationPost.setFragileLoadStatus(DEFAULT_FRAGILE_LOAD_STATUS);
			advancedShipmentNotificationPost.setTransportationModeCode(DEFAULT_TRANSPORTATION_MODE_CODE);
			advancedShipmentNotificationPost.setTransportationType(DEFAULT_TRANSPORTATION_TYPE);
			advancedShipmentNotificationPost.setUsername(DEFAULT_USERNAME);
			advancedShipmentNotificationPost.setRegisterCreationHour(DataUtil.getRegisterCreationHour());

			advancedShipmentNotificationPost.setHasShiptToInItem(true);

			advancedShipmentNotificationPost.getReclaimOrigin().getAddress().setRegionCode(empresa.getUf());
			advancedShipmentNotificationPost.getShipTo().getAddress().setRegionCode(empresa.getUf());
			advancedShipmentNotificationPost.setShipCityTaxCode(empresa.getIbgeCode());
			advancedShipmentNotificationPost.setVolumeCapacity(produto.getVolume());
			advancedShipmentNotificationPost.setTotalHeightMeasure(produto.getAltura());
			advancedShipmentNotificationPost.setTotalLenghtMeasure(produto.getComprimento());
			advancedShipmentNotificationPost.setTotalWidthMeasure(produto.getLargura());
			advancedShipmentNotificationPost.setReclaimEstimatedHour(
					parametroService.getParametroByChave(ParametroService.PARAMETRO_RECLAIM_ESTIMATED_HOUR));
			advancedShipmentNotificationPost.setReclaimEstimatedDate(calculoReclaimEstimatedDate());

		} catch (ParseException | RestErrorException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return advancedShipmentNotificationPost;
	}

	private String calculoReclaimEstimatedDate() {
		return DataUtil.formatarData(DataUtil.calcularProximosXdias(
				parametroService.getParametroByChave(ParametroService.PARAMETRO_DIAS_ATUALIZACAO_NFE)));
	}

	private String gerarSequencialASNNumber() {
		return (PREFIXO_CODIGO_ASN + String.format("%" + "0" + QUANTIDADE_DIGITOS_ASN + "d", sequencial++));
	}

}
