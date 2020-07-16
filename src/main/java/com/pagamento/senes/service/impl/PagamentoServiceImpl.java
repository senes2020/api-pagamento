package com.pagamento.senes.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.pagamento.senes.dto.RequisicaoPagamentoDTO;
import com.pagamento.senes.dto.RespostaPagamentoDTO;
import com.pagamento.senes.entity.BeneficiarioPagante;
import com.pagamento.senes.entity.CartaoCredito;
import com.pagamento.senes.entity.Dinheiro;
import com.pagamento.senes.entity.FormaPagamento;
import com.pagamento.senes.entity.Pagamento;
import com.pagamento.senes.entity.Profissional;
import com.pagamento.senes.entity.Status;
import com.pagamento.senes.repository.PagamentoRepository;
import com.pagamento.senes.servico.BeneficiarioPaganteService;
import com.pagamento.senes.servico.CartaoService;
import com.pagamento.senes.servico.DinheiroService;
import com.pagamento.senes.servico.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService{

	@Autowired
	private PagamentoRepository pagamentoRepositorio;

	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private BeneficiarioPaganteService beneficiarioPaganteService;

	@Autowired
	private DinheiroService dinheiroService;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO) {

		Pagamento pag = conversionService.convert(requisicaoPagamentoDTO.getPagamento(), Pagamento.class);

		// Converte o profissional a ser pago e atribui no pagamento
		Profissional profissional = conversionService.convert
				(requisicaoPagamentoDTO.getProfissional(), Profissional.class);
			pag.setProfissional(profissional);

		// Verifica se existe o beneficiario pagante
		BeneficiarioPagante beneficiarioPagante = beneficiarioPaganteService
				.buscarBeneficiarioCPF(requisicaoPagamentoDTO.getBeneficiario().getCpf());
		if (!ObjectUtils.isEmpty(beneficiarioPagante)) {
			pag.setBeneficiario(beneficiarioPagante);
		} else {
			BeneficiarioPagante beneficiarioPaganteNovo = conversionService
					.convert(requisicaoPagamentoDTO.getBeneficiario(), BeneficiarioPagante.class);
			pag.setBeneficiario(beneficiarioPaganteService.salvarBeneficiario(beneficiarioPaganteNovo));
		}

		// Verifica a forma de pagamento
		if (FormaPagamento.CARTAO_CREDITO.equals(pag.getForma())) {
			CartaoCredito cc = (CartaoCredito) pag.getCartao();
			cartaoService.validarCartao(cc);
			cc.setTipo_bandeira(cartaoService.identificarBandeira(cc.getNumero()));
			pag.setCartao(cartaoService.salvarCartao(cc));
			pag.setStatus(Status.ENVIADO);

		} else if (FormaPagamento.DINHEIRO.equals(pag.getForma())) {
			Dinheiro dinheiro = new Dinheiro();
			pag.setDinheiro(dinheiroService.salvarExtrato(dinheiro));
			pag.setStatus(Status.PROCESSANDO);
		}
		pag.setData_cadastro(LocalDate.now());

		Pagamento pagamento = pagamentoRepositorio.save(pag);

		RespostaPagamentoDTO respostaPagamentoDTO = new RespostaPagamentoDTO();
		respostaPagamentoDTO.setId_pagamento(pagamento.getId_pagamento());
		respostaPagamentoDTO.setValor(pagamento.getValor());
		respostaPagamentoDTO.setForma_pagamento(pagamento.getForma());
		respostaPagamentoDTO.setStatus(pagamento.getStatus());
		
		return respostaPagamentoDTO;
	}

	@Override
	public Pagamento buscarPagamento(Long idPagamento) {
		Pagamento pag = pagamentoRepositorio.findById(idPagamento).orElse(null);
		if (ObjectUtils.isEmpty(pag)) {
			return null;
		}
		String cpfNovo = this.esconderCPF(pag.getBeneficiario().getCpf());
		pag.getBeneficiario().setCpf(cpfNovo);
		return pag;
	}

	@Override
	public String esconderCPF(String cpf) {
		if (ObjectUtils.isEmpty(cpf)) {
			return null;
		}
		String cpfNovo = "";
		for (int x = 0; x < cpf.length() - 2; x++) {
			cpfNovo += "*";
		}
		return cpfNovo + cpf.substring(cpf.length() - 2);
	}

	@Override
	public boolean removerPagamento(Long idPagamento) {
		Pagamento pag = pagamentoRepositorio.findById(idPagamento).orElse(null);
		if (ObjectUtils.isEmpty(pag)) {
			return false;
		}
		pagamentoRepositorio.delete(pag);
		return true;
	}

}
