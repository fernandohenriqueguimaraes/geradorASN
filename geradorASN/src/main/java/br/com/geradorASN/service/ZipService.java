package br.com.geradorASN.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.geradorASN.entity.MapeamentoDados;
import br.com.geradorASN.entity.rest.v1.post.request.ASNItem;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.util.DataUtil;

@Transactional
@Service("zipService")
public class ZipService {

	private static final Logger log = LoggerFactory.getLogger(ZipService.class);

	private static String ZIP_DESTINATION_FOLDER;
	private static String XML_DESTINATION_FOLDER;

	private static String CODIGO_XML_TAG_RAIZ  		       			      = "nfeProc";
	private static String CODIGO_XML_CODIGO_PRODUTO        				  = "cProd";
	private static String CODIGO_XML_NUMERO_PEDIDO      			      = "xPed";
	private static String CODIGO_XML_CODIGO_ERP  	     				  = "xPed";
	private static String CODIGO_XML_DESCRICAO_ITEM        				  = "xProd";
	private static String CODIGO_XML_NCM_ITEM 		      			      = "NCM";
	private static String CODIGO_XML_QUANTIDADE_VOLUME    				  = "qVol";
	private static String CODIGO_XML_RAZAO_SOCIAL      	   				  = "xNome";
	private static String CODIGO_XML_QUANTIDADE_ITEM       			      = "qCom";
	private static String CODIGO_XML_CNPJ			   	   				  = "CNPJ";
	private static String CODIGO_XML_ENDERECO_LOGRADOURO  				  = "xLgr";
	private static String CODIGO_XML_ENDERECO_NUMERO      				  = "nro";
	private static String CODIGO_XML_ENDERECO_COMPLEMENTO  				  = "xCpl";
	private static String CODIGO_XML_ENDERECO_BAIRRO      				  = "xBairro";
	private static String CODIGO_XML_ENDERECO_CEP     	 				  = "CEP";
	private static String CODIGO_XML_ENDERECO_MUNICIPIO  				  = "xMun";
	private static String CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO		   	  = "cMun";
	private static String CODIGO_XML_ENDERECO_TELEFONE   				  = "fone";
	private static String CODIGO_XML_VALOR_NOTA_FISCAL			          = "vNF";
	private static String CODIGO_XML_DATA_EMISSAO				          = "dhEmi";
	private static String CODIGO_XML_CHAVE_ACESSO_NOTA_FISCAL_ELETRONICA  = "infNFe";
	private static String CODIGO_XML_PESO_BRUTO_TOTAL				      = "pesoB";
	private static String CODIGO_XML_CODIGO_ISO_PAIS				      = "xPais";
	private static String CODIGO_XML_CODIGO_INTERNO_FORNECEDOR 			  = "nItemPed";
	private static String RECLAIM_ORIGIN_CITY_CODE_PREFIX				  = "BR";
	
	public ZipService(@Value("${br.com.geradorASN.service.ZipService.zipDestinationFolder}") String zipDestinationFolder,
			@Value("${br.com.geradorASN.service.ZipService.xmlDestinationFolder}") String xmlDestinationFolder) {
		ZIP_DESTINATION_FOLDER = zipDestinationFolder;
		XML_DESTINATION_FOLDER = xmlDestinationFolder;
	}

	public List<MapeamentoDados> consultarArquivosZip(List<MapeamentoDados> mapeamentoDadosList)
			throws IOException, ZipException {

		File xmlDestinationDirectory = createFileDirectory(XML_DESTINATION_FOLDER);
		File zipDestinationDirectory = createFileDirectory(ZIP_DESTINATION_FOLDER);

		mapeamentoDadosList.forEach(mapeamento -> {
			try {
				baixarZip(mapeamento.getGerado());
				extrairZip(mapeamento.getGerado());
				deleteFile(ZIP_DESTINATION_FOLDER, mapeamento.getGerado().getFileName());
				mapeamento = lerXMLExtraido(mapeamento);
				deleteFile(XML_DESTINATION_FOLDER, mapeamento.getGerado().getFileNameXMLExtension());
			} catch (IOException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			} catch (ParserConfigurationException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			} catch (SAXException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			}

		});

		deleteFileDirectory(zipDestinationDirectory);
		deleteFileDirectory(xmlDestinationDirectory);

		return mapeamentoDadosList;

	}

	private MapeamentoDados lerXMLExtraido(MapeamentoDados mapeamento)
			throws ClassNotFoundException, ParserConfigurationException, SAXException, IOException {

		File file = new File(XML_DESTINATION_FOLDER + mapeamento.getGerado().getFileNameXMLExtension());
		AdvancedShipmentNotificationPost advancedShipmentNotificationPost = new AdvancedShipmentNotificationPost();
		ASNItem asnItem = new ASNItem();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document nfeTriangulusDocumentBuilder = db.parse(file);

		nfeTriangulusDocumentBuilder.getDocumentElement().normalize();

		log.info("Realizando leitura do XML " + mapeamento.getGerado().getFileNameXMLExtension());

		NodeList nodeList = nfeTriangulusDocumentBuilder.getElementsByTagName(CODIGO_XML_TAG_RAIZ);

		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				mapeamento.setCodigoProduto(eElement.getElementsByTagName(CODIGO_XML_CODIGO_PRODUTO).item(0) != null
						? eElement.getElementsByTagName(CODIGO_XML_CODIGO_PRODUTO).item(0).getTextContent()
						: StringUtils.EMPTY);
				asnItem.getPurchaseOrder()
						.setPurchaseOrderNumber(eElement.getElementsByTagName(CODIGO_XML_NUMERO_PEDIDO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_NUMERO_PEDIDO).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getPurchaseOrder().getPurchaseOrderItem()
						.setPurchaseOrderItemNumber(eElement.getElementsByTagName(CODIGO_XML_CODIGO_INTERNO_FORNECEDOR).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CODIGO_INTERNO_FORNECEDOR).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getPurchaseOrder().getPurchaseOrderItem()
						.setDescription(eElement.getElementsByTagName(CODIGO_XML_DESCRICAO_ITEM).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_DESCRICAO_ITEM).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getPurchaseOrder().getPurchaseOrderItem()
						.setPurchaseOrderItemNCM(eElement.getElementsByTagName(CODIGO_XML_NCM_ITEM).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_NCM_ITEM).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getPurchaseOrder().getPurchaseOrderItem()
						.setPurchaseOrderItemQuantity(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_ITEM).item(0) != null
								? new BigDecimal(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_ITEM).item(0).getTextContent())
								: new BigDecimal(0));
				asnItem.getPurchaseOrder()
						.setERPCode(eElement.getElementsByTagName(CODIGO_XML_CODIGO_ERP).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CODIGO_ERP).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.setQuantity(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_VOLUME).item(0) != null
						? Integer.parseInt(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_VOLUME).item(0).getTextContent())
						: 0);
				asnItem.getShipToItem()
						.setName(eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getShipToItem()
						.setFiscalIdentifier(eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getShipToItem().getAddress()
						.setStreetAddress((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0).getTextContent()
								: StringUtils.EMPTY) + StringUtils.SPACE
								+ (eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0) != null
										? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0).getTextContent()
										: StringUtils.EMPTY));
				asnItem.getShipToItem().getAddress()
						.setComplementNumber((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0).getTextContent()
								: StringUtils.EMPTY) + StringUtils.SPACE +
								 (eElement.getElementsByTagName(CODIGO_XML_ENDERECO_BAIRRO).item(0) != null
										? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_BAIRRO).item(0).getTextContent()
										: StringUtils.EMPTY));
				asnItem.getShipToItem().getAddress()
						.setPostalCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getShipToItem().getAddress()
						.setCityName(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getShipToItem().getAddress()
						.setPhoneNumber(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_TELEFONE).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_TELEFONE).item(0).getTextContent()
								: StringUtils.EMPTY);
				asnItem.getShipToItem().getAddress()
						.setCityCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost
						.setInvoiceValueAmount(new BigDecimal(eElement.getElementsByTagName(CODIGO_XML_VALOR_NOTA_FISCAL).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_VALOR_NOTA_FISCAL).item(0).getTextContent()
								: StringUtils.EMPTY));
				advancedShipmentNotificationPost.setIssuingDate(eElement.getElementsByTagName(CODIGO_XML_DATA_EMISSAO).item(0) != null
						? DataUtil.getIssuingDateFormat() : StringUtils.EMPTY);
				advancedShipmentNotificationPost.setNfeNumber(eElement.getElementsByTagName(CODIGO_XML_CHAVE_ACESSO_NOTA_FISCAL_ELETRONICA).item(0) != null
						? eElement.getElementsByTagName(CODIGO_XML_CHAVE_ACESSO_NOTA_FISCAL_ELETRONICA).item(0).getTextContent()
						: StringUtils.EMPTY);
				
				advancedShipmentNotificationPost.getReclaimOrigin()
						.setName(eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getReclaimOrigin()
						.setFiscalIdentifier(eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getReclaimOrigin().getAddress()
						.setStreetAddress((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0).getTextContent()
								: StringUtils.EMPTY) + StringUtils.SPACE
								+ (eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0) != null
										? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0).getTextContent()
										: StringUtils.EMPTY));
				advancedShipmentNotificationPost.getReclaimOrigin().getAddress()
						.setComplementNumber((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0).getTextContent()
								: StringUtils.EMPTY));
				advancedShipmentNotificationPost.getReclaimOrigin().getAddress()
						.setPostalCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getReclaimOrigin().getAddress()
						.setCityName(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getReclaimOrigin().getAddress()
						.setCityCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0) != null
								? RECLAIM_ORIGIN_CITY_CODE_PREFIX + eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getShipTo()
						.setName(eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_RAZAO_SOCIAL).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getShipTo()
						.setFiscalIdentifier(eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getShipTo()
						.setCountryCode(eElement.getElementsByTagName(CODIGO_XML_CODIGO_ISO_PAIS).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CODIGO_ISO_PAIS).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setStreetAddress((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_LOGRADOURO).item(0).getTextContent()
								: StringUtils.EMPTY) + StringUtils.SPACE
								+ (eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0) != null
										? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_NUMERO).item(0).getTextContent()
										: StringUtils.EMPTY));
				;
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setComplementNumber((eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_COMPLEMENTO).item(0).getTextContent()
								: StringUtils.EMPTY) + StringUtils.SPACE
								+ (eElement.getElementsByTagName(CODIGO_XML_ENDERECO_BAIRRO).item(0) != null
										? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_BAIRRO).item(0).getTextContent()
										: StringUtils.EMPTY));
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setPostalCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CEP).item(0).getTextContent()
								: StringUtils.EMPTY);
				;
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setCityName(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				;
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setCityCode(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_CODIGO_MUNICIPIO).item(0).getTextContent()
								: StringUtils.EMPTY);
				;
				advancedShipmentNotificationPost.getShipTo().getAddress()
						.setPhoneNumber(eElement.getElementsByTagName(CODIGO_XML_ENDERECO_TELEFONE).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_ENDERECO_TELEFONE).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost
						.setSupplierTaxNumber(eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0) != null
								? eElement.getElementsByTagName(CODIGO_XML_CNPJ).item(0).getTextContent()
								: StringUtils.EMPTY);
				advancedShipmentNotificationPost.setTotalEstimatedWeight(eElement.getElementsByTagName(CODIGO_XML_PESO_BRUTO_TOTAL).item(0) != null
								? new BigDecimal(eElement.getElementsByTagName(CODIGO_XML_PESO_BRUTO_TOTAL).item(0).getTextContent())
								: new BigDecimal(0));
				advancedShipmentNotificationPost
						.setVolumeTotalQuantity(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_VOLUME).item(0) != null
								? Integer.parseInt(eElement.getElementsByTagName(CODIGO_XML_QUANTIDADE_VOLUME).item(0).getTextContent())
								: 0);
			}
		}
		
		advancedShipmentNotificationPost.getASNItems().add(asnItem);
		mapeamento.setAdvancedShipmentNotificationPost(advancedShipmentNotificationPost);

		log.info("Gerado o Advanced Shipment Notification Post: " + advancedShipmentNotificationPost.toString());

		return mapeamento;
	}

	private File createFileDirectory(String directory) {

		File fileDirectory = new File(directory);

		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			log.debug("Diretório criado: {}", directory);
		}

		log.info("Definido diretório: {}", directory);
		return fileDirectory;
	}

	private void deleteFileDirectory(File fileDirectory) {
		fileDirectory.delete();
		log.info("Deletado diretório: {}", fileDirectory.getAbsoluteFile());
	}

	private void deleteFile(String folder, String file) {
		(new File(folder + file)).delete();
		log.info("Deletado o arquivo: {}", file);
	}

	private void baixarZip(Gerado gerado) throws IOException {

		URL url = new URL(gerado.getPath());
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();

		log.info("Conectando a url: {}", gerado.getPath());

		FileOutputStream out = new FileOutputStream(ZIP_DESTINATION_FOLDER + gerado.getFileName());
		byte[] b = new byte[2048];
		int count;

		while ((count = in.read(b)) >= 0) {
			out.write(b, 0, count);
		}

		out.flush();
		out.close();
		in.close();

	}

	private void extrairZip(Gerado gerado) throws IOException {

		FileInputStream fis;

		byte[] buffer = new byte[1024];

		fis = new FileInputStream(ZIP_DESTINATION_FOLDER + gerado.getFileName());
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze = zis.getNextEntry();

		while (ze != null) {
			String fileName = ze.getName();
			File newFile = new File(XML_DESTINATION_FOLDER + fileName);
			log.info("Extraindo o XML no caminho: " + newFile.getAbsolutePath());

			new File(newFile.getParent()).mkdirs();
			FileOutputStream fos = new FileOutputStream(newFile);

			int len;

			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}

			fos.close();

			zis.closeEntry();
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
		fis.close();

	}

}
