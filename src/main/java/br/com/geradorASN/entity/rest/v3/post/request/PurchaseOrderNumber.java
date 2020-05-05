package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class PurchaseOrderNumber {
    
    private Integer purchaseOrderNumber;
    private PurchaseOrderItemInteger PurchaseOrderItem;
    private String PurchaseOrderDate;
    private String ERPCode;
    
    public PurchaseOrderNumber() {
        setPurchaseOrderItem(new PurchaseOrderItemInteger());
        setPurchaseOrderNumber(0);
        setERPCode(StringUtils.EMPTY);
        setPurchaseOrderDate(StringUtils.EMPTY);
    }

    public Integer getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }
    
    public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }
    
    public PurchaseOrderItemInteger getPurchaseOrderItem() {
        return PurchaseOrderItem;
    }
    
    public void setPurchaseOrderItem(PurchaseOrderItemInteger purchaseOrderItem) {
        PurchaseOrderItem = purchaseOrderItem;
    }
    
    public String getPurchaseOrderDate() {
        return PurchaseOrderDate;
    }
    
    public void setPurchaseOrderDate(String purchaseOrderDate) {
        PurchaseOrderDate = purchaseOrderDate;
    }
    
    public String getERPCode() {
        return ERPCode;
    }
    
    public void setERPCode(String eRPCode) {
        ERPCode = eRPCode;
    }

    @Override
    public String toString() {
        return "PurchaseOrderNumber [purchaseOrderNumber=" + purchaseOrderNumber + ", PurchaseOrderItemString=" + PurchaseOrderItem
                + ", PurchaseOrderDate=" + PurchaseOrderDate + ", ERPCode=" + ERPCode + "]";
    }
    
}
