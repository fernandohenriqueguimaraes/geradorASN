package br.com.geradorASN.entity.xml;

public class Gerado {

	private String Status;

	private String path;

	public Gerado() {
	}

	public Gerado(String status, String path) {
		this.Status = status;
		this.path = path;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Gerado [Status=" + Status + ", path=" + path + "]";
	}

}
