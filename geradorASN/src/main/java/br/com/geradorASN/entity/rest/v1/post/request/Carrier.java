package br.com.geradorASN.entity.rest.v1.post.request;

import org.apache.commons.lang3.StringUtils;

public class Carrier {

	private String Name;
	private String FiscalIdentifier;
	private Address address;

	public Carrier() {
		setAddress(new Address());
		setName(StringUtils.EMPTY);
		setFiscalIdentifier(StringUtils.EMPTY);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Carrier [Name=" + Name + ", FiscalIdentifier=" + FiscalIdentifier + ", address=" + address + "]";
	}

}
