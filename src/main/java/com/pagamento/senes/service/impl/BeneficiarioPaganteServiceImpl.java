package com.pagamento.senes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamento.senes.entity.BeneficiarioPagante;
import com.pagamento.senes.repository.BeneficiarioPaganteRepository;
import com.pagamento.senes.servico.BeneficiarioPaganteService;

@Service
public class BeneficiarioPaganteServiceImpl implements BeneficiarioPaganteService{

	@Autowired
	private BeneficiarioPaganteRepository beneficiarioPaganteRepository;

	@Override
	public BeneficiarioPagante buscarBeneficiario(BeneficiarioPagante beneficiarioPagante) {
		return beneficiarioPaganteRepository.findById(beneficiarioPagante.getId_beneficiario()).get();
	}

	@Override
	public BeneficiarioPagante buscarBeneficiarioCPF(String cpf) {
		return beneficiarioPaganteRepository.findByCpf(cpf);
	}

	@Override
	public BeneficiarioPagante salvarBeneficiario(BeneficiarioPagante beneficiarioPagante) {
		return beneficiarioPaganteRepository.save(beneficiarioPagante);
	}
	
}