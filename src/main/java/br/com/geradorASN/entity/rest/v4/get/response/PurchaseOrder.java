package br.com.geradorASN.entity.rest.v4.get.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseOrder {

	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("PriorityCode")
	private String priorityCode;

	@JsonProperty("IsAddressByOrder")
	private Boolean isAddressByOrder;

	@JsonProperty("OrderStatusCode")
	private String orderStatusCode;

	@JsonProperty("SupplierCompanyTaxNumber")
	private String supplierCompanyTaxNumber;

	@JsonProperty("TotalPrice")
	private BigDecimal totalPrice;

	@JsonProperty("TotalQtdItems")
	private String totalQtdItems;

	@JsonProperty("StringCreatedBy")
	private String createdBy;

	@JsonProperty("CreatedDate")
	private String createdDate;

	@JsonProperty("UpdatedBy")
	private String updatedBy;

	@JsonProperty("UpdatedDate")
	private String updatedDate;

	@JsonProperty("DocumentFormCode")
	private String documentFormCode;

	@JsonProperty("IncotermCode")
	private String incotermCode;

	@JsonProperty("IncotermDescription")
	private String incotermDescription;

	@JsonProperty("IncotermLocation")
	private String incotermLocation;

	@JsonProperty("CodeERP")
	private String codeERP;

	@JsonProperty("CreatedDateERP")
	private String createdDateERP;

	@JsonProperty("ReferenceContract")
	private String referenceContract;

	@JsonProperty("SupplierRefCode")
	private String supplierRefCode;

	@JsonProperty("CompanyCurrencyISO")
	private String companyCurrencyISO;

	@JsonProperty("BuyerCountryCode")
	private String buyerCountryCode;

	@JsonProperty("BuyerTaxNumber")
	private String buyerTaxNumber;

	@JsonProperty("BuyerContact")
	private String buyerContact;

	@JsonProperty("SupplierCompanyName")
	private String supplierCompanyName;

	@JsonProperty("SupplierCompanyCountryCode")
	private String supplierCompanyCountryCode;

	@JsonProperty("PartnerObject")
	private Partner partnerObject;

	@JsonProperty("GoodsSupplierObject")
	private GoodsSupplier goodsSupplierObject;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public Boolean getIsAddressByOrder() {
		return isAddressByOrder;
	}

	public void setIsAddressByOrder(Boolean isAddressByOrder) {
		this.isAddressByOrder = isAddressByOrder;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public String getSupplierCompanyTaxNumber() {
		return supplierCompanyTaxNumber;
	}

	public void setSupplierCompanyTaxNumber(String supplierCompanyTaxNumber) {
		this.supplierCompanyTaxNumber = supplierCompanyTaxNumber;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalQtdItems() {
		return totalQtdItems;
	}

	public void setTotalQtdItems(String totalQtdItems) {
		this.totalQtdItems = totalQtdItems;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDocumentFormCode() {
		return documentFormCode;
	}

	public void setDocumentFormCode(String documentFormCode) {
		this.documentFormCode = documentFormCode;
	}

	public String getIncotermCode() {
		return incotermCode;
	}

	public void setIncotermCode(String incotermCode) {
		this.incotermCode = incotermCode;
	}

	public String getIncotermDescription() {
		return incotermDescription;
	}

	public void setIncotermDescription(String incotermDescription) {
		this.incotermDescription = incotermDescription;
	}

	public String getIncotermLocation() {
		return incotermLocation;
	}

	public void setIncotermLocation(String incotermLocation) {
		this.incotermLocation = incotermLocation;
	}

	public String getCodeERP() {
		return codeERP;
	}

	public void setCodeERP(String codeERP) {
		this.codeERP = codeERP;
	}

	public String getCreatedDateERP() {
		return createdDateERP;
	}

	public void setCreatedDateERP(String createdDateERP) {
		this.createdDateERP = createdDateERP;
	}

	public String getReferenceContract() {
		return referenceContract;
	}

	public void setReferenceContract(String referenceContract) {
		this.referenceContract = referenceContract;
	}

	public String getSupplierRefCode() {
		return supplierRefCode;
	}

	public void setSupplierRefCode(String supplierRefCode) {
		this.supplierRefCode = supplierRefCode;
	}

	public String getCompanyCurrencyISO() {
		return companyCurrencyISO;
	}

	public void setCompanyCurrencyISO(String companyCurrencyISO) {
		this.companyCurrencyISO = companyCurrencyISO;
	}

	public String getBuyerCountryCode() {
		return buyerCountryCode;
	}

	public void setBuyerCountryCode(String buyerCountryCode) {
		this.buyerCountryCode = buyerCountryCode;
	}

	public String getBuyerTaxNumber() {
		return buyerTaxNumber;
	}

	public void setBuyerTaxNumber(String buyerTaxNumber) {
		this.buyerTaxNumber = buyerTaxNumber;
	}

	public String getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(String buyerContact) {
		this.buyerContact = buyerContact;
	}

	public String getSupplierCompanyName() {
		return supplierCompanyName;
	}

	public void setSupplierCompanyName(String supplierCompanyName) {
		this.supplierCompanyName = supplierCompanyName;
	}

	public String getSupplierCompanyCountryCode() {
		return supplierCompanyCountryCode;
	}

	public void setSupplierCompanyCountryCode(String supplierCompanyCountryCode) {
		this.supplierCompanyCountryCode = supplierCompanyCountryCode;
	}

	public Partner getPartnerObject() {
		return partnerObject;
	}

	public void setPartnerObject(Partner partnerObject) {
		this.partnerObject = partnerObject;
	}

	public GoodsSupplier getGoodsSupplierObject() {
		return goodsSupplierObject;
	}

	public void setGoodsSupplierObject(GoodsSupplier goodsSupplierObject) {
		this.goodsSupplierObject = goodsSupplierObject;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", title=" + title + ", priorityCode=" + priorityCode + ", isAddressByOrder="
				+ isAddressByOrder + ", orderStatusCode=" + orderStatusCode + ", supplierCompanyTaxNumber="
				+ supplierCompanyTaxNumber + ", totalPrice=" + totalPrice + ", totalQtdItems=" + totalQtdItems
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", documentFormCode=" + documentFormCode + ", incotermCode="
				+ incotermCode + ", incotermDescription=" + incotermDescription + ", incotermLocation="
				+ incotermLocation + ", codeERP=" + codeERP + ", createdDateERP=" + createdDateERP
				+ ", referenceContract=" + referenceContract + ", supplierRefCode=" + supplierRefCode
				+ ", companyCurrencyISO=" + companyCurrencyISO + ", buyerCountryCode=" + buyerCountryCode
				+ ", buyerTaxNumber=" + buyerTaxNumber + ", buyerContact=" + buyerContact + ", supplierCompanyName="
				+ supplierCompanyName + ", supplierCompanyCountryCode=" + supplierCompanyCountryCode
				+ ", partnerObject=" + partnerObject + ", goodsSupplierObject=" + goodsSupplierObject + "]";
	}

}
