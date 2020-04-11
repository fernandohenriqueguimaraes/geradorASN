package br.com.geradorASN.entity.rest.v1.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyerResponse {

	@JsonProperty("BuyerCNPJ")
	private String buyerCNPJ;

	@JsonProperty("BuyerName")
	private String buyerName;

	public String getBuyerCNPJ() {
		return buyerCNPJ;
	}

	public void setBuyerCNPJ(String buyerCNPJ) {
		this.buyerCNPJ = buyerCNPJ;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Override
	public String toString() {
		return "BuyerResponse [buyerCNPJ=" + buyerCNPJ + ", buyerName=" + buyerName + "]";
	}

}
