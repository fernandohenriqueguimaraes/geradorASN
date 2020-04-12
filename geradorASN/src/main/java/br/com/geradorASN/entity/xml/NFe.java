package br.com.geradorASN.entity.xml;

public class NFe {
	
	InfNFe InfNFeObject;
	Signature SignatureObject;
	private String _xmlns;

	public InfNFe getInfNFe() {
		return InfNFeObject;
	}

	public Signature getSignature() {
		return SignatureObject;
	}

	public String get_xmlns() {
		return _xmlns;
	}

	public void setInfNFe(InfNFe infNFeObject) {
		this.InfNFeObject = infNFeObject;
	}

	public void setSignature(Signature SignatureObject) {
		this.SignatureObject = SignatureObject;
	}

	public void set_xmlns(String _xmlns) {
		this._xmlns = _xmlns;
	}
}