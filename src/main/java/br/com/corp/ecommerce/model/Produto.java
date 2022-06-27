package br.com.corp.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="Produto") 
public class Produto {
	

	@Id
	@Column(name="codigo", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer codigo;

	@Column(name="nome", length = 50, nullable = false)
	private String nome;

	@Column(name="descricao", columnDefinition = "TEXT", nullable = true)
	private String descricao;

	@Column(name="preco", nullable = true)
	private Double preco;

	@Column(name="qtd_estoque", nullable = true)
	private Integer qtdEstoque;

	@Column(name="link_foto", length = 255, nullable = true)
	private String linkFoto;

	@ManyToOne // esta anotação indica que há uma relação n:1 com Departamento
	@JoinColumn(name = "num_depto")// como o nome da coluna que é FK é diferente do nome da PK de Departamento, então precisamos especificar.
	@JsonIgnoreProperties("listaProdutos")
	private Departamento depto;
	
	
	public Produto() {
		// nao faz nadica de nada!!!
	}

	public Produto(Integer codigo, String nome, String descricao, Double preco, Integer qtdEstoque, String linkFoto,
			       Integer numeroDepto, String nomeDepto, Integer andarDepto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.linkFoto = linkFoto;
		this.depto = new Departamento();
		this.depto.setNumero(numeroDepto);
		this.depto.setNome(nomeDepto);
		this.depto.setAndar(andarDepto);
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQtd_estoque() {
		return qtdEstoque;
	}
	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtdEstoque = qtd_estoque;
	}
	public String getLink_foto() {
		return linkFoto;
	}
	public void setLink_foto(String link_foto) {
		this.linkFoto = link_foto;
	}

	public Departamento getDepto() {
		return depto;
	}
	public void setDepto(Departamento depto) {
		this.depto = depto;
	}
	
	
	
	
}
