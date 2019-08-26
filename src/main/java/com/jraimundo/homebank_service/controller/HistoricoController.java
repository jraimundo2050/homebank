package com.jraimundo.homebank_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jraimundo.homebank_service.model.Historico;
import com.jraimundo.homebank_service.repository.HistoricoRepository;
import com.jraimundo.homebank_service.service.HistoricoService;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping
	public List<Historico> listar() {
		return historicoRepository.findAll();
	}	
	
}
