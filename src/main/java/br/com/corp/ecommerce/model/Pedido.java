package br.com.corp.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="Pedido") 
public class Pedido {

	@Id
	@Column(name="numero", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer numero;

	@Column(name="data", nullable = true)
	private LocalDate data;

	@Column(name="valor_bruto", nullable = true)
	private Double valorBruto;

	@Column(name="desconto", nullable = true)
	private Double desconto;

	@Column(name="valor_total", nullable = true)
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "num_cliente")
	@JsonIgnoreProperties("listaPedidos")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens;
	
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(Double valor_bruto) {
		this.valorBruto = valor_bruto;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valor_total) {
		this.valorTotal = valor_total;
	}

	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
