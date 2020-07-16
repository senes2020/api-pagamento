package com.pagamento.senes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.pagamento.senes.dto.ProfissionalDTO;
import com.pagamento.senes.entity.Profissional;
import com.pagamento.senes.exception.ProfissionalNaoEncontradoException;
import com.pagamento.senes.servico.ProfissionalService;

@Component
public class DtoToProfissionalConverte implements Converter<ProfissionalDTO, Profissional>{

	@Autowired
	private ProfissionalService profissionalService;
	
	@Override
	public Profissional convert(ProfissionalDTO profissionalDTO) {
		Profissional profissional = profissionalService.buscarProfissional(profissionalDTO);
		if (!ObjectUtils.isEmpty(profissional)) {
			return profissional;
		} else {
			throw new ProfissionalNaoEncontradoException(profissionalDTO.getId_profissional());
		}
	}
	
}
