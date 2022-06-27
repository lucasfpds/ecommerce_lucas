package br.com.corp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.corp.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository <Usuario, Integer>{
	public Usuario findByUsernameOrEmail(String username, String email);
}
