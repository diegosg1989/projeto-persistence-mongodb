package br.com.fiap.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteJson {

	@JsonProperty("nome")
	@NotNull
	private String nome;
	
	@JsonProperty("cpf")
	@NotNull
	private String cpf;
	
	@JsonProperty("endereco")
	private EnderecoJson endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoJson getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoJson endereco) {
		this.endereco = endereco;
	}
	
}