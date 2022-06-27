package br.com.corp.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedido_produto")
public class ItemPedido {

	@Id
	@Column(name = "num_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numSeq;

	@Column(name = "preco_unit")
	private Double precoUnitario;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco_total")
	private Double precoTotal;
	
	@ManyToOne
	@JoinColumn(name="num_pedido")
	@JsonIgnoreProperties("itens")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name="cod_produto")
	private Produto produto;
	

	public Integer getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(Integer numSeq) {
		this.numSeq = numSeq;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
