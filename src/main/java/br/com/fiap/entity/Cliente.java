package br.com.fiap.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("cliente")
public class Cliente{

	@Id
	private String clienteId;

	@Field(name = "CPF")
	@Indexed(unique=true)
	@NonNull
	private String cpf;
	
	@Field(name = "NOME")
	private String nome;
	
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
	private String cep;

	@Field(name = "PAIS")
	private String pais;
	
//	private Set<Pedido> pedidos = new HashSet<>();

	public Cliente(String cpf, String nome, String rua, String bairro, String numero, String cidade, String estado,
			String cep, String pais) {
		this.cpf = cpf;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.pais = pais;
	}
	
	
	
	

}