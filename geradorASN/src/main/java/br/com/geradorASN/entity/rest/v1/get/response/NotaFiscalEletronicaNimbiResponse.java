package br.com.geradorASN.entity.rest.v1.get.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotaFiscalEletronicaNimbiResponse {

	@JsonProperty("TotalRecords")
	private long totalRecords;

	@JsonProperty("NFeResponse")
	private List<NFeResponse> nfeResponse = new ArrayList<NFeResponse>();

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<NFeResponse> getNfeResponse() {
		return nfeResponse;
	}

	public void setNfeResponse(List<NFeResponse> nfeResponse) {
		this.nfeResponse = nfeResponse;
	}

	@Override
	public String toString() {
		return "NotaFiscalEletronicaNimbiResponse [totalRecords=" + totalRecords + ", nfeResponse=" + nfeResponse + "]";
	}

}
