package com.pagamento.senes.servico;

import com.pagamento.senes.entity.BeneficiarioPagante;

public interface BeneficiarioPaganteService {
	
	public BeneficiarioPagante buscarBeneficiario(BeneficiarioPagante beneficiarioPagante);
	
	public BeneficiarioPagante buscarBeneficiarioCPF(String cpf);
	
	public BeneficiarioPagante salvarBeneficiario(BeneficiarioPagante beneficiarioPagante);

}
