package br.com.geradorASN.entity.rest.v4.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Register {

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("taxNumber")
	private String taxNumber;

	@JsonProperty("sefazInscription")
	private String sefazInscription;

	public String getCompanyName() {
		return companyName;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public String getSefazInscription() {
		return sefazInscription;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public void setSefazInscription(String sefazInscription) {
		this.sefazInscription = sefazInscription;
	}

	@Override
	public String toString() {
		return "Register [companyName=" + companyName + ", taxNumber=" + taxNumber + ", sefazInscription="
				+ sefazInscription + "]";
	}

}
