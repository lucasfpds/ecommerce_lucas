package br.com.corp.ecommerce.services;

import java.util.List;

import br.com.corp.ecommerce.dto.ClienteDTO;

public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();
	public ClienteDTO recuperarPeloId(Integer id);
}
