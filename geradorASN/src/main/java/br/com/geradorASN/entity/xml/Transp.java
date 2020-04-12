package br.com.geradorASN.entity.xml;

public class Transp {
	private String modFrete;
	Transporta TransportaObject;
	Vol VolObject;

	public String getModFrete() {
		return modFrete;
	}

	public Transporta getTransporta() {
		return TransportaObject;
	}

	public Vol getVol() {
		return VolObject;
	}

	public void setModFrete(String modFrete) {
		this.modFrete = modFrete;
	}

	public void setTransporta(Transporta transportaObject) {
		this.TransportaObject = transportaObject;
	}

	public void setVol(Vol volObject) {
		this.VolObject = volObject;
	}
}
