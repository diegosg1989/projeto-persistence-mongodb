package br.com.fiap.entity;

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
@Document("produto")
public class Produto {

	@Id
	@NonNull
	private String produtoId;

	@Field(name = "CODIGO")
	@Indexed(unique=true)
	@NonNull
	private String codigo;

	@Field(name = "DESCRICAO")
	private String desc;

	@Field(name = "QUANTIDADE")
	private String quantidadeEstoque;

	@Field(name = "PRECO")
	private String preco;

	public Produto(String codigo, String desc, String quantidadeEstoque, String preco) {
		this.codigo = codigo;
		this.desc = desc;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
	}
}
