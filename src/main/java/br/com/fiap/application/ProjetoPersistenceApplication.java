package br.com.fiap.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages={"br.com.fiap.repository"})
@EntityScan(basePackages="br.com.fiap.entity")
@ComponentScan(basePackages={"br.com.fiap.service"})
public class ProjetoPersistenceApplication{	
//	public class ProjetoPersistenceApplication  implements CommandLineRunner {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPersistenceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		
//		/**
//		 * Salvando endereço
//		 */
//		Endereco endereco1 = new Endereco("Rua 1", "Bairro 1", "numero 1", "Cidade 1", "Estado 1", "CEP 1", "Pais 1");
//		Endereco endereco2 = new Endereco("Rua 2", "Bairro 2", "numero 2", "Cidade 2", "Estado 2", "CEP 2", "Pais 2");
//		
//		Set<Endereco> enderecos = new HashSet<>();
//		enderecos.add(endereco1);
//		enderecos.add(endereco2);
//		
//		/**
//		 * Salvando cliente
//		 */
//		Cliente cliente = new Cliente("CPF 1", "Nome 1", enderecos);
//		clienteRepository.save(cliente);
//		
//		/**
//		 * Salvando os produtos
//		 */
//		Produto produto1 = new Produto("Codigo 1", "Produto 1", "5", "120.00");
//		Produto produto2 = new Produto("Codigo 2", "Produto 2", "10", "20.00");
//		Produto produto3 = new Produto("Codigo 3", "Produto 3", "50", "5.00");
//		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
//		
//		Set<Produto> produtos = new HashSet<>();
//		produtos.add(produto1);
//		produtos.add(produto2);
//		produtos.add(produto3);
//		
//		/**
//		 * Salvando os pedidos
//		 */
//		Pedido pedido1 = new Pedido("Pedido 1", "Codigo 12", produtos, cliente);
//		pedidoRepository.saveAll(Arrays.asList(pedido1));
//		
//		Set<Pedido> pedidos = new HashSet<>();
//		pedidos.add(pedido1);
//
//	}
}
