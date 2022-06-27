package br.com.corp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.corp.ecommerce.dto.UsuarioLoginDTO;
import br.com.corp.ecommerce.security.EcommerceCrypto;
import br.com.corp.ecommerce.security.Token;
import br.com.corp.ecommerce.services.IUsuarioService;

@RestController
public class LoginController {
		
//	@GetMapping("/testelogin")
//	public ResponseEntity<Token> fazerLoginFake(){
//		Usuario u = new Usuario();
//		u.setUsername("lucas");
//		u.setEmail("lucas@email.com");
//		u.setNomeCompleto("lucas fernandes");
//		Token t = new Token(TokenUtil.createToken(u));
//		return ResponseEntity.ok(t);
//	}
	
//	@Autowired
//	private IUsuarioService service;
//
//	
//	@GetMapping("/testelogin")
//	public ResponseEntity<Token> fazerLoginFake(){
//		Usuario u = new Usuario();
//		u.setUsername("lucas");
//		u.setEmail("lucas@email.com");
//		u.setNomeCompleto("lucas fernandes");
//		Token t = new Token(TokenUtil.createToken(u));
//		return ResponseEntity.ok(t);
//	}
	
	@Autowired
	private IUsuarioService service;

	@PostMapping("/login")
	public ResponseEntity<Token> realizarLogin(@RequestBody UsuarioLoginDTO dadosLogin ){
		Token token = service.gerarTokenDeUsuarioLogado(dadosLogin);
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(401).build();
	}

}
