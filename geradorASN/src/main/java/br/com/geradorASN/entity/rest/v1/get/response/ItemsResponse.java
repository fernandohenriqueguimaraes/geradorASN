package br.com.geradorASN.entity.rest.v1.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsResponse {

	@JsonProperty("OCNumber")
	private String ocNumber;

	@JsonProperty("OCLineNumber")
	private String ocLineNumber;

	@JsonProperty("ItemDescription")
	private String itemDescription;

	public String getOcNumber() {
		return ocNumber;
	}

	public void setOcNumber(String ocNumber) {
		this.ocNumber = ocNumber;
	}

	public String getOcLineNumber() {
		return ocLineNumber;
	}

	public void setOcLineNumber(String ocLineNumber) {
		this.ocLineNumber = ocLineNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "ItemsResponse [ocNumber=" + ocNumber + ", ocLineNumber=" + ocLineNumber + ", itemDescription="
				+ itemDescription + "]";
	}

}
