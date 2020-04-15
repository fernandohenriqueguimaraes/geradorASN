package br.com.geradorASN.entity.rest.v4.get.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseOrderGroupGetAPI {
	
	@JsonProperty("PurchaseOrder")
	private PurchaseOrder purchaseOrder;
	
	@JsonProperty("ListOrderItems")
	private List<OrderItems> orderItems = new ArrayList<OrderItems>();

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "PurchaseOrderGroupGetAPI [purchaseOrder=" + purchaseOrder + ", orderItems=" + orderItems + "]";
	}

}
