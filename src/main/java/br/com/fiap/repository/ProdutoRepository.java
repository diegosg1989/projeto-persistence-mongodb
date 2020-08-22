package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	@Query("select p from Produto p where p.desc = :descricao")
	public List<Produto> findByName(@Param("descricao") String descricao);
		
	@Query("select p from Produto p where p.codigo = :codigo")
	public List<Produto> findByCode(@Param("codigo") String codigo);
		
	
}