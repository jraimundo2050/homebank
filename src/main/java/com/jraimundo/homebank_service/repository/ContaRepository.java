package com.jraimundo.homebank_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jraimundo.homebank_service.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
			

}
