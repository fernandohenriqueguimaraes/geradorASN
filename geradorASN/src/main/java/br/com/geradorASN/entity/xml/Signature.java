package br.com.geradorASN.entity.xml;

public class Signature {

	SignedInfo SignedInfoObject;
	private String SignatureValue;
	KeyInfo KeyInfoObject;
	private String _xmlns;

	public SignedInfo getSignedInfo() {
		return SignedInfoObject;
	}

	public String getSignatureValue() {
		return SignatureValue;
	}

	public KeyInfo getKeyInfo() {
		return KeyInfoObject;
	}

	public String get_xmlns() {
		return _xmlns;
	}

	public void setSignedInfo(SignedInfo SignedInfoObject) {
		this.SignedInfoObject = SignedInfoObject;
	}

	public void setSignatureValue(String SignatureValue) {
		this.SignatureValue = SignatureValue;
	}

	public void setKeyInfo(KeyInfo KeyInfoObject) {
		this.KeyInfoObject = KeyInfoObject;
	}

	public void set_xmlns(String _xmlns) {
		this._xmlns = _xmlns;
	}

}
