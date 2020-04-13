package br.com.geradorASN.entity.rest.v1.post.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdvancedShipmentNotificationPost {

	private List<ASNItem> ASNItems;

	private String AsnNumber;
	private String AsnStatus;
	private Company company;
	private String BoardingInstructionsText;
	private Carrier carrier;
	private Integer ContainerType;
	private String DangerousFormNumber;
	private String DivisibleLoadStatus;
	private BigDecimal EstimatedCarriageValueAmount;
	private BigDecimal ExtraServiceAmount;
	private BigDecimal FederalPoliceAmount;
	private String FragileLoadStatus;
	private Boolean HasShiptToInItem;
	private String ImportDocument;
	private String ImportDeclarationNumber;
	private Incoterm incoterm;
	private String InvoiceQuantity;
	private BigDecimal InvoiceValueAmount;
	private String InsuranceStatus;
	private String IssuingDate;
	private BigDecimal LicenseAmount;
	private String NfeNumber;
	private String ObservationTEXT;
	private String OnuNumber;
	private String ReclaimEstimatedDate;
	private String ReclaimEstimatedHour;
	private String ReclaimNumber;
	private ReclaimOrigin reclaimOrigin;
	private String RegisterCreationHour;
	private BigDecimal RegisteredFederalPoliceQuantity;
	private String RollingLoadStatus;
	private String SelfSupportingLoadStatus;
	private ShipTo shipTo;
	private String SpecialProcessCode;
	private String SupplierTaxNumber;
	private String SupplierCountryCode;
	private String TireStatus;
	private BigDecimal TotalEstimatedWeight;
	private BigDecimal TotalWidthMeasure;
	private BigDecimal TotalLenghtMeasure;
	private BigDecimal TotalHeightMeasure;
	private Integer TransportationModeCode;
	private String TransportationType;
	private BigDecimal VolumeCapacity;
	private String VehicleType;
	private BigDecimal VolumeTotalQuantity;
	private String Username;
	private String ShipCityTaxCode;

	public AdvancedShipmentNotificationPost() {
		setASNItems(new ArrayList<ASNItem>());
		setCompany(new Company());
		setCarrier(new Carrier());
		setIncoterm(new Incoterm());
		setReclaimOrigin(new ReclaimOrigin());
		setShipTo(new ShipTo());
	}

	public List<ASNItem> getASNItems() {
		return ASNItems;
	}

	public void setASNItems(List<ASNItem> aSNItems) {
		ASNItems = aSNItems;
	}

	public String getAsnNumber() {
		return AsnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		AsnNumber = asnNumber;
	}

	public String getAsnStatus() {
		return AsnStatus;
	}

	public void setAsnStatus(String asnStatus) {
		AsnStatus = asnStatus;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getBoardingInstructionsText() {
		return BoardingInstructionsText;
	}

	public void setBoardingInstructionsText(String boardingInstructionsText) {
		BoardingInstructionsText = boardingInstructionsText;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Integer getContainerType() {
		return ContainerType;
	}

	public void setContainerType(Integer containerType) {
		ContainerType = containerType;
	}

	public String getDangerousFormNumber() {
		return DangerousFormNumber;
	}

	public void setDangerousFormNumber(String dangerousFormNumber) {
		DangerousFormNumber = dangerousFormNumber;
	}

	public String getDivisibleLoadStatus() {
		return DivisibleLoadStatus;
	}

	public void setDivisibleLoadStatus(String divisibleLoadStatus) {
		DivisibleLoadStatus = divisibleLoadStatus;
	}

	public BigDecimal getEstimatedCarriageValueAmount() {
		return EstimatedCarriageValueAmount;
	}

	public void setEstimatedCarriageValueAmount(BigDecimal estimatedCarriageValueAmount) {
		EstimatedCarriageValueAmount = estimatedCarriageValueAmount;
	}

	public BigDecimal getExtraServiceAmount() {
		return ExtraServiceAmount;
	}

	public void setExtraServiceAmount(BigDecimal extraServiceAmount) {
		ExtraServiceAmount = extraServiceAmount;
	}

	public BigDecimal getFederalPoliceAmount() {
		return FederalPoliceAmount;
	}

	public void setFederalPoliceAmount(BigDecimal federalPoliceAmount) {
		FederalPoliceAmount = federalPoliceAmount;
	}

	public String getFragileLoadStatus() {
		return FragileLoadStatus;
	}

	public void setFragileLoadStatus(String fragileLoadStatus) {
		FragileLoadStatus = fragileLoadStatus;
	}

	public Boolean getHasShiptToInItem() {
		return HasShiptToInItem;
	}

	public void setHasShiptToInItem(Boolean hasShiptToInItem) {
		HasShiptToInItem = hasShiptToInItem;
	}

	public String getImportDocument() {
		return ImportDocument;
	}

	public void setImportDocument(String importDocument) {
		ImportDocument = importDocument;
	}

	public String getImportDeclarationNumber() {
		return ImportDeclarationNumber;
	}

	public void setImportDeclarationNumber(String importDeclarationNumber) {
		ImportDeclarationNumber = importDeclarationNumber;
	}

	public Incoterm getIncoterm() {
		return incoterm;
	}

	public void setIncoterm(Incoterm incoterm) {
		this.incoterm = incoterm;
	}

	public String getInvoiceQuantity() {
		return InvoiceQuantity;
	}

	public void setInvoiceQuantity(String invoiceQuantity) {
		InvoiceQuantity = invoiceQuantity;
	}

	public BigDecimal getInvoiceValueAmount() {
		return InvoiceValueAmount;
	}

	public void setInvoiceValueAmount(BigDecimal invoiceValueAmount) {
		InvoiceValueAmount = invoiceValueAmount;
	}

	public String getInsuranceStatus() {
		return InsuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		InsuranceStatus = insuranceStatus;
	}

	public String getIssuingDate() {
		return IssuingDate;
	}

	public void setIssuingDate(String issuingDate) {
		IssuingDate = issuingDate;
	}

	public BigDecimal getLicenseAmount() {
		return LicenseAmount;
	}

	public void setLicenseAmount(BigDecimal licenseAmount) {
		LicenseAmount = licenseAmount;
	}

	public String getNfeNumber() {
		return NfeNumber;
	}

	public void setNfeNumber(String nfeNumber) {
		NfeNumber = nfeNumber;
	}

	public String getObservationTEXT() {
		return ObservationTEXT;
	}

	public void setObservationTEXT(String observationTEXT) {
		ObservationTEXT = observationTEXT;
	}

	public String getOnuNumber() {
		return OnuNumber;
	}

	public void setOnuNumber(String onuNumber) {
		OnuNumber = onuNumber;
	}

	public String getReclaimEstimatedDate() {
		return ReclaimEstimatedDate;
	}

	public void setReclaimEstimatedDate(String reclaimEstimatedDate) {
		ReclaimEstimatedDate = reclaimEstimatedDate;
	}

	public String getReclaimEstimatedHour() {
		return ReclaimEstimatedHour;
	}

	public void setReclaimEstimatedHour(String reclaimEstimatedHour) {
		ReclaimEstimatedHour = reclaimEstimatedHour;
	}

	public String getReclaimNumber() {
		return ReclaimNumber;
	}

	public void setReclaimNumber(String reclaimNumber) {
		ReclaimNumber = reclaimNumber;
	}

	public ReclaimOrigin getReclaimOrigin() {
		return reclaimOrigin;
	}

	public void setReclaimOrigin(ReclaimOrigin reclaimOrigin) {
		this.reclaimOrigin = reclaimOrigin;
	}

	public String getRegisterCreationHour() {
		return RegisterCreationHour;
	}

	public void setRegisterCreationHour(String registerCreationHour) {
		RegisterCreationHour = registerCreationHour;
	}

	public BigDecimal getRegisteredFederalPoliceQuantity() {
		return RegisteredFederalPoliceQuantity;
	}

	public void setRegisteredFederalPoliceQuantity(BigDecimal registeredFederalPoliceQuantity) {
		RegisteredFederalPoliceQuantity = registeredFederalPoliceQuantity;
	}

	public String getRollingLoadStatus() {
		return RollingLoadStatus;
	}

	public void setRollingLoadStatus(String rollingLoadStatus) {
		RollingLoadStatus = rollingLoadStatus;
	}

	public String getSelfSupportingLoadStatus() {
		return SelfSupportingLoadStatus;
	}

	public void setSelfSupportingLoadStatus(String selfSupportingLoadStatus) {
		SelfSupportingLoadStatus = selfSupportingLoadStatus;
	}

	public ShipTo getShipTo() {
		return shipTo;
	}

	public void setShipTo(ShipTo shipTo) {
		this.shipTo = shipTo;
	}

	public String getSpecialProcessCode() {
		return SpecialProcessCode;
	}

	public void setSpecialProcessCode(String specialProcessCode) {
		SpecialProcessCode = specialProcessCode;
	}

	public String getSupplierTaxNumber() {
		return SupplierTaxNumber;
	}

	public void setSupplierTaxNumber(String supplierTaxNumber) {
		SupplierTaxNumber = supplierTaxNumber;
	}

	public String getSupplierCountryCode() {
		return SupplierCountryCode;
	}

	public void setSupplierCountryCode(String supplierCountryCode) {
		SupplierCountryCode = supplierCountryCode;
	}

	public String getTireStatus() {
		return TireStatus;
	}

	public void setTireStatus(String tireStatus) {
		TireStatus = tireStatus;
	}

	public BigDecimal getTotalEstimatedWeight() {
		return TotalEstimatedWeight;
	}

	public void setTotalEstimatedWeight(BigDecimal totalEstimatedWeight) {
		TotalEstimatedWeight = totalEstimatedWeight;
	}

	public BigDecimal getTotalWidthMeasure() {
		return TotalWidthMeasure;
	}

	public void setTotalWidthMeasure(BigDecimal totalWidthMeasure) {
		TotalWidthMeasure = totalWidthMeasure;
	}

	public BigDecimal getTotalLenghtMeasure() {
		return TotalLenghtMeasure;
	}

	public void setTotalLenghtMeasure(BigDecimal totalLenghtMeasure) {
		TotalLenghtMeasure = totalLenghtMeasure;
	}

	public BigDecimal getTotalHeightMeasure() {
		return TotalHeightMeasure;
	}

	public void setTotalHeightMeasure(BigDecimal totalHeightMeasure) {
		TotalHeightMeasure = totalHeightMeasure;
	}

	public Integer getTransportationModeCode() {
		return TransportationModeCode;
	}

	public void setTransportationModeCode(Integer transportationModeCode) {
		TransportationModeCode = transportationModeCode;
	}

	public String getTransportationType() {
		return TransportationType;
	}

	public void setTransportationType(String transportationType) {
		TransportationType = transportationType;
	}

	public BigDecimal getVolumeCapacity() {
		return VolumeCapacity;
	}

	public void setVolumeCapacity(BigDecimal volumeCapacity) {
		VolumeCapacity = volumeCapacity;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}

	public BigDecimal getVolumeTotalQuantity() {
		return VolumeTotalQuantity;
	}

	public void setVolumeTotalQuantity(BigDecimal volumeTotalQuantity) {
		VolumeTotalQuantity = volumeTotalQuantity;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getShipCityTaxCode() {
		return ShipCityTaxCode;
	}

	public void setShipCityTaxCode(String shipCityTaxCode) {
		ShipCityTaxCode = shipCityTaxCode;
	}

	@Override
	public String toString() {
		return "AdvancedShipmentNotificationPost [ASNItems=" + ASNItems + ", AsnNumber=" + AsnNumber + ", AsnStatus="
				+ AsnStatus + ", company=" + company + ", BoardingInstructionsText=" + BoardingInstructionsText
				+ ", carrier=" + carrier + ", ContainerType=" + ContainerType + ", DangerousFormNumber="
				+ DangerousFormNumber + ", DivisibleLoadStatus=" + DivisibleLoadStatus
				+ ", EstimatedCarriageValueAmount=" + EstimatedCarriageValueAmount + ", ExtraServiceAmount="
				+ ExtraServiceAmount + ", FederalPoliceAmount=" + FederalPoliceAmount + ", FragileLoadStatus="
				+ FragileLoadStatus + ", HasShiptToInItem=" + HasShiptToInItem + ", ImportDocument=" + ImportDocument
				+ ", ImportDeclarationNumber=" + ImportDeclarationNumber + ", incoterm=" + incoterm
				+ ", InvoiceQuantity=" + InvoiceQuantity + ", InvoiceValueAmount=" + InvoiceValueAmount
				+ ", InsuranceStatus=" + InsuranceStatus + ", IssuingDate=" + IssuingDate + ", LicenseAmount="
				+ LicenseAmount + ", NfeNumber=" + NfeNumber + ", ObservationTEXT=" + ObservationTEXT + ", OnuNumber="
				+ OnuNumber + ", ReclaimEstimatedDate=" + ReclaimEstimatedDate + ", ReclaimEstimatedHour="
				+ ReclaimEstimatedHour + ", ReclaimNumber=" + ReclaimNumber + ", reclaimOrigin=" + reclaimOrigin
				+ ", RegisterCreationHour=" + RegisterCreationHour + ", RegisteredFederalPoliceQuantity="
				+ RegisteredFederalPoliceQuantity + ", RollingLoadStatus=" + RollingLoadStatus
				+ ", SelfSupportingLoadStatus=" + SelfSupportingLoadStatus + ", shipTo=" + shipTo
				+ ", SpecialProcessCode=" + SpecialProcessCode + ", SupplierTaxNumber=" + SupplierTaxNumber
				+ ", SupplierCountryCode=" + SupplierCountryCode + ", TireStatus=" + TireStatus
				+ ", TotalEstimatedWeight=" + TotalEstimatedWeight + ", TotalWidthMeasure=" + TotalWidthMeasure
				+ ", TotalLenghtMeasure=" + TotalLenghtMeasure + ", TotalHeightMeasure=" + TotalHeightMeasure
				+ ", TransportationModeCode=" + TransportationModeCode + ", TransportationType=" + TransportationType
				+ ", VolumeCapacity=" + VolumeCapacity + ", VehicleType=" + VehicleType + ", VolumeTotalQuantity="
				+ VolumeTotalQuantity + ", Username=" + Username + ", ShipCityTaxCode=" + ShipCityTaxCode + "]";
	}

}
