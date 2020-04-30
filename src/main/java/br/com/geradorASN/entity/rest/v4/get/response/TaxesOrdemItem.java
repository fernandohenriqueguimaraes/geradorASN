package br.com.geradorASN.entity.rest.v4.get.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxesOrdemItem {

	@JsonProperty("ICMS")
	private BigDecimal ICMS;

	@JsonProperty("BaseICMS")
	private BigDecimal BaseICMS;

	@JsonProperty("IPI")
	private BigDecimal IPI;

	@JsonProperty("BaseIPI")
	private BigDecimal BaseIPI;

	@JsonProperty("NCM")
	private String NCM;

	@JsonProperty("TaxReplacementCode")
	private String TaxReplacementCode;

	@JsonProperty("SpecialTaxRegime")
	private String SpecialTaxRegime;

	public BigDecimal getICMS() {
		return ICMS;
	}

	public void setICMS(BigDecimal iCMS) {
		ICMS = iCMS;
	}

	public BigDecimal getBaseICMS() {
		return BaseICMS;
	}

	public void setBaseICMS(BigDecimal baseICMS) {
		BaseICMS = baseICMS;
	}

	public BigDecimal getIPI() {
		return IPI;
	}

	public void setIPI(BigDecimal iPI) {
		IPI = iPI;
	}

	public BigDecimal getBaseIPI() {
		return BaseIPI;
	}

	public void setBaseIPI(BigDecimal baseIPI) {
		BaseIPI = baseIPI;
	}

	public String getNCM() {
		return NCM;
	}

	public void setNCM(String nCM) {
		NCM = nCM;
	}

	public String getTaxReplacementCode() {
		return TaxReplacementCode;
	}

	public void setTaxReplacementCode(String taxReplacementCode) {
		TaxReplacementCode = taxReplacementCode;
	}

	public String getSpecialTaxRegime() {
		return SpecialTaxRegime;
	}

	public void setSpecialTaxRegime(String specialTaxRegime) {
		SpecialTaxRegime = specialTaxRegime;
	}

	@Override
	public String toString() {
		return "TaxesOrdemItem [ICMS=" + ICMS + ", BaseICMS=" + BaseICMS + ", IPI=" + IPI + ", BaseIPI=" + BaseIPI
				+ ", NCM=" + NCM + ", TaxReplacementCode=" + TaxReplacementCode + ", SpecialTaxRegime="
				+ SpecialTaxRegime + "]";
	}

}
