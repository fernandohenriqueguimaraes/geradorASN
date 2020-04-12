package br.com.geradorASN.entity.xml;

public class NfeProc {
	
	NFe NFeObject;
	ProtNFe ProtNFeObject;
	private String _xmlns;
	private String _versao;

	public NFe getNFe() {
		return NFeObject;
	}

	public ProtNFe getProtNFe() {
		return ProtNFeObject;
	}

	public String get_xmlns() {
		return _xmlns;
	}

	public String get_versao() {
		return _versao;
	}
	
	public void setNFe(NFe NFeObject) {
		this.NFeObject = NFeObject;
	}

	public void setProtNFe(ProtNFe protNFeObject) {
		this.ProtNFeObject = protNFeObject;
	}

	public void set_xmlns(String _xmlns) {
		this._xmlns = _xmlns;
	}

	public void set_versao(String _versao) {
		this._versao = _versao;
	}
}
