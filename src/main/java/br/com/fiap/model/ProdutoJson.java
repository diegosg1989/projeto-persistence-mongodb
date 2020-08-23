package br.com.fiap.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProdutoJson {

	@JsonProperty("codigo")
	@NotBlank(message = "Código é obrigatório")
	private String codigo;
	
	@JsonProperty("descricao")
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	
	@JsonProperty("preco")
	@NotBlank(message = "Preço é obrigatório")
	private String preco;
	
	@JsonProperty("quantidade")
	@NotBlank(message = "Quantidade é obrigatório")
	private String quantidade;
}