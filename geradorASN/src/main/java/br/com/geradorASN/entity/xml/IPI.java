package br.com.geradorASN.entity.xml;

public class IPI {

	private String cEnq;
	IPITrib IPITribObject;

	public String getCEnq() {
		return cEnq;
	}

	public IPITrib getIPITrib() {
		return IPITribObject;
	}

	public void setCEnq(String cEnq) {
		this.cEnq = cEnq;
	}

	public void setIPITrib(IPITrib IPITribObject) {
		this.IPITribObject = IPITribObject;
	}
}
