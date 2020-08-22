package br.com.fiap.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document("cliente")
public class Cliente {

	@Id
	private String clienteId;

	@Field(name = "CPF")
	@Indexed(unique = true)
	@NonNull
	private String cpf;

	@Field(name = "NOME")
	private String nome;
	
	private Set<Endereco> endereco = new HashSet<>();
	
	public Cliente(String cpf, String nome, Set<Endereco> endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}
}