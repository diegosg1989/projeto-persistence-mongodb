package br.com.fiap.model;

import java.util.List;

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
}