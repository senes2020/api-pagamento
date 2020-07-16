package com.pagamento.senes.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pagamento.senes.dto.CartaoDTO;
import com.pagamento.senes.entity.CartaoCredito;

@Component
public class DtoToCartaoConverte implements Converter<CartaoDTO, CartaoCredito>{

	@Override
	public CartaoCredito convert(CartaoDTO cartaoDTO) {
		CartaoCredito cartao = new CartaoCredito();
		cartao.setData_validade(cartaoDTO.getData_validade());
		cartao.setNome(cartaoDTO.getNome());
		cartao.setNumero(cartaoDTO.getNumero());
		cartao.setCvv(cartaoDTO.getCvv());
		return cartao;
	}
}
