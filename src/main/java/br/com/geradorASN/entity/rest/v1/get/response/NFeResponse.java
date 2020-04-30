package br.com.geradorASN.entity.rest.v1.get.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NFeResponse {

	@JsonProperty("Reference")
	private String reference;

	@JsonProperty("AccessKey")
	private String accessKey;

	@JsonProperty("DocumentDate")
	private String documentDate;

	@JsonProperty("RefusalDate")
	private String refusalDate;

	@JsonProperty("InvoiceResponse")
	private String invoiceResponse;

	@JsonProperty("Supplier")
	private SupplierResponse supplier;

	@JsonProperty("Buyer")
	private BuyerResponse buyer;

	@JsonProperty("TransporterCNPJ")
	private String transporterCNPJ;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("HeaderNote")
	private String headerNote;

	@JsonProperty("Language")
	private String language;

	@JsonProperty("Items")
	private List<ItemsResponse> items;

	@JsonProperty("Total")
	private Double total;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getRefusalDate() {
		return refusalDate;
	}

	public void setRefusalDate(String refusalDate) {
		this.refusalDate = refusalDate;
	}

	public String getInvoiceResponse() {
		return invoiceResponse;
	}

	public void setInvoiceResponse(String invoiceResponse) {
		this.invoiceResponse = invoiceResponse;
	}

	public SupplierResponse getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierResponse supplier) {
		this.supplier = supplier;
	}

	public BuyerResponse getBuyer() {
		return buyer;
	}

	public void setBuyer(BuyerResponse buyer) {
		this.buyer = buyer;
	}

	public String getTransporterCNPJ() {
		return transporterCNPJ;
	}

	public void setTransporterCNPJ(String transporterCNPJ) {
		this.transporterCNPJ = transporterCNPJ;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHeaderNote() {
		return headerNote;
	}

	public void setHeaderNote(String headerNote) {
		this.headerNote = headerNote;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<ItemsResponse> getItems() {
		return items;
	}

	public void setItems(List<ItemsResponse> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "NFeResponse [reference=" + reference + ", accessKey=" + accessKey + ", documentDate=" + documentDate
				+ ", refusalDate=" + refusalDate + ", invoiceResponse=" + invoiceResponse + ", supplier=" + supplier
				+ ", buyer=" + buyer + ", transporterCNPJ=" + transporterCNPJ + ", status=" + status + ", headerNote="
				+ headerNote + ", language=" + language + ", items=" + items + ", total=" + total + "]";
	}

}
