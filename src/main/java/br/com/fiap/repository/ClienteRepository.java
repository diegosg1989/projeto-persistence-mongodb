package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("select c from Cliente c where c.nome = :nome")
	public List<Cliente> findByName(@Param("nome") String nome);
	
	@Query("select c from Cliente c where c.cpf = :cpf")
	public List<Cliente> findByDocument(@Param("cpf") String cpf);
	
}