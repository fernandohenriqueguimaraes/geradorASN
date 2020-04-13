package br.com.geradorASN.entity.rest.v1.post.request;

public class Company {

	private String Code;
	private String Name;
	private String FiscalIdentifier;
	private String CountryCode;
	private Contact contact;

	public Company() {
		setContact(new Contact());
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFiscalIdentifier() {
		return FiscalIdentifier;
	}

	public void setFiscalIdentifier(String fiscalIdentifier) {
		FiscalIdentifier = fiscalIdentifier;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Company [Code=" + Code + ", Name=" + Name + ", FiscalIdentifier=" + FiscalIdentifier + ", CountryCode="
				+ CountryCode + ", contact=" + contact + "]";
	}

}
