package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

	@Query("select e from Endereco e where e.cep = :cep")
	public List<Cliente> findByCep(@Param("cep") String cep);
}
