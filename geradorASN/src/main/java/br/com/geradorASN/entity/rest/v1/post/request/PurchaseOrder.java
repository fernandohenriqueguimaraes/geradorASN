package br.com.geradorASN.entity.rest.v1.post.request;

public class PurchaseOrder {

	private String PurchaseOrderNumber;
	private PurchaseOrderItem purchaseOrderItem;
	private String ERPCode;

	public PurchaseOrder() {
		setPurchaseOrderItem(new PurchaseOrderItem());
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
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

	@Override
	public String toString() {
		return "PurchaseOrder [PurchaseOrderNumber=" + PurchaseOrderNumber + ", purchaseOrderItem=" + purchaseOrderItem
				+ ", ERPCode=" + ERPCode + "]";
	}

}
