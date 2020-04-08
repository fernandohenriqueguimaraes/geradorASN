package br.com.geradorASN.entity.xml;

public class PedGeraArquivo {

	private String Filial;
	private String Nota;
	private String Serie;
	private String Tipo;
	private String Modelo;
	public String getFilial() {
		return Filial;
	}
	public PedGeraArquivo setFilial(String filial) {
		Filial = filial;
		return this;
	}
	public String getNota() {
		return Nota;
	}
	public PedGeraArquivo setNota(String nota) {
		Nota = nota;
		return this;
	}
	public String getSerie() {
		return Serie;
	}
	public PedGeraArquivo setSerie(String serie) {
		Serie = serie;
		return this;
	}
	public String getTipo() {
		return Tipo;
	}
	public PedGeraArquivo setTipo(String tipo) {
		Tipo = tipo;
		return this;
	}
	public String getModelo() {
		return Modelo;
	}
	public PedGeraArquivo setModelo(String modelo) {
		Modelo = modelo;
		return this;
	}
	@Override
	public String toString() {
		return "PedGeraArquivo [Filial=" + Filial + ", Nota=" + Nota + ", Serie=" + Serie + ", Tipo=" + Tipo
				+ ", Modelo=" + Modelo + "]";
	}

}

