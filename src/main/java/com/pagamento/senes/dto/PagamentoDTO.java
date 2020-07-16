package com.pagamento.senes.dto;

import com.pagamento.senes.entity.FormaPagamento;
import com.sun.istack.NotNull;

public class PagamentoDTO {

	@NotNull
	private Double valor;
	@NotNull
	private FormaPagamento forma;
	@NotNull
	private CartaoDTO cartao;
	
	public PagamentoDTO(Double valor, FormaPagamento forma, CartaoDTO cartao) {
		super();
		this.valor = valor;
		this.forma = forma;
		this.cartao = cartao;
	}
	
	public PagamentoDTO() {

	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public FormaPagamento getForma() {
		return forma;
	}
	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}
	public CartaoDTO getCartao() {
		return cartao;
	}
	public void setCartao(CartaoDTO cartao) {
		this.cartao = cartao;
	}

	@Override
	public String toString() {
		return "PagamentoDTO [valor=" + valor + ", forma=" + forma + ", cartao=" + cartao + "]";
	}
	
}
