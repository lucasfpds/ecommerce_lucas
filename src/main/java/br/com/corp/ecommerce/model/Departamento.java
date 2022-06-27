package br.com.corp.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import br.com.corp.ecommerce.model.Produto;
@Entity // A anotação @Entity indica que a classer é mapeada para uma tabela(armazenar)
@Table(name="departamento") // aqui eu especifico o nome da tabela no banco
public class Departamento {
	
	@Id
	@Column(name="numero", nullable = false) // mapeio o atributo "numero" para a especificação da coluna "numero" na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indico que o valor é gerado e genreciado pelo BD( e o identity torna
	private Integer numero;

	@Column(name="nome", length = 50, nullable = false)
	private String nome;

	@Column(name="andar", nullable = true)
	private Integer andar;
	
	@OneToMany(mappedBy = "depto")
	@JsonIgnoreProperties("depto")
	private List<Produto> listaProdutos;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAndar() {
		return andar;
	}
	public void setAndar(Integer andar) {
		this.andar = andar;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
}


