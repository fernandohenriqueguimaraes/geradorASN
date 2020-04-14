package br.com.geradorASN.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Relatorio")
@Table(name = "Relatorio", schema = "app")
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 2475301373438025181L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "reference", unique = true, length = 45, nullable = false)
	private String reference;
	
	@Column(name = "asn", unique = true, length = 45)
	private String numeroASN;
	
	@Column(name = "status", length = 45, nullable = false)
	private String status;
	
	@Column(name = "motivo", length = 45)
	private String motivo;
	
	@Column(name = "data")
	@CreationTimestamp
	private LocalDate dataProcessamento;

	public long getId() {
		return id;
	}

	public String getReference() {
		return reference;
	}

	public Relatorio setReference(String reference) {
		this.reference = reference;
		return this;
	}

	public String getNumeroASN() {
		return numeroASN;
	}

	public Relatorio setNumeroASN(String numeroASN) {
		this.numeroASN = numeroASN;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Relatorio setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMotivo() {
		return motivo;
	}

	public Relatorio setMotivo(String motivo) {
		this.motivo = motivo;
		return this;
	}

	public LocalDate getDataProcessamento() {
		return dataProcessamento;
	}

	public Relatorio setDataProcessamento(LocalDate dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
		return this;
	}

	@Override
	public String toString() {
		return "Relatorio [id=" + id + ", reference=" + reference + ", numeroASN=" + numeroASN + ", status=" + status
				+ ", motivo=" + motivo + ", dataProcessamento=" + dataProcessamento + "]";
	}
	
}
