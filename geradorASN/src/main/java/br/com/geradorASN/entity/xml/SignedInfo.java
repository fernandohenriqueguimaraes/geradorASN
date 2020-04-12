package br.com.geradorASN.entity.xml;

public class SignedInfo {

	CanonicalizationMethod CanonicalizationMethodObject;
	SignatureMethod SignatureMethodObject;
	Reference ReferenceObject;

	public CanonicalizationMethod getCanonicalizationMethod() {
		return CanonicalizationMethodObject;
	}

	public SignatureMethod getSignatureMethod() {
		return SignatureMethodObject;
	}

	public Reference getReference() {
		return ReferenceObject;
	}

	public void setCanonicalizationMethod(CanonicalizationMethod CanonicalizationMethodObject) {
		this.CanonicalizationMethodObject = CanonicalizationMethodObject;
	}

	public void setSignatureMethod(SignatureMethod SignatureMethodObject) {
		this.SignatureMethodObject = SignatureMethodObject;
	}

	public void setReference(Reference ReferenceObject) {
		this.ReferenceObject = ReferenceObject;
	}
}
