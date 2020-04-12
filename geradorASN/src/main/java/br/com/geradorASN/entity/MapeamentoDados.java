package br.com.geradorASN.entity;

import org.w3c.dom.Document;

import br.com.geradorASN.entity.rest.v1.get.response.NFeResponse;
import br.com.geradorASN.entity.xml.Gerado;
import br.com.geradorASN.entity.xml.PedGeraArquivo;

public class MapeamentoDados {

	private NFeResponse nfeNimbi;
	private PedGeraArquivo pedGeraArquivo;
	private Gerado gerado;
	private Document nfeTriangulusDocument;

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

	public Document getNfeTriangulusDocument() {
		return nfeTriangulusDocument;
	}

	public void setNfeTriangulusDocument(Document nfeTriangulusDocument) {
		this.nfeTriangulusDocument = nfeTriangulusDocument;
	}
}
