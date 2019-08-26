package com.jraimundo.homebank_service.model.enu;

public enum TipoConta {
	
	MATRIZ ("MATRIZ"),
	FILIAL ("FILIAL");
	
	private String nome;
	
	private TipoConta(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
