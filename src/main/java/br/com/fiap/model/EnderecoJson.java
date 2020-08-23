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
public class EnderecoJson {

	@JsonProperty("rua")
	@NotBlank(message = "Rua é obrigatório")
	private String rua;
	
	@JsonProperty("bairro")
	@NotBlank(message = "Bairro é obrigatório")
	private String bairro;

	@JsonProperty("numero")
	@NotBlank(message = "Número é obrigatório")
	private String numero;

	@JsonProperty("cidade")
	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;

	@JsonProperty("estado")
	@NotBlank(message = "Estado é obrigatório")
	private String estado;

	@JsonProperty("cep")
	@NotBlank(message = "CEP é obrigatório")
	private String cep;

	@JsonProperty("pais")
	@NotBlank(message = "Pais é obrigatório")
	private String pais;

}