package com.jraimundo.homebank_service.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jraimundo.homebank_service.model.Conta;
import com.jraimundo.homebank_service.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta update(Long id, Conta conta) {
		Optional<Conta> contaSave = contaRepository.findById(id);
		if (contaSave == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(conta, contaSave, "id");
		return contaRepository.save(conta);
	}	

}
