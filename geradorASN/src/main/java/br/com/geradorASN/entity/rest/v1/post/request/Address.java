package br.com.geradorASN.entity.rest.v1.post.request;

public class Address {

	private String StreetAddress;
	private String ComplementNumber;
	private String PostalCode;
	private String CityName;
	private String RegionCode;
	private String PhoneNumber;
	private String CityCode;
	
	public Address() {
	}
	
	public String getStreetAddress() {
		return StreetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}
	public String getComplementNumber() {
		return ComplementNumber;
	}
	public void setComplementNumber(String complementNumber) {
		ComplementNumber = complementNumber;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getRegionCode() {
		return RegionCode;
	}
	public void setRegionCode(String regionCode) {
		RegionCode = regionCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCityCode() {
		return CityCode;
	}
	public void setCityCode(String cityCode) {
		CityCode = cityCode;
	}

	public String toString() {
		return "Address [StreetAddress=" + StreetAddress + ", ComplementNumber=" + ComplementNumber + ", PostalCode="
				+ PostalCode + ", CityName=" + CityName + ", RegionCode=" + RegionCode + ", PhoneNumber=" + PhoneNumber
				+ ", CityCode=" + CityCode + "]";
	}
	
}
