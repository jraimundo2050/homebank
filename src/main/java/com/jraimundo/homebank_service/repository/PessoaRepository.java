package com.jraimundo.homebank_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jraimundo.homebank_service.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
