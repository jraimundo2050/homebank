package com.jraimundo.homebank_service.model.enu;

public enum StatusConta {
	
	ATIVA ("A"),
	BLOQUEADA ("B"),
	CANCELADA("C");
	
	private String nome;
	
	private StatusConta(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
