package br.com.geradorASN.entity.rest.v1.post.request;

import org.apache.commons.lang3.StringUtils;

public class PurchaseOrder {

	private Integer PurchaseOrderNumber;
	private PurchaseOrderItem purchaseOrderItem;
	private String purchaseOrderDate;
	private String ERPCode;

	public PurchaseOrder() {
		setPurchaseOrderItem(new PurchaseOrderItem());
		setPurchaseOrderNumber(0);
		setERPCode(StringUtils.EMPTY);
	}

	public Integer getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public PurchaseOrderItem getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}

	public String getERPCode() {
		return ERPCode;
	}

	public void setERPCode(String eRPCode) {
		ERPCode = eRPCode;
	}
	
	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [PurchaseOrderNumber=" + PurchaseOrderNumber + ", purchaseOrderItem=" + purchaseOrderItem
				+ ", purchaseOrderDate=" + purchaseOrderDate + ", ERPCode=" + ERPCode + "]";
	}

}
