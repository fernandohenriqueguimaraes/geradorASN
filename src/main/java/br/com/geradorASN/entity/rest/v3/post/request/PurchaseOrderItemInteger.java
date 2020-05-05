package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class PurchaseOrderItemInteger {

    private Integer PurchaseOrderItemNumber;
    private String Description;
    private Integer SupplierItemNumber;
    
    private String center;
    private String deposit;
    private String depositNumber;
    private String equipament;
    private Integer order;
    private String unloadingPoint;
    private String receiver;

    public PurchaseOrderItemInteger() {
        setPurchaseOrderItemNumber(0);
        setDescription(StringUtils.EMPTY);
        setSupplierItemNumber(0);
        setCenter(StringUtils.EMPTY);
        setDeposit(StringUtils.EMPTY);
        setDepositNumber(StringUtils.EMPTY);
        setEquipament(StringUtils.EMPTY);
        setOrder(0);
        setUnloadingPoint(StringUtils.EMPTY);
        setReceiver(StringUtils.EMPTY);
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

    public Integer getSupplierItemNumber() {
        return SupplierItemNumber;
    }

    public void setSupplierItemNumber(Integer supplierItemNumber) {
        SupplierItemNumber = supplierItemNumber;
    }
    
    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }
    
    public String getDeposit() {
        return deposit;
    }
    
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    
    public String getDepositNumber() {
        return depositNumber;
    }
    
    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public String getEquipament() {
        return equipament;
    }

    public void setEquipament(String equipament) {
        this.equipament = equipament;
    }

    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    public String getUnloadingPoint() {
        return unloadingPoint;
    }
    
    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }
    
    public String getReceiver() {
        return receiver;
    }
    
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "PurchaseOrderItemInteger [PurchaseOrderItemNumber=" + PurchaseOrderItemNumber + ", Description=" + Description
                + ", SupplierItemNumber=" + SupplierItemNumber + ", center=" + center + ", deposit=" + deposit + ", depositNumber="
                + depositNumber + ", equipament=" + equipament + ", order=" + order + ", unloadingPoint=" + unloadingPoint + ", receiver="
                + receiver + "]";
    }

}
