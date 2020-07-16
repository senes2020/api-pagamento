package com.pagamento.senes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamento.senes.dto.ProfissionalDTO;
import com.pagamento.senes.entity.Profissional;
import com.pagamento.senes.repository.ProfissionalRepository;
import com.pagamento.senes.servico.ProfissionalService;

@Service
public class ProfissionalServiceImpl implements ProfissionalService{

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Override
	public Profissional buscarProfissional(ProfissionalDTO profissionalDTO) {
		return profissionalRepository.findById(profissionalDTO.getId_profissional()).orElse(null);
	}

}