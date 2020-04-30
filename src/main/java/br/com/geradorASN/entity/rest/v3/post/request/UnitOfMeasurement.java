package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class UnitOfMeasurement {
	
	private String Code;
	private String Description;
	
	public UnitOfMeasurement() {
		setCode(StringUtils.EMPTY);
		setDescription(StringUtils.EMPTY);
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "UnitOfMeasurement [Code=" + Code + ", Description=" + Description + "]";
	}
	
}
