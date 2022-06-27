package br.com.corp.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.corp.ecommerce.model.Departamento;
import br.com.corp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
	// Aqui virão minhas consultas automatizadas
	// busca por palavra chave
	
	public List<Produto> findByNomeContainingOrDescricaoContaining(String pcNome, String pcDescricao);
	public List<Produto> findByOrderByNomeAsc();
	public List<Produto> findByOrderByPrecoAsc();

	public List<Produto> findByOrderByPrecoDesc();
	public List<Produto> findByDepto(Departamento d);

	@Query("SELECT new "
		     + "br.com.corp.ecommerce.model.Produto(produto.codigo,"
		     + "                                          produto.nome,"
		     + "                                          produto.descricao,"
		     + "                                          produto.preco,"
		     + "                                          produto.qtdEstoque,"
		     + "                                          produto.linkFoto,"
		     + "                                          departamento.numero,"
		     + "                                          departamento.nome,"
		     + "                                          departamento.andar) "
		     + "FROM "
		     + "Produto as produto INNER JOIN Departamento as departamento ON "
		     + "produto.depto.numero = departamento.numero")
		public List<Produto> recuperarTudaoComUmaUnicaQuery();

}
