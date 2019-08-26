package com.jraimundo.homebank_service.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jraimundo.homebank_service.model.Pessoa;
import com.jraimundo.homebank_service.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa update(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaSave = pessoaRepository.findById(id);
		if (pessoaSave == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(pessoa, pessoaSave, "id");
		return pessoaRepository.save(pessoa);
	}
			
}
