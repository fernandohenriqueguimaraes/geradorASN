package br.com.geradorASN.entity.xml;

public class Imposto {

	private String vTotTrib;
	ICMS ICMSObject;
	IPI IPIObject;
	PIS PISObject;
	COFINS COFINSObject;

	public String getVTotTrib() {
		return vTotTrib;
	}

	public ICMS getICMS() {
		return ICMSObject;
	}

	public IPI getIPI() {
		return IPIObject;
	}

	public PIS getPIS() {
		return PISObject;
	}

	public COFINS getCOFINS() {
		return COFINSObject;
	}

	public void setVTotTrib(String vTotTrib) {
		this.vTotTrib = vTotTrib;
	}

	public void setICMS(ICMS ICMSObject) {
		this.ICMSObject = ICMSObject;
	}

	public void setIPI(IPI IPIObject) {
		this.IPIObject = IPIObject;
	}

	public void setPIS(PIS PISObject) {
		this.PISObject = PISObject;
	}

	public void setCOFINS(COFINS COFINSObject) {
		this.COFINSObject = COFINSObject;
	}
}
