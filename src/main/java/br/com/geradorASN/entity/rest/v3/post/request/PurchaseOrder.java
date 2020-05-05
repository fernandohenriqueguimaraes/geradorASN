package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class PurchaseOrder {

	private String PurchaseOrderNumber;
	private PurchaseOrderItemString purchaseOrderItem;
	private String ERPCode;

	public PurchaseOrder() {
		setPurchaseOrderItem(new PurchaseOrderItemString());
		setPurchaseOrderNumber(StringUtils.EMPTY);
		setERPCode(StringUtils.EMPTY);
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public PurchaseOrderItemString getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(PurchaseOrderItemString purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}

	public String getERPCode() {
		return ERPCode;
	}

	public void setERPCode(String eRPCode) {
		ERPCode = eRPCode;
	}
	

	@Override
	public String toString() {
		return "PurchaseOrder [PurchaseOrderNumber=" + PurchaseOrderNumber + ", purchaseOrderItem=" + purchaseOrderItem
				 + ", ERPCode=" + ERPCode + "]";
	}

}
