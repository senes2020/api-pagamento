package com.pagamento.senes.servico;

import com.pagamento.senes.dto.ProfissionalDTO;
import com.pagamento.senes.entity.Profissional;

public interface ProfissionalService {

	public Profissional buscarProfissional(ProfissionalDTO pofProfissionalDTO);
	
}
