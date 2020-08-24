package br.com.fiap.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document("endereco")
public class Endereco {
	
	@Field(name = "RUA")
	private String rua;

	@Field(name = "BAIRRO")
	private String bairro;

	@Field(name = "NUMERO")
	private String numero;

	@Field(name = "CIDADE")
	private String cidade;

	@Field(name = "ESTADO")
	private String estado;

	@Field(name = "CEP")
	@NonNull
	private String cep;

	@Field(name = "PAIS")
	private String pais;

	public Endereco(String rua, String bairro, String numero, String cidade, String estado, String cep, String pais) {
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.pais = pais;
	}
}
