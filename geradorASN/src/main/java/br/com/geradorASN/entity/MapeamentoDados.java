package br.com.geradorASN.entity;

import org.w3c.dom.Document;

import br.com.geradorASN.entity.rest.v1.get.response.NFeResponse;
import br.com.geradorASN.entity.rest.v1.post.request.AdvancedShipmentNotificationPost;
import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.entity.xml.PedGeraArquivo;

public class MapeamentoDados {
	
	private String codigoProduto;
	private NFeResponse nfeNimbi;
	private PedGeraArquivo pedGeraArquivo;
	private Gerado gerado;
	private AdvancedShipmentNotificationPost advancedShipmentNotificationPost;

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public NFeResponse getNfeNimbi() {
		return nfeNimbi;
	}

	public MapeamentoDados setNfeNimbi(NFeResponse nfeNimbi) {
		this.nfeNimbi = nfeNimbi;
		return this;
	}

	public Gerado getGerado() {
		return gerado;
	}

	public MapeamentoDados setGerado(Gerado gerado) {
		this.gerado = gerado;
		return this;
	}

	public PedGeraArquivo getPedGeraArquivo() {
		return pedGeraArquivo;
	}

	public MapeamentoDados setPedGeraArquivo(PedGeraArquivo pedGeraArquivo) {
		this.pedGeraArquivo = pedGeraArquivo;
		return this;
	}

	public AdvancedShipmentNotificationPost getAdvancedShipmentNotificationPost() {
		return advancedShipmentNotificationPost;
	}

	public void setAdvancedShipmentNotificationPost(AdvancedShipmentNotificationPost advancedShipmentNotificationPost) {
		this.advancedShipmentNotificationPost = advancedShipmentNotificationPost;
	}
}
