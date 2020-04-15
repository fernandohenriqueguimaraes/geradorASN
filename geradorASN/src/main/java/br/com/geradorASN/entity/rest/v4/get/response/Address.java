package br.com.geradorASN.entity.rest.v4.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty("address")
	private String address;

	@JsonProperty("complement")
	private String complement;

	@JsonProperty("city")
	private String city;

	@JsonProperty("zipCode")
	private String zipCode;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	public String getAddress() {
		return address;
	}

	public String getComplement() {
		return complement;
	}

	public String getCity() {
		return city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", complement=" + complement + ", city=" + city + ", zipCode=" + zipCode
				+ ", state=" + state + ", country=" + country + "]";
	}

}
