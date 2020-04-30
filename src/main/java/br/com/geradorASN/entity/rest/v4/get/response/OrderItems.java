package br.com.geradorASN.entity.rest.v4.get.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItems {

	@JsonProperty("Id")
	private Integer Id;

	@JsonProperty("Code")
	private String Code;

	@JsonProperty("ShortDescription")
	private String ShortDescription;

	@JsonProperty("DeliveryAddressExternalId")
	private String DeliveryAddressExternalId;

	@JsonProperty("DeliveryAddressDescription")
	private String DeliveryAddressDescription;

	@JsonProperty("PaymentAddressExternalId")
	private String PaymentAddressExternalId;

	@JsonProperty("PaymentAddressDescription")
	private String PaymentAddressDescription;

	@JsonProperty("Quantity")
	private BigDecimal Quantity;

	@JsonProperty("UnitPrice")
	private BigDecimal UnitPrice;

	@JsonProperty("TotalPrice")
	private BigDecimal TotalPrice;

	@JsonProperty("DeliveryDeadline")
	private BigDecimal DeliveryDeadline;

	@JsonProperty("PaymentTypeCode")
	private String PaymentTypeCode;

	@JsonProperty("PaymentTypeDescription")
	private String PaymentTypeDescription;

	@JsonProperty("UnitOfMeasureCode")
	private String UnitOfMeasureCode;

	@JsonProperty("UnitOfMeasureDescription")
	private String UnitOfMeasureDescription;

	@JsonProperty("LineERP")
	private Integer LineERP;

	@JsonProperty("NatureOfOperationCode")
	private String NatureOfOperationCode;

	@JsonProperty("NatureOfOperationDescription")
	private String NatureOfOperationDescription;

	@JsonProperty("CategoryId")
	private String CategoryId;

	@JsonProperty("CategoryDescription")
	private String CategoryDescription;

	@JsonProperty("SourceMaterialCode")
	private String SourceMaterialCode;

	@JsonProperty("SourceMaterialDescription")
	private String SourceMaterialDescription;

	@JsonProperty("ItemClassificationId")
	private BigDecimal ItemClassificationId;

	@JsonProperty("CompanyCurrencyId")
	private BigDecimal CompanyCurrencyId;

	@JsonProperty("DeliveryDate")
	private String DeliveryDate;

	@JsonProperty("ItemStatus")
	private String ItemStatus;

	@JsonProperty("PER")
	private String PER;

	@JsonProperty("VendorPartnumber")
	private String VendorPartnumber;

	@JsonProperty("EvaluatedReceiptSettlement")
	private Boolean EvaluatedReceiptSettlement;

	@JsonProperty("RequisitionNumber")
	private String RequisitionNumber;

	@JsonProperty("RequesterName")
	private String RequesterName;

	@JsonProperty("RequesterContact")
	private String RequesterContact;

	@JsonProperty("UnloadingPoint")
	private String UnloadingPoint;

	@JsonProperty("ListComment")
	private List<Comment> ListComment = new ArrayList<Comment>(); 

	@JsonProperty("TaxesOrdemItemObject")
	private TaxesOrdemItem TaxesOrdemItemObject;

	@JsonProperty("deposit")
	private String deposit;

	@JsonProperty("depositNumber")
	private String depositNumber;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getShortDescription() {
		return ShortDescription;
	}

	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}

	public String getDeliveryAddressExternalId() {
		return DeliveryAddressExternalId;
	}

	public void setDeliveryAddressExternalId(String deliveryAddressExternalId) {
		DeliveryAddressExternalId = deliveryAddressExternalId;
	}

	public String getDeliveryAddressDescription() {
		return DeliveryAddressDescription;
	}

	public void setDeliveryAddressDescription(String deliveryAddressDescription) {
		DeliveryAddressDescription = deliveryAddressDescription;
	}

	public String getPaymentAddressExternalId() {
		return PaymentAddressExternalId;
	}

	public void setPaymentAddressExternalId(String paymentAddressExternalId) {
		PaymentAddressExternalId = paymentAddressExternalId;
	}

	public String getPaymentAddressDescription() {
		return PaymentAddressDescription;
	}

	public void setPaymentAddressDescription(String paymentAddressDescription) {
		PaymentAddressDescription = paymentAddressDescription;
	}

	public BigDecimal getQuantity() {
		return Quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		Quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		UnitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		TotalPrice = totalPrice;
	}

	public BigDecimal getDeliveryDeadline() {
		return DeliveryDeadline;
	}

	public void setDeliveryDeadline(BigDecimal deliveryDeadline) {
		DeliveryDeadline = deliveryDeadline;
	}

	public String getPaymentTypeCode() {
		return PaymentTypeCode;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		PaymentTypeCode = paymentTypeCode;
	}

	public String getPaymentTypeDescription() {
		return PaymentTypeDescription;
	}

	public void setPaymentTypeDescription(String paymentTypeDescription) {
		PaymentTypeDescription = paymentTypeDescription;
	}

	public String getUnitOfMeasureCode() {
		return UnitOfMeasureCode;
	}

	public void setUnitOfMeasureCode(String unitOfMeasureCode) {
		UnitOfMeasureCode = unitOfMeasureCode;
	}

	public String getUnitOfMeasureDescription() {
		return UnitOfMeasureDescription;
	}

	public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
		UnitOfMeasureDescription = unitOfMeasureDescription;
	}

	public Integer getLineERP() {
		return LineERP;
	}

	public void setLineERP(Integer lineERP) {
		LineERP = lineERP;
	}

	public String getNatureOfOperationCode() {
		return NatureOfOperationCode;
	}

	public void setNatureOfOperationCode(String natureOfOperationCode) {
		NatureOfOperationCode = natureOfOperationCode;
	}

	public String getNatureOfOperationDescription() {
		return NatureOfOperationDescription;
	}

	public void setNatureOfOperationDescription(String natureOfOperationDescription) {
		NatureOfOperationDescription = natureOfOperationDescription;
	}

	public String getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public String getSourceMaterialCode() {
		return SourceMaterialCode;
	}

	public void setSourceMaterialCode(String sourceMaterialCode) {
		SourceMaterialCode = sourceMaterialCode;
	}

	public String getSourceMaterialDescription() {
		return SourceMaterialDescription;
	}

	public void setSourceMaterialDescription(String sourceMaterialDescription) {
		SourceMaterialDescription = sourceMaterialDescription;
	}

	public BigDecimal getItemClassificationId() {
		return ItemClassificationId;
	}

	public void setItemClassificationId(BigDecimal itemClassificationId) {
		ItemClassificationId = itemClassificationId;
	}

	public BigDecimal getCompanyCurrencyId() {
		return CompanyCurrencyId;
	}

	public void setCompanyCurrencyId(BigDecimal companyCurrencyId) {
		CompanyCurrencyId = companyCurrencyId;
	}

	public String getDeliveryDate() {
		return DeliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}

	public String getItemStatus() {
		return ItemStatus;
	}

	public void setItemStatus(String itemStatus) {
		ItemStatus = itemStatus;
	}

	public String getPER() {
		return PER;
	}

	public void setPER(String pER) {
		PER = pER;
	}

	public String getVendorPartnumber() {
		return VendorPartnumber;
	}

	public void setVendorPartnumber(String vendorPartnumber) {
		VendorPartnumber = vendorPartnumber;
	}

	public Boolean getEvaluatedReceiptSettlement() {
		return EvaluatedReceiptSettlement;
	}

	public void setEvaluatedReceiptSettlement(Boolean evaluatedReceiptSettlement) {
		EvaluatedReceiptSettlement = evaluatedReceiptSettlement;
	}

	public String getRequisitionNumber() {
		return RequisitionNumber;
	}

	public void setRequisitionNumber(String requisitionNumber) {
		RequisitionNumber = requisitionNumber;
	}

	public String getRequesterName() {
		return RequesterName;
	}

	public void setRequesterName(String requesterName) {
		RequesterName = requesterName;
	}

	public String getRequesterContact() {
		return RequesterContact;
	}

	public void setRequesterContact(String requesterContact) {
		RequesterContact = requesterContact;
	}

	public String getUnloadingPoint() {
		return UnloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		UnloadingPoint = unloadingPoint;
	}

	public List<Comment> getListComment() {
		return ListComment;
	}

	public void setListComment(List<Comment> listComment) {
		ListComment = listComment;
	}

	public TaxesOrdemItem getTaxesOrdemItemObject() {
		return TaxesOrdemItemObject;
	}

	public void setTaxesOrdemItemObject(TaxesOrdemItem taxesOrdemItemObject) {
		TaxesOrdemItemObject = taxesOrdemItemObject;
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

	@Override
	public String toString() {
		return "OrderItems [Id=" + Id + ", Code=" + Code + ", ShortDescription=" + ShortDescription
				+ ", DeliveryAddressExternalId=" + DeliveryAddressExternalId + ", DeliveryAddressDescription="
				+ DeliveryAddressDescription + ", PaymentAddressExternalId=" + PaymentAddressExternalId
				+ ", PaymentAddressDescription=" + PaymentAddressDescription + ", Quantity=" + Quantity + ", UnitPrice="
				+ UnitPrice + ", TotalPrice=" + TotalPrice + ", DeliveryDeadline=" + DeliveryDeadline
				+ ", PaymentTypeCode=" + PaymentTypeCode + ", PaymentTypeDescription=" + PaymentTypeDescription
				+ ", UnitOfMeasureCode=" + UnitOfMeasureCode + ", UnitOfMeasureDescription=" + UnitOfMeasureDescription
				+ ", LineERP=" + LineERP + ", NatureOfOperationCode=" + NatureOfOperationCode
				+ ", NatureOfOperationDescription=" + NatureOfOperationDescription + ", CategoryId=" + CategoryId
				+ ", CategoryDescription=" + CategoryDescription + ", SourceMaterialCode=" + SourceMaterialCode
				+ ", SourceMaterialDescription=" + SourceMaterialDescription + ", ItemClassificationId="
				+ ItemClassificationId + ", CompanyCurrencyId=" + CompanyCurrencyId + ", DeliveryDate=" + DeliveryDate
				+ ", ItemStatus=" + ItemStatus + ", PER=" + PER + ", VendorPartnumber=" + VendorPartnumber
				+ ", EvaluatedReceiptSettlement=" + EvaluatedReceiptSettlement + ", RequisitionNumber="
				+ RequisitionNumber + ", RequesterName=" + RequesterName + ", RequesterContact=" + RequesterContact
				+ ", UnloadingPoint=" + UnloadingPoint + ", ListComment=" + ListComment + ", TaxesOrdemItemObject="
				+ TaxesOrdemItemObject + ", deposit=" + deposit + ", depositNumber=" + depositNumber + "]";
	}
	
}
