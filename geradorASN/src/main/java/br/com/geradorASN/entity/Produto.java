package br.com.geradorASN.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.geradorASN.entity.Enum.TipoProdutoEnum;

@Entity(name = "Produto")
@Table(name = "Produto", schema = "app")
public class Produto implements Serializable {

	private static final long serialVersionUID = 6071715629766239992L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "partNumber", unique = true, length = 10)
	private String partNumber;

	@Column(name = "cai", length = 10)
	private String cai;

	@Column(name = "cad", length = 15)
	private String cad;

	@Column(name = "modelo", length = 50)
	private String modelo;

	@Column(name = "tipoProduto", length = 20)
	private String tipoProduto;

	@Column(name = "unidadeMedida", length = 10)
	private String unidadeMedida;

	@Column(name = "volume", precision = 16, scale = 2)
	private BigDecimal volume;

	@Column(name = "altura", precision = 16, scale = 2)
	private BigDecimal altura;

	@Column(name = "largura", precision = 16, scale = 2)
	private BigDecimal largura;

	@Column(name = "comprimento", precision = 16, scale = 2)
	private BigDecimal comprimento;

	public String getPartNumber() {
		return partNumber;
	}

	public Produto setPartNumber(String partNumber) {
		this.partNumber = partNumber;
		return this;
	}

	public String getModelo() {
		return modelo;
	}

	public Produto setModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public Produto setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
		return this;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public Produto setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
		return this;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public Produto setVolume(BigDecimal volume) {
		this.volume = volume;
		return this;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public Produto setAltura(BigDecimal altura) {
		this.altura = altura;
		return this;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public Produto setLargura(BigDecimal largura) {
		this.largura = largura;
		return this;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public Produto setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
		return this;
	}

	public String getCai() {
		return cai;
	}

	public Produto setCai(String cai) {
		this.cai = cai;
		return this;
	}

	public String getCad() {
		return cad;
	}

	public Produto setCad(String cad) {
		this.cad = cad;
		return this;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", partNumber=" + partNumber + ", cai=" + cai + ", cad=" + cad + ", modelo="
				+ modelo + ", tipoProduto=" + tipoProduto + ", unidadeMedida=" + unidadeMedida + ", volume=" + volume
				+ ", altura=" + altura + ", largura=" + largura + ", comprimento=" + comprimento + "]";
	}

}
