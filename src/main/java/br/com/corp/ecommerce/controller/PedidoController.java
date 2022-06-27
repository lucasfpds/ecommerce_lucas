package br.com.corp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.corp.ecommerce.dto.Faturamento;
import br.com.corp.ecommerce.model.Pedido;
import br.com.corp.ecommerce.services.IPedidoService;
import br.com.corp.ecommerce.util.Mensagem;

@RestController
public class PedidoController {

	@Autowired
	private IPedidoService service;

	@PostMapping("/pedidos")
		public ResponseEntity<?> inserirNovo(@RequestBody Pedido novo){
			Pedido resultado = service.adicionarPedido(novo);
			if(resultado != null) {
				return ResponseEntity.status(201).body(resultado);
			}
			return ResponseEntity.status(400).body(new Mensagem(9876, "Dados inválidos para a estrutura pedidos"));
		}

	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<?> removerPedido(@PathVariable Integer id){

		if(service.removerPedido(id)) {
			return ResponseEntity.status(201).body(new Mensagem(1154, "Pedido removido com sucesso"));
		}
		return ResponseEntity.status(400).body(new Mensagem(9776, "Não foi possível excluir"));
	}

	
//	@Autowired
//	private PedidoDAO dao;
//	
//	@GetMapping("/pedidos")
//	public List<Pedido> recuperarTodos(){
//		return (List<Pedido>)dao.findAll();
//	}
//	
//	@GetMapping("/faturamento/{ano}")
//	public List<Faturamento> recuperarFaturamento(@PathVariable int ano){
//		return dao.recuperarFaturamentoPorAno(ano);
//	}

}
