package br.com.geradorASN.entity.rest.v1.post.request;

public class UnitOfMeasurement {
	
	private String Code;
	private String Description;
	
	public UnitOfMeasurement() {
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
