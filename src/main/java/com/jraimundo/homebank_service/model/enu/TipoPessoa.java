package com.jraimundo.homebank_service.model.enu;

public enum TipoPessoa {
	
	FISICA ("FISICA"),
	JURIDICA ("JURIDICA");
	
	private String nome;
	
	private TipoPessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
