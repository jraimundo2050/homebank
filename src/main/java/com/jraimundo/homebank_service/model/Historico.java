package com.jraimundo.homebank_service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "historico_tb")
public class Historico implements Serializable {

	private static final long serialVersionUID = 7212689333368121148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(value = TemporalType.TIMESTAMP) 
	@Column(name = "DT_EMISSAO")
	private Calendar emissao;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "CONTA_ID")	
	private Conta conta;
	
	private BigDecimal valor;
	
	@Column(name = "NUM_APORTE")
	private String numAporte;
	
	public Historico() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getEmissao() {
		return emissao;
	}

	public void setEmissao(Calendar emissao) {
		this.emissao = emissao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNumAporte() {
		return numAporte;
	}

	public void setNumAporte(String numAporte) {
		this.numAporte = numAporte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((emissao == null) ? 0 : emissao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numAporte == null) ? 0 : numAporte.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historico other = (Historico) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (emissao == null) {
			if (other.emissao != null)
				return false;
		} else if (!emissao.equals(other.emissao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numAporte == null) {
			if (other.numAporte != null)
				return false;
		} else if (!numAporte.equals(other.numAporte))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Historico [id=" + id + ", emissao=" + emissao + ", descricao=" + descricao + ", conta=" + conta
				+ ", valor=" + valor + ", numAporte=" + numAporte + "]";
	}
	
	
}
