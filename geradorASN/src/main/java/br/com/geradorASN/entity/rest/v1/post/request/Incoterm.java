package br.com.geradorASN.entity.rest.v1.post.request;

public class Incoterm {
	
    private String Code;
    private String Description;
    
	public Incoterm() {
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
