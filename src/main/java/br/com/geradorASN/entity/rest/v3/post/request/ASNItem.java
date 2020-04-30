package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class ASNItem {

	private PurchaseOrder purchaseOrder;
	private PurchaseOrderNumber purchaseOrderNumber;
	private Integer Quantity;
	private UnitOfMeasurement unitOfMeasurement;
	private String PackageType;
	private ShipToItem shipToItem;

	public ASNItem() {
		setPurchaseOrder(new PurchaseOrder());
		setPurchaseOrderNumber(new PurchaseOrderNumber());
		setUnitOfMeasurement(new UnitOfMeasurement());
		setShipToItem(new ShipToItem());
		setQuantity(0);
		setPackageType(StringUtils.EMPTY);
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getPackageType() {
		return PackageType;
	}

	public void setPackageType(String empty) {
		PackageType = empty;
	}

	public ShipToItem getShipToItem() {
		return shipToItem;
	}

	public void setShipToItem(ShipToItem shipToItem) {
		this.shipToItem = shipToItem;
	}
	
    public PurchaseOrderNumber getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(PurchaseOrderNumber purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    @Override
    public String toString() {
        return "ASNItem [purchaseOrder=" + purchaseOrder + ", purchaseOrderNumber=" + purchaseOrderNumber + ", Quantity=" + Quantity
                + ", unitOfMeasurement=" + unitOfMeasurement + ", PackageType=" + PackageType + ", shipToItem=" + shipToItem + "]";
    }

}
