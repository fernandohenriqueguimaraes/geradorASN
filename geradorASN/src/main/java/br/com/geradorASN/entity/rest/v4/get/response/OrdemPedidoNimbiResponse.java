package br.com.geradorASN.entity.rest.v4.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdemPedidoNimbiResponse {
	
	@JsonProperty("TotalPurchase")
	private long totalPurchase;

	@JsonProperty("PurchaseOrderGroupGetAPI")
	private PurchaseOrderGroupGetAPI purchaseOrderGroupGetAPI;

	public long getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(long totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public PurchaseOrderGroupGetAPI getPurchaseOrderGroupGetAPI() {
		return purchaseOrderGroupGetAPI;
	}

	public void setPurchaseOrderGroupGetAPI(PurchaseOrderGroupGetAPI purchaseOrderGroupGetAPI) {
		this.purchaseOrderGroupGetAPI = purchaseOrderGroupGetAPI;
	}

	@Override
	public String toString() {
		return "OrdemPedidoNimbiResponse [totalPurchase=" + totalPurchase + ", purchaseOrderGroupGetAPI="
				+ purchaseOrderGroupGetAPI + "]";
	}

}
