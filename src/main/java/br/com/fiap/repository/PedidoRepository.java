package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

	@Query(value = "{ 'codigo': ?0 }")
	public Pedido findByCodigo(@Param("codigo") String codigo);
	
	@Query(value = "{ 'codigo': ?0 }")
	public List<Pedido> findOrderByCode(@Param("codigo") String codigo);	
	
	@Query(value = "{ 'cliente': ?0 }")
	public List<Pedido> findAllOrdersOfACostumer(@Param("cliente") Cliente idcliente);
	
}