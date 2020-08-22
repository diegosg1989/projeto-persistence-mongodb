package br.com.fiap.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
public class Pedido {

	@Id
	@NonNull
	private String pedidoId;
	
	@Field(name = "DESCRICAO")
	private String desc;

	@Field(name = "CODIGO")
	@Indexed(unique=true)
	@NonNull
	private String codigo;

	Set<Produto> produto = new HashSet<>();
	
	public Pedido(String desc, String codigo, Set<Produto> produto) {
		this.desc = desc;
		this.codigo = codigo;
		this.produto = produto;
	}
}
