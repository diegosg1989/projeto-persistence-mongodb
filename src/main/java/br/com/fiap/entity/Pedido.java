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
@Document("pedido")
public class Pedido {

	@Id
	@NonNull
	private String pedidoId;
	
	@Field(name = "DESCRICAO")
	private String descricao;

	@Field(name = "CODIGO")
	@Indexed(unique=true)
	@NonNull
	private String codigo;
	
	@Field(name = "CLIENTE")
	@NonNull
	private Cliente cliente;

	Set<Produto> produto = new HashSet<>();
	
	public Pedido(String descricao, String codigo, Set<Produto> produto, Cliente cliente) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.produto = produto;
		this.cliente = cliente;
	}
}
