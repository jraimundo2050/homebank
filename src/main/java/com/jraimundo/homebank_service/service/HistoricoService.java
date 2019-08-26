package com.jraimundo.homebank_service.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jraimundo.homebank_service.model.Historico;
import com.jraimundo.homebank_service.repository.HistoricoRepository;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	public Historico update(Long id, Historico historico) {
		Optional<Historico> historicoSave = historicoRepository.findById(id);
		if (historicoSave == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(historico, historicoSave, "id");
		return historicoRepository.save(historico);
	}		
	
}
