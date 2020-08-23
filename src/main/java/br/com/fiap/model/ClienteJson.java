package br.com.fiap.model;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ClienteJson {

	@JsonProperty("nome")
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@JsonProperty("cpf")
	@NotNull
	@NotBlank(message = "CPF é obrigatório")
	private String cpf;
	
	@JsonProperty("endereco")
	@NotEmpty(message = "Pelo menos um endereço é obrigatório")
	private Set<EnderecoJson> endereco;

}