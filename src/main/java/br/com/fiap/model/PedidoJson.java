package br.com.fiap.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoJson {
	
	@JsonProperty("codigo")
	@NotBlank(message = "Código é obrigatório")
	private String codigo;
	
	@JsonProperty("descricao")
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	
	@JsonProperty("cpf")
	@NotBlank(message = "CPF é obrigatório")
	private String cpf;
	
	@JsonProperty("produtos")
	@NotBlank(message = "Produtos são obrigatórios")
	List<ProdutoJson> produtos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<ProdutoJson> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoJson> produtos) {
		this.produtos = produtos;
	}

}