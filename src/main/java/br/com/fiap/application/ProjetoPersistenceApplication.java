package br.com.fiap.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages={"br.com.fiap.repository"})
@EntityScan(basePackages="br.com.fiap.entity")
@ComponentScan(basePackages={"br.com.fiap.service"})
public class ProjetoPersistenceApplication  implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPersistenceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente = new Cliente("123456789", "teste", null, null, null, null, null, null, null);
		clienteRepository.save(cliente);
		
	}
}
