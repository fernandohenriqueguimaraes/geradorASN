package br.com.geradorASN.entity.xml;

public class Emit {

	private String CNPJ;
	private String xNome;
	private String xFant;
	EnderEmit EnderEmitObject;
	private String IE;
	private String IEST;
	private String CRT;

	public String getCNPJ() {
		return CNPJ;
	}

	public String getXNome() {
		return xNome;
	}

	public String getXFant() {
		return xFant;
	}

	public EnderEmit getEnderEmit() {
		return EnderEmitObject;
	}

	public String getIE() {
		return IE;
	}

	public String getIEST() {
		return IEST;
	}

	public String getCRT() {
		return CRT;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public void setXNome(String xNome) {
		this.xNome = xNome;
	}

	public void setXFant(String xFant) {
		this.xFant = xFant;
	}

	public void setEnderEmit(EnderEmit enderEmitObject) {
		this.EnderEmitObject = enderEmitObject;
	}

	public void setIE(String IE) {
		this.IE = IE;
	}

	public void setIEST(String IEST) {
		this.IEST = IEST;
	}

	public void setCRT(String CRT) {
		this.CRT = CRT;
	}
}
