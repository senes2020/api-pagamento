package com.pagamento.senes.servico;

import com.pagamento.senes.dto.RequisicaoPagamentoDTO;
import com.pagamento.senes.dto.RespostaPagamentoDTO;
import com.pagamento.senes.entity.Pagamento;

public interface PagamentoService {
	
	public RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO);

	public Pagamento buscarPagamento(Long idPagamento);
	
	public String esconderCPF(String cpf);
	
	public boolean removerPagamento(Long idPagamento);

}