package com.pagamento.senes.dto;

import com.sun.istack.NotNull;

public class RequisicaoPagamentoDTO {

	@NotNull
	private PagamentoDTO pagamento;
	@NotNull
	private BeneficiarioPaganteDTO beneficiario;
	@NotNull
	private ProfissionalDTO profissional;
	
	public PagamentoDTO getPagamento() {
		return pagamento;
	}
	public void setPagamento(PagamentoDTO pagamento) {
		this.pagamento = pagamento;
	}
	public BeneficiarioPaganteDTO getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(BeneficiarioPaganteDTO beneficiario) {
		this.beneficiario = beneficiario;
	}
	public ProfissionalDTO getProfissional() {
		return profissional;
	}
	public void setProfissional(ProfissionalDTO profissional) {
		this.profissional = profissional;
	}
	
}
