package br.com.fiap.service;

import java.util.ArrayList;
import java.util.HashSet;
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
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.model.PedidoJson;
import br.com.fiap.model.ProdutoJson;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;

@Controller
@RequestMapping(path = "/pedido")
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@Valid @RequestBody Map<String, Object> payload) {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		
		try {

			ObjectMapper mapper = new ObjectMapper();
			PedidoJson pedidoJson = mapper.convertValue(payload, PedidoJson.class);
			
			Cliente cliente = clienteRepository.findByCpf(pedidoJson.getCpf());			
			if(cliente == null) {
				String body = "{\"Mensagem\":\"Cliente não encontrado na base de dados\"}";
				return new ResponseEntity<>(body, headers, HttpStatus.ALREADY_REPORTED);
			}
			
			Set<Produto> produtos = new HashSet<Produto>();			
			for (ProdutoJson produtoJson : pedidoJson.getProdutos()) {
				
				Produto produto = produtoRepository.findByCodigo(produtoJson.getCodigo());
				
				if(produto == null) {
					String body = "{\"Mensagem\":\"Produto "+produtoJson.getCodigo()+" nao existe na base de dados\"}";
					return new ResponseEntity<>(body, headers, HttpStatus.ALREADY_REPORTED);
				}
				produtos.add(produto);
			}
			
			Pedido pedidoBase = pedidoRepository.findByCodigo(pedidoJson.getCodigo());
			if(pedidoBase != null) {
				String body = "{\"Mensagem\":\"Ja existe um pedido para o codigo desejado\"}";
				return new ResponseEntity<>(body, headers, HttpStatus.ALREADY_REPORTED);
			}			
			
			Pedido pedido = new Pedido(pedidoJson.getDescricao(), pedidoJson.getCodigo(), produtos, cliente);
			pedidoRepository.save(pedido);

			String body = "{\"Mensagem\":\"Pedido adicionado com sucesso\"}";
			return new ResponseEntity<>(body, headers, HttpStatus.CREATED);

		} catch (Exception e) {
			String body = "{\"Mensagem\":\"Ocorreu um erro\", \"Execeção\":" + e.getMessage() + "}";
			return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Pedido> getAllUsers() {
		return pedidoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(path = "/codigo/{codigo}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findOrderByCode(@PathVariable String codigo) {
		
		Pedido pedido = pedidoRepository.findByCodigo(codigo);
		
		PedidoJson pedidoJson = new PedidoJson();		
		pedidoJson.setCodigo(pedido.getCodigo());
		pedidoJson.setDescricao(pedido.getDescricao());
		pedidoJson.setCpf(pedido.getCliente().getCpf());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String body = "{"
							+ "\"codigo\":\"" + pedidoJson.getCodigo() + "\","
							+ "\"descricao\":\"" + pedidoJson.getDescricao() + "\","
							+ "\"cpf\":\"" + pedidoJson.getCpf() + "\""
					+ "}";

		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(path = "/cliente/{cpf}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PedidoJson>> findAllOrdersOfACostumer(@PathVariable String cpf) {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		
		Cliente cliente = clienteRepository.findByCpf(cpf);
		
		List<Pedido> pedidos = pedidoRepository.findAllOrdersOfACostumer(cliente);
		
		List<PedidoJson> pedidosJson = new ArrayList<>();
		
	    for (Pedido pedido : pedidos) {
	    	
	        PedidoJson pedidoJson = new PedidoJson();
	        pedidoJson.setCodigo(pedido.getCodigo());
	        pedidoJson.setDescricao(pedido.getDescricao());
	        pedidoJson.setCpf(pedido.getCliente().getCpf());
	        
	        List<ProdutoJson> produtosJson = pedido.getProduto().stream().map(produto -> {
	        	ProdutoJson produtoJson = new ProdutoJson();
	        	produtoJson.setCodigo(produto.getCodigo());
	        	produtoJson.setDescricao(produto.getDescricao());
	        	produtoJson.setPreco(produto.getPreco());
	        	produtoJson.setQuantidade(produto.getQuantidadeEstoque());
	        	return produtoJson;
	        }).collect(Collectors.toList());
	        
	        pedidoJson.setProdutos(produtosJson);
	        pedidosJson.add(pedidoJson);
	    }
		
		return new ResponseEntity<>(pedidosJson, headers, HttpStatus.OK);
	}
}