package com.pagamento.senes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamento.senes.entity.Dinheiro;
import com.pagamento.senes.repository.PagDinheiroRepository;
import com.pagamento.senes.servico.DinheiroService;

@Service
public class PagDinheiroServiceImpl implements DinheiroService{

	@Autowired
	private PagDinheiroRepository pagDinheiroRepository;
	
	@Override
	public Dinheiro salvarExtrato(Dinheiro dinheiro) {
		return pagDinheiroRepository.save(dinheiro);
	}
	
}
