package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	@Query(value = "{ 'codigo': ?0 }")
	public Produto findByCodigo(@Param("codigo") String codigo);
	
	@Query(value = "{ 'descricao': ?0 }", count = true)
	public Produto findByName(@Param("descricao") String descricao);
	
}