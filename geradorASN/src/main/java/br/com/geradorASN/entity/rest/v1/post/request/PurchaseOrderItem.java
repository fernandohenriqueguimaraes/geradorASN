package br.com.geradorASN.entity.rest.v1.post.request;

import java.math.BigDecimal;

public class PurchaseOrderItem {

	private Integer PurchaseOrderItemNumber;
	private String Description;
	private String SupplierItemNumber;
	private String PurchaseOrderItemNCM;
	private BigDecimal PurchaseOrderItemQuantity;

	public PurchaseOrderItem() {
	}

	public Integer getPurchaseOrderItemNumber() {
		return PurchaseOrderItemNumber;
	}

	public void setPurchaseOrderItemNumber(Integer purchaseOrderItemNumber) {
		PurchaseOrderItemNumber = purchaseOrderItemNumber;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSupplierItemNumber() {
		return SupplierItemNumber;
	}

	public void setSupplierItemNumber(String supplierItemNumber) {
		SupplierItemNumber = supplierItemNumber;
	}

	public String getPurchaseOrderItemNCM() {
		return PurchaseOrderItemNCM;
	}

	public void setPurchaseOrderItemNCM(String purchaseOrderItemNCM) {
		PurchaseOrderItemNCM = purchaseOrderItemNCM;
	}

	public BigDecimal getPurchaseOrderItemQuantity() {
		return PurchaseOrderItemQuantity;
	}

	public void setPurchaseOrderItemQuantity(BigDecimal purchaseOrderItemQuantity) {
		PurchaseOrderItemQuantity = purchaseOrderItemQuantity;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItem [PurchaseOrderItemNumber=" + PurchaseOrderItemNumber + ", Description=" + Description
				+ ", SupplierItemNumber=" + SupplierItemNumber + ", PurchaseOrderItemNCM=" + PurchaseOrderItemNCM
				+ ", PurchaseOrderItemQuantity=" + PurchaseOrderItemQuantity + "]";
	}

}
