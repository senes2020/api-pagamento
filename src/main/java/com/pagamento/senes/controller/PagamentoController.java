package com.pagamento.senes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagamento.senes.dto.RequisicaoPagamentoDTO;
import com.pagamento.senes.dto.RespostaPagamentoDTO;
import com.pagamento.senes.entity.Pagamento;
import com.pagamento.senes.servico.PagamentoService;

@RestController
@RequestMapping("api/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RespostaPagamentoDTO> realizarPagamento(
			@RequestBody RequisicaoPagamentoDTO requisicaoPagamentoDTO) {
		return new ResponseEntity<RespostaPagamentoDTO>(pagamentoService.realizarPagamento(requisicaoPagamentoDTO),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pagamento> buscarPagamento(@PathVariable(value = "id") Long id) {
		Pagamento pagamento = pagamentoService.buscarPagamento(id);
		if (ObjectUtils.isEmpty(pagamento)) {
			return new ResponseEntity<Pagamento>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removerPagamento(@PathVariable(value = "id") Long idPagamento) {
		if (!pagamentoService.removerPagamento(idPagamento)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
