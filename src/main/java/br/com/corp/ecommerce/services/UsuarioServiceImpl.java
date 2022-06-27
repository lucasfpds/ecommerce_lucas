package br.com.corp.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.corp.ecommerce.dao.UsuarioDAO;
import br.com.corp.ecommerce.dto.UsuarioLoginDTO;
import br.com.corp.ecommerce.model.Usuario;
import br.com.corp.ecommerce.security.EcommerceCrypto;
import br.com.corp.ecommerce.security.Token;
import br.com.corp.ecommerce.security.TokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Token gerarTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin) {
		// TODO Auto-generated method stub
		Usuario user = dao.findByUsernameOrEmail(dadosLogin.getUsername(), dadosLogin.getEmail());
		try {
			System.out.println("DEBUG = " + EcommerceCrypto.encrypt(dadosLogin.getSenha()));

			if (user != null) { // usuario existe no banco

				// do ponto que estamos para uma senha criptografada, basta apenas
				// criptografarmos
				// a senha recebida e comparar os valores criptografados
				String senhaLogin = EcommerceCrypto.encrypt(dadosLogin.getSenha());
				
				System.out.println(senhaLogin);
				System.out.println(user.getSenha());
				
				if (user.getSenha().equals(senhaLogin)) {
					return new Token(TokenUtil.createToken(user));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public Usuario criarUsuario(Usuario novo) {
		// TODO Auto-generated method stub
		try {
			if (novo.getSenha() != null) {
				novo.setSenha(EcommerceCrypto.encrypt(novo.getSenha()));
				dao.save(novo);
				return novo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario alterarUsuario(Usuario dados) {
		// TODO Auto-generated method stub
		try {
			if (dados.getSenha() != null) {
				dados.setSenha(EcommerceCrypto.encrypt(dados.getSenha()));
				dao.save(dados);
				return dados;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Usuario>)dao.findAll();
	}

	@Override
	public Usuario recuperarDetalhes(Integer id) {
		// TODO Auto-generated method stub
		if(id <= 0) throw new RuntimeException("Id inválido para consulta");
		return dao.findById(id).orElse(null);
	}

}