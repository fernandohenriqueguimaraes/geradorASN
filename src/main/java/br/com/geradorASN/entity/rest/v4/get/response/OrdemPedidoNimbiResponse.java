package br.com.geradorASN.entity.rest.v4.get.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdemPedidoNimbiResponse {
	
	@JsonProperty("TotalPurchase")
	private long totalPurchase;

	@JsonProperty("PurchaseOrderGroupGetAPI")
	private List<PurchaseOrderGroupGetAPI> purchaseOrderGroupGetAPI = new ArrayList<PurchaseOrderGroupGetAPI>();

	public long getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(long totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public List<PurchaseOrderGroupGetAPI> getPurchaseOrderGroupGetAPI() {
		return purchaseOrderGroupGetAPI;
	}

	public void setPurchaseOrderGroupGetAPI(List<PurchaseOrderGroupGetAPI> purchaseOrderGroupGetAPI) {
		this.purchaseOrderGroupGetAPI = purchaseOrderGroupGetAPI;
	}

	@Override
	public String toString() {
		return "OrdemPedidoNimbiResponse [totalPurchase=" + totalPurchase + ", purchaseOrderGroupGetAPI="
				+ purchaseOrderGroupGetAPI + "]";
	}

}
