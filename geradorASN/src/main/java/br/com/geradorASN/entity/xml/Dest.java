package br.com.geradorASN.entity.xml;

public class Dest {

	private String CNPJ;
	private String xNome;
	EnderDest EnderDestObject;
	private String indIEDest;
	private String IE;

	public String getCNPJ() {
		return CNPJ;
	}

	public String getXNome() {
		return xNome;
	}

	public EnderDest getEnderDest() {
		return EnderDestObject;
	}

	public String getIndIEDest() {
		return indIEDest;
	}

	public String getIE() {
		return IE;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public void setXNome(String xNome) {
		this.xNome = xNome;
	}

	public void setEnderDest(EnderDest enderDestObject) {
		this.EnderDestObject = enderDestObject;
	}

	public void setIndIEDest(String indIEDest) {
		this.indIEDest = indIEDest;
	}

	public void setIE(String IE) {
		this.IE = IE;
	}
}
