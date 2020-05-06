package br.com.geradorASN.entity.rest.v3.post.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AdvancedShipmentNotificationPost {

	private List<ASNItem> ASNItem;

	private String AsnNumber;
	private String AsnStatus;
	private Company company;
	private String BoardingInstructionsText;
	private Carrier carrier;
	private Integer ContainerType;
	private String DangerousFormNumber;
	private String DivisibleLoadStatus;
	private Integer EstimatedCarriageValueAmount;
	private Integer ExtraServiceAmount;
	private Integer FederalPoliceAmount;
	private String FragileLoadStatus;
	private Boolean HasShiptToInItem;
	private String ImportDocument;
	private String ImportDeclarationNumber;
	private Incoterm incoterm;
	private String InvoiceQuantity;
	private BigDecimal InvoiceValueAmount;
	private String InsuranceStatus;
	private String IssuingDate;
	private Integer LicenseAmount;
	private String NfeNumber;
	private String ObservationTEXT;
	private String OnuNumber;
	private String ReclaimEstimatedDate;
	private String ReclaimEstimatedHour;
	private String ReclaimNumber;
	private ReclaimOrigin reclaimOrigin;
	private String RegisterCreationHour;
	private Integer RegisteredFederalPoliceQuantity;
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
	private String TransportationModeCode;
	private String TransportationType;
	private BigDecimal VolumeCapacity;
	private String VehicleType;
	private Integer VolumeTotalQuantity;
	private String Username;
	private String ShipCityTaxCode;

	public AdvancedShipmentNotificationPost() {
		setASNItem(new ArrayList<ASNItem>());
		setCompany(new Company());
		setCarrier(new Carrier());
		setIncoterm(new Incoterm());
		setReclaimOrigin(new ReclaimOrigin());
		setShipTo(new ShipTo());

		setAsnNumber(StringUtils.EMPTY);
		setAsnStatus(StringUtils.EMPTY);
		setBoardingInstructionsText(StringUtils.EMPTY);
		setContainerType(0);
		setDangerousFormNumber(StringUtils.EMPTY);
		setDivisibleLoadStatus(StringUtils.EMPTY);
		setEstimatedCarriageValueAmount(0);
		setExtraServiceAmount(0);
		setFederalPoliceAmount(0);
		setFragileLoadStatus(StringUtils.EMPTY);
		setHasShiptToInItem(false);
		setImportDocument(StringUtils.EMPTY);
		setImportDeclarationNumber(StringUtils.EMPTY);
		setInvoiceQuantity(StringUtils.EMPTY);
		setInvoiceValueAmount(new BigDecimal(0));
		setInsuranceStatus(StringUtils.EMPTY);
		setIssuingDate(StringUtils.EMPTY);
		setLicenseAmount(0);
		setNfeNumber(StringUtils.EMPTY);
		setObservationTEXT(StringUtils.EMPTY);
		setOnuNumber(StringUtils.EMPTY);
		setReclaimEstimatedDate(StringUtils.EMPTY);
		setReclaimEstimatedHour(StringUtils.EMPTY);
		setReclaimNumber(StringUtils.EMPTY);
		setRegisterCreationHour(StringUtils.EMPTY);
		setRegisteredFederalPoliceQuantity(0);
		setRollingLoadStatus(StringUtils.EMPTY);
		setSelfSupportingLoadStatus(StringUtils.EMPTY);
		setSpecialProcessCode(StringUtils.EMPTY);
		setSupplierTaxNumber(StringUtils.EMPTY);
		setSupplierCountryCode(StringUtils.EMPTY);
		setTireStatus(StringUtils.EMPTY);
		setTotalEstimatedWeight(new BigDecimal(0));;
		setTotalWidthMeasure(new BigDecimal(0));
		setTotalLenghtMeasure(new BigDecimal(0));
		setTotalHeightMeasure(new BigDecimal(0));
		setTransportationModeCode(StringUtils.EMPTY);
		setTransportationType(StringUtils.EMPTY);
		setVolumeCapacity(new BigDecimal(0));
		setVehicleType(StringUtils.EMPTY);
		setVolumeTotalQuantity(0);
		setUsername(StringUtils.EMPTY);
		setShipCityTaxCode(StringUtils.EMPTY);
	}
	
	@JsonGetter("ASNItem")
	public List<ASNItem> getASNItem() {
		return ASNItem;
	}

	public void setASNItem(List<ASNItem> ASNItem) {
		this.ASNItem = ASNItem;
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

	public Integer getEstimatedCarriageValueAmount() {
		return EstimatedCarriageValueAmount;
	}

	public void setEstimatedCarriageValueAmount(Integer i) {
		EstimatedCarriageValueAmount = i;
	}

	public Integer getExtraServiceAmount() {
		return ExtraServiceAmount;
	}

	public void setExtraServiceAmount(Integer i) {
		ExtraServiceAmount = i;
	}

	public Integer getFederalPoliceAmount() {
		return FederalPoliceAmount;
	}

	public void setFederalPoliceAmount(Integer i) {
		FederalPoliceAmount = i;
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

	public Integer getLicenseAmount() {
		return LicenseAmount;
	}

	public void setLicenseAmount(Integer i) {
		LicenseAmount = i;
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

	public Integer getRegisteredFederalPoliceQuantity() {
		return RegisteredFederalPoliceQuantity;
	}

	public void setRegisteredFederalPoliceQuantity(Integer i) {
		RegisteredFederalPoliceQuantity = i;
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

	public String getTransportationModeCode() {
		return TransportationModeCode;
	}

	public void setTransportationModeCode(String transportationModeCode) {
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

	public Integer getVolumeTotalQuantity() {
		return VolumeTotalQuantity;
	}

	public void setVolumeTotalQuantity(Integer i) {
		VolumeTotalQuantity = i;
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
		return "AdvancedShipmentNotificationPost [ASNItem=" + ASNItem + ", AsnNumber=" + AsnNumber + ", AsnStatus="
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
