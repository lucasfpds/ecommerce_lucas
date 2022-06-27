package br.com.corp.ecommerce.services;

import java.util.List;

import br.com.corp.ecommerce.dto.UsuarioLoginDTO;
import br.com.corp.ecommerce.model.Usuario;
import br.com.corp.ecommerce.security.Token;

public interface IUsuarioService {
	public Token gerarTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin);
	
	public Usuario criarUsuario(Usuario novo);
	public Usuario alterarUsuario(Usuario novo);
	public List<Usuario> recuperarTodos();
	public Usuario recuperarDetalhes(Integer id);

}