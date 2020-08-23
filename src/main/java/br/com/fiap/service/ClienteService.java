package br.com.fiap.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.model.ClienteJson;
import br.com.fiap.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@Valid @RequestBody Map<String, Object> payload) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			ClienteJson clienteJson = mapper.convertValue(payload, ClienteJson.class);
			
			//verifica se ja tem um cliente para o cpf
			if(clienteRepository.findByCpf(clienteJson.getCpf()) != null) {
				String body = "{\"Mensagem\":\"Já existe um cliente com o CPF\"}";
				return new ResponseEntity<>(body, headers, HttpStatus.ALREADY_REPORTED);
			}
			
			Set<Endereco> enderecos = clienteJson.getEndereco().stream().map(endereco -> {
				return new Endereco(endereco.getRua(), 
						endereco.getBairro(), 
						endereco.getNumero(), 
						endereco.getCidade(),
						endereco.getEstado(), 
						endereco.getCep(), 
						endereco.getPais());
			}).collect(Collectors.toSet());
			
			Cliente cliente = new Cliente(clienteJson.getCpf(), clienteJson.getNome(), enderecos);
			clienteRepository.save(cliente);

			String body = "{\"Mensagem\":\"Cliente adicionado com sucesso\"}";
			return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			String body = "{\"Mensagem\":\"Ocorreu um erro\", \"Execeção\":" + e.getMessage() + "}";
			return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Cliente> getAllUsers() {
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findByName(@PathVariable String nome) {
		return clienteRepository.findByName(nome);
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
	@ResponseBody
	public Cliente findByDocument(@PathVariable String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

}