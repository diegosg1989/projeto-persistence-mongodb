package br.com.fiap.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}