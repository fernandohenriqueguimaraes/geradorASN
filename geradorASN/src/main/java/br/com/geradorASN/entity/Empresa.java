package br.com.geradorASN.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Empresa")
@Table(name = "Empresa", schema = "app")
public class Empresa implements Serializable {

	private static final long serialVersionUID = -3956529632368979500L;

	public static final String GERA_ASN_SIM = "Sim";
	public static final String GERA_ASN_NAO = "Não";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "cnpj", unique = true, length = 20)
	private String cnpj;

	@Column(name = "bairro", length = 50)
	private String bairro;

	@Column(name = "cep", length = 15)
	private String cep;

	@Column(name = "logradouro", length = 80)
	private String logradouro;

	@Column(name = "numero", length = 10)
	private String numero;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@Column(name = "municipio", length = 30)
	private String municipio;

	@Column(name = "pais", length = 20)
	private String pais;

	@Column(name = "codigoPais", length = 4)
	private String codigoPais;

	@Column(name = "tipo", length = 20)
	private String tipo;

	@Column(name = "razaoSocial", length = 80)
	private String razaoSocial;

	@Column(name = "codigoEmpresa", length = 10)
	private String codigoEmpresa;

	@Column(name = "codigoERP", length = 10)
	private String codigoERP;

	@Column(name = "geraASN", nullable = false)
	private Boolean geraASN;

	public String getBairro() {
		return bairro;
	}

	public Empresa setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Empresa setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Empresa setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Empresa setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public Empresa setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getMunicipio() {
		return municipio;
	}

	public Empresa setMunicipio(String municipio) {
		this.municipio = municipio;
		return this;
	}

	public String getPais() {
		return pais;
	}

	public Empresa setPais(String pais) {
		this.pais = pais;
		return this;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public Empresa setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
		return this;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Empresa setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public String getTipo() {
		return tipo;
	}

	public Empresa setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public Empresa setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public Empresa setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
		return this;
	}

	public String getCodigoERP() {
		return codigoERP;
	}

	public Empresa setCodigoERP(String codigoERP) {
		this.codigoERP = codigoERP;
		return this;
	}

	public boolean isGeraASN() {
		return geraASN;
	}

	public String geraASNtoString() {

		if (this.geraASN) {
			return GERA_ASN_SIM;
		}

		return GERA_ASN_NAO;

	}

	public Empresa geraASNtoBoolean(String geraASN) {

		if (geraASN.equals(geraASN)) {
			this.setGeraASN(true);
		} else {
			this.setGeraASN(false);
		}

		return this;

	}

	public Empresa setGeraASN(boolean geraASN) {
		this.geraASN = geraASN;
		return this;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", cnpj=" + cnpj + ", bairro=" + bairro + ", cep=" + cep + ", logradouro="
				+ logradouro + ", numero=" + numero + ", complemento=" + complemento + ", municipio=" + municipio
				+ ", pais=" + pais + ", codigoPais=" + codigoPais + ", tipo=" + tipo + ", razaoSocial=" + razaoSocial
				+ ", codigoEmpresa=" + codigoEmpresa + ", codigoERP=" + codigoERP + ", geraASN=" + geraASN + "]";
	}

}
