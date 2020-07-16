package com.pagamento.senes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.pagamento.senes.dto.PagamentoDTO;
import com.pagamento.senes.entity.FormaPagamento;
import com.pagamento.senes.entity.Pagamento;
import com.pagamento.senes.exception.CartaoNuloException;

@Component
public class DtoToPagamentoConverte implements Converter<PagamentoDTO, Pagamento>{
	
	@Autowired
	private DtoToCartaoConverte cartaoConverte;

	@Override
	public Pagamento convert(PagamentoDTO pagamentoDTO) {
		Pagamento pagamento = new Pagamento();
		if (FormaPagamento.CARTAO_CREDITO.equals(pagamentoDTO.getForma())) {
			if (ObjectUtils.isEmpty(pagamentoDTO.getCartao())) {
				throw new CartaoNuloException();
			}
			pagamento.setCartao(cartaoConverte.convert(pagamentoDTO.getCartao()));
		}

		pagamento.setForma(pagamentoDTO.getForma());
		pagamento.setValor(pagamentoDTO.getValor());
		return pagamento;
	}
	
}
