package com.jraimundo.homebank_service.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jraimundo.homebank_service.model.Conta;
import com.jraimundo.homebank_service.repository.ContaRepository;
import com.jraimundo.homebank_service.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
		@Autowired
		private ContaRepository contaRepository;
		
		@Autowired
		private ContaService contaService;
		
		@GetMapping
		public List<Conta> listar() {
			return contaRepository.findAll();
		}
		
		@PostMapping	
		public ResponseEntity<Conta> save(@RequestBody Conta conta, HttpServletResponse response) {
			Conta contaSave = contaRepository.save(conta);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
			.buildAndExpand(contaSave.getId()).toUri();		
			response.setHeader("Location", uri.toASCIIString());
			return ResponseEntity.created(uri).body(contaSave);
		}

		
		@GetMapping("/{id}")
		public Optional<Conta> findById(@PathVariable Long id) {
			return contaRepository.findById(id);
		}
			
		@PutMapping("/{id}")
		public ResponseEntity<Conta> atualizar(@PathVariable Long id, @Valid @RequestBody Conta conta) {
			Conta contaSave = contaService.update(id, conta);
			return ResponseEntity.ok(contaSave);
		}
		
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			contaRepository.deleteById(id);
		}
		
	}
