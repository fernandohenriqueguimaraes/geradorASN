package br.com.geradorASN.entity.xml;

public class Reference {
	Transforms TransformsObject;
	DigestMethod DigestMethodObject;
	private String DigestValue;
	private String _URI;

	public Transforms getTransforms() {
		return TransformsObject;
	}

	public DigestMethod getDigestMethod() {
		return DigestMethodObject;
	}

	public String getDigestValue() {
		return DigestValue;
	}

	public String get_URI() {
		return _URI;
	}

	public void setTransforms(Transforms TransformsObject) {
		this.TransformsObject = TransformsObject;
	}

	public void setDigestMethod(DigestMethod DigestMethodObject) {
		this.DigestMethodObject = DigestMethodObject;
	}

	public void setDigestValue(String DigestValue) {
		this.DigestValue = DigestValue;
	}

	public void set_URI(String _URI) {
		this._URI = _URI;
	}
}
