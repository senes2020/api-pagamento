package com.pagamento.senes.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pagamento.senes.dto.BeneficiarioPaganteDTO;
import com.pagamento.senes.entity.BeneficiarioPagante;

@Component
public class DtoToBeneficiarioConverte implements Converter<BeneficiarioPaganteDTO, BeneficiarioPagante>{

	@Override
	public BeneficiarioPagante convert(BeneficiarioPaganteDTO beneficiarioPaganteDTO) {
		BeneficiarioPagante beneficiarioPagante = new BeneficiarioPagante();
		beneficiarioPagante.setCpf(beneficiarioPaganteDTO.getCpf());
		beneficiarioPagante.setEmail(beneficiarioPaganteDTO.getEmail());
		beneficiarioPagante.setNome(beneficiarioPaganteDTO.getNome());
		
		return beneficiarioPagante;
	}

}
