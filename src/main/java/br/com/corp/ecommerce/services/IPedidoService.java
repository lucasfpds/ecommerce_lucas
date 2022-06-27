package br.com.corp.ecommerce.services;

import br.com.corp.ecommerce.model.Pedido;

public interface IPedidoService {
	
	public Pedido adicionarPedido(Pedido novo);

	boolean removerPedido(Integer id);
	
	
}
