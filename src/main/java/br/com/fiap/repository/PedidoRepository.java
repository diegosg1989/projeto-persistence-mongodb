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

	@Query("select p from Pedido p where p.cliente = :idcliente")
	public List<Pedido> findAllOrdersOfACostumer(@Param("idcliente") Cliente idcliente);
	
	@Query("select p from Pedido p where p.codigo = :codigo")
	public List<Pedido> findOrderByCode(@Param("codigo") String codigo);
	
}