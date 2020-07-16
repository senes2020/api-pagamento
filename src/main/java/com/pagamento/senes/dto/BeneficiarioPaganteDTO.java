package com.pagamento.senes.dto;

import com.sun.istack.NotNull;

public class BeneficiarioPaganteDTO {

	@NotNull
	private String nome;
	private String email;
	private String cpf;
	
	public BeneficiarioPaganteDTO(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public BeneficiarioPaganteDTO() {
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "BeneficiarioPaganteDTO [nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
	}

}
