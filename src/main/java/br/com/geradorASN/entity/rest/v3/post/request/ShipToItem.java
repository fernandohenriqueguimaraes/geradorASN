package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class ShipToItem {

	private String Name;
	private String FiscalIdentifier;
	private String CountryCode;
	private Address address;

	public ShipToItem() {
		setAddress(new Address());
		setName(StringUtils.EMPTY);
		setFiscalIdentifier(StringUtils.EMPTY);
		setCountryCode(StringUtils.EMPTY);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ShipToItem [Name=" + Name + ", FiscalIdentifier=" + FiscalIdentifier + ", CountryCode=" + CountryCode
				+ ", address=" + address + "]";
	}

}
