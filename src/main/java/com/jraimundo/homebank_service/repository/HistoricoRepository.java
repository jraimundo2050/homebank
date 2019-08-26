package com.jraimundo.homebank_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jraimundo.homebank_service.model.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

}
