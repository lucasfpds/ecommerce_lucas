package br.com.corp.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.corp.ecommerce.dto.Faturamento;
import br.com.corp.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

	@Query("SELECT new"
		 + " br.com.corp.ecommerce.dto.Faturamento( month(pedido.data) , sum(pedido.valorTotal)) "
		 + " FROM "
		 + " Pedido as pedido "
		 + " WHERE year(pedido.data) = :ano"
		 + " GROUP BY month(pedido.data) ")
	public List<Faturamento> recuperarFaturamentoPorAno(@Param("ano") int ano);
	
	// agora eu quero uma query customizadaaaaaaça (onde EU escrevo o SQL)
	// JPQL - JPa Query Language
	// HQL  - Hibernate Query Language
	// devo pensar em que? Tabelas ou Classes????
	
//	@Query(   "SELECT new "
//			+ " br.com.corp.ecommerce.dto.Faturamento( month(pedido.data) , sum(pedido.valorTotal) ) "
//			+ " FROM "
//			+ " Pedido as pedido "
//			+ " GROUP BY month(pedido.data) ")
//	public List<Faturamento> recuperarFaturamentoPorAno();
	

}
