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

	public Gerado setStatus(String status) {
		Status = status;
		return this;
	}

	public String getPath() {
		return path;
	}
	
	public String getFileName() {
		String[] pathSplit = path.split("/");
		return pathSplit[pathSplit.length - 1];
	}

	public Gerado setPath(String path) {
		this.path = path;
		return this;
	}

	@Override
	public String toString() {
		return "Gerado [Status=" + Status + ", path=" + path + "]";
	}

}
