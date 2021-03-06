package br.com.geradorASN.entity.rest.v3.post.request;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class PurchaseOrderItemString {

	private String PurchaseOrderItemNumber;
	private String Description;
	private String SupplierItemNumber;
	private String PurchaseOrderItemNCM;
	private BigDecimal PurchaseOrderItemQuantity;

	public PurchaseOrderItemString() {
	    setPurchaseOrderItemNumber(StringUtils.EMPTY);
	    setDescription(StringUtils.EMPTY);
	    setSupplierItemNumber(StringUtils.EMPTY);
	    setPurchaseOrderItemNCM(StringUtils.EMPTY);
	    setPurchaseOrderItemQuantity(new BigDecimal(0));
	}

	public String getPurchaseOrderItemNumber() {
		return PurchaseOrderItemNumber;
	}

	public void setPurchaseOrderItemNumber(String purchaseOrderItemNumber) {
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
        return "PurchaseOrderItemString [PurchaseOrderItemNumber=" + PurchaseOrderItemNumber + ", Description=" + Description
                + ", SupplierItemNumber=" + SupplierItemNumber + ", PurchaseOrderItemNCM=" + PurchaseOrderItemNCM
                + ", PurchaseOrderItemQuantity=" + PurchaseOrderItemQuantity + "]";
    }

}
