package br.com.corp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.corp.ecommerce.model.Usuario;
import br.com.corp.ecommerce.services.IUsuarioService;
import br.com.corp.ecommerce.util.Mensagem;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioService service;

	@PostMapping
	public ResponseEntity<?> cadastrarNovoUsuario(@RequestBody Usuario novo) {
		Usuario res = service.criarUsuario(novo);

		if (res != null) {
			// ResponseEntity.created(new URI("/usuarios/"+res.getIdUsuario()));
			return ResponseEntity.ok(res);
		}

		return ResponseEntity.badRequest().body(new Mensagem(04654, "Dados Inválidos"));
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> alterarDados(@RequestBody Usuario dados, @PathVariable Integer id) {
		dados.setIdUsuario(id);
		Usuario res = service.alterarUsuario(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}

		return ResponseEntity.badRequest().body(new Mensagem(04654, "Dados Inválidos"));
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> recuperarTodos() {
		return ResponseEntity.ok(service.recuperarTodos());
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> recuperarDetalhesdeUsuario(@PathVariable Integer id) {

		try {
			System.out.println(id);
			Usuario res = service.recuperarDetalhes(id);
			System.out.println(res);
			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
