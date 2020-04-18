package br.com.geradorASN.entity.rest.v1.post.request;

import org.apache.commons.lang3.StringUtils;

public class Incoterm {
	
    private String Code;
    private String Description;
    
	public Incoterm() {
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
		return "Incoterm [Code=" + Code + ", Description=" + Description + "]";
	}

}
