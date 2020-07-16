package com.pagamento.senes.servico;

import java.time.LocalDate;

import com.pagamento.senes.entity.CartaoCredito;
import com.pagamento.senes.entity.TipoBandeira;

public interface CartaoService {
	
	public boolean validarCartao(CartaoCredito cartaoCredito);

	public boolean validarNumeroCartao(String numCartao);

	public boolean validarCvvCartao(String cvv);

	public boolean validarDataValidade(LocalDate dataValidade);

	public TipoBandeira identificarBandeira(String numCartao);

	public CartaoCredito salvarCartao(CartaoCredito cartaoCredito);
	
}
