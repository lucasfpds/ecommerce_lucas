package br.com.corp.ecommerce.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.corp.ecommerce.dao.ClienteDAO;
import br.com.corp.ecommerce.dto.ClienteDTO;

@Component
public class ClienteServiceImpl implements IClienteService{
	
	private ClienteDAO dao;
	
	
	public ClienteServiceImpl(ClienteDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<ClienteDTO> recuperarTodos() {
		// TODO Auto-generated method stub
		return dao.recuperarTodos();
	}


	@Override
	public ClienteDTO recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
