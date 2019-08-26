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

import com.jraimundo.homebank_service.model.Pessoa;
import com.jraimundo.homebank_service.repository.PessoaRepository;
import com.jraimundo.homebank_service.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired 
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping	
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSave = pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
		.buildAndExpand(pessoaSave.getId()).toUri();		
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(pessoaSave);
	}
	
	@GetMapping("/{id}")
	public Optional<Pessoa> findById(@PathVariable Long id) {
		return pessoaRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSave = pessoaService.update(id, pessoa);
		return ResponseEntity.ok(pessoaSave);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
}