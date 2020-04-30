package br.com.geradorASN.entity.rest.v1.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupplierResponse {

	@JsonProperty("SupplierCNPJ")
	private String supplierCNPJ;

	@JsonProperty("SupplierName")
	private String supplierName;

	public String getSupplierCNPJ() {
		return supplierCNPJ;
	}

	public void setSupplierCNPJ(String supplierCNPJ) {
		this.supplierCNPJ = supplierCNPJ;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "SupplierResponse [supplierCNPJ=" + supplierCNPJ + ", supplierName=" + supplierName + "]";
	}

}
