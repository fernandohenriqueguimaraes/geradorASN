package br.com.geradorASN.entity.rest.v1.post.request;

import java.math.BigDecimal;

public class ASNItem {

	private PurchaseOrder purchaseOrder;
	private BigDecimal Quantity;
	private UnitOfMeasurement unitOfMeasurement;
	private Integer PackageType;
	private ShipToItem shipToItem;

	public ASNItem() {
		setPurchaseOrder(new PurchaseOrder());
		setUnitOfMeasurement(new UnitOfMeasurement());
		setShipToItem(new ShipToItem());
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public BigDecimal getQuantity() {
		return Quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		Quantity = quantity;
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Integer getPackageType() {
		return PackageType;
	}

	public void setPackageType(Integer packageType) {
		PackageType = packageType;
	}

	public ShipToItem getShipToItem() {
		return shipToItem;
	}

	public void setShipToItem(ShipToItem shipToItem) {
		this.shipToItem = shipToItem;
	}

	@Override
	public String toString() {
		return "ASNItem [purchaseOrder=" + purchaseOrder + ", Quantity=" + Quantity + ", unitOfMeasurement="
				+ unitOfMeasurement + ", PackageType=" + PackageType + ", shipToItem=" + shipToItem + "]";
	}

}
