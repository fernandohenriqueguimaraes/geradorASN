package br.com.geradorASN.entity.rest.v4.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoodsSupplier {

	@JsonProperty("register")
	private Register register;

	@JsonProperty("address")
	private Address address;

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "GoodsSupplier [register=" + register + ", address=" + address + "]";
	}

}
