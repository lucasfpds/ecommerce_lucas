package br.com.corp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.corp.ecommerce.dao.PedidoDAO;
import br.com.corp.ecommerce.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoDAO dao;
	
	@Override
	public Pedido adicionarPedido(Pedido novo) {
		Pedido resultado = dao.save(novo);
		return resultado;
	}
	
	@Override
	public boolean removerPedido(Integer id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
