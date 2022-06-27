package br.com.corp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.corp.ecommerce.dao.PedidoDAO;
import br.com.corp.ecommerce.model.ItemPedido;
import br.com.corp.ecommerce.model.Pedido;

@Component
@Primary
public class PedidoServiceDesconto implements IPedidoService {

	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido adicionarPedido(Pedido novo) {
		System.out.println("nova logica do pedido para criar com desconto");
		//Acima de 1000R$ aplico 10% de desconto
		for(ItemPedido item:novo.getItens()) {
			item.setPedido(novo);
		}
		
		if(novo.getValorBruto() >= 1000.00) {
			double desconto = novo.getValorBruto() * 0.1;
			novo.setDesconto(desconto);
			novo.setValorTotal(novo.getValorBruto()-desconto);
			
		}
		Pedido p = dao.save(novo);
		return p;
	}

	@Override
	public boolean removerPedido( Integer id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	

}
