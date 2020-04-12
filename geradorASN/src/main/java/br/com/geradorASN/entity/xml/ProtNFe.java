package br.com.geradorASN.entity.xml;

public class ProtNFe {
	
	InfProt InfProtObject;
	private String _xmlns;
	private String _versao;

	public InfProt getInfProt() {
		return InfProtObject;
	}

	public String get_xmlns() {
		return _xmlns;
	}

	public String get_versao() {
		return _versao;
	}

	public void setInfProt(InfProt infProtObject) {
		this.InfProtObject = infProtObject;
	}

	public void set_xmlns(String _xmlns) {
		this._xmlns = _xmlns;
	}

	public void set_versao(String _versao) {
		this._versao = _versao;
	}
}