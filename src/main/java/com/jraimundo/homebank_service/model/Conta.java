package com.jraimundo.homebank_service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jraimundo.homebank_service.model.enu.StatusConta;
import com.jraimundo.homebank_service.model.enu.TipoConta;

@Entity
@Table(name = "conta_tb")
public class Conta  implements Serializable {

	private static final long serialVersionUID = 7212689333368121148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(value = TemporalType.DATE) 
	private Date dt_criacao;
	
	private BigDecimal saldo;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@OneToMany
	@Column(name = "contamat_id")
	private Collection<Conta> contaMatriz;
	
	@Enumerated(EnumType.STRING)
	private StatusConta status;
	
	@Enumerated(EnumType.STRING)
	private TipoConta tpConta;

	public Conta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDt_criacao() {
		return dt_criacao;
	}

	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Collection<Conta> getContaMatriz() {
		return contaMatriz;
	}

	public void setContaMatriz(Collection<Conta> contaMatriz) {
		this.contaMatriz = contaMatriz;
	}

	public StatusConta getStatus() {
		return status;
	}

	public void setStatus(StatusConta status) {
		this.status = status;
	}

	public TipoConta getTpConta() {
		return tpConta;
	}

	public void setTpConta(TipoConta tpConta) {
		this.tpConta = tpConta;
	}

}
