package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materiais {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String codigo;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private String medida;
	@Column
	private String fornecedor;
	@Column
	private Double qtdMin;
	@Column
	private Double qtdMax;
	@Column
	private Double estoque;
	@Column
	private String categoria;
	@Column
	private Double preco;
	
	
	public Materiais(Integer id, String codigo, String nome, String descricao, String medida, String fornecedor,
			Double qtdMin, Double qtdMax, Double estoque, String categoria, Double preco) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.medida = medida;
		this.fornecedor = fornecedor;
		this.qtdMin = qtdMin;
		this.qtdMax = qtdMax;
		this.estoque = estoque;
		this.categoria = categoria;
		this.preco = preco;
	}
	
	
	
	public Materiais() {
		super();
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Double getQtdMin() {
		return qtdMin;
	}
	public void setQtdMin(Double qtdMin) {
		this.qtdMin = qtdMin;
	}
	public Double getQtdMax() {
		return qtdMax;
	}
	public void setQtdMax(Double qtdMax) {
		this.qtdMax = qtdMax;
	}
	public Double getEstoque() {
		return estoque;
	}
	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}



	@Override
	public String toString() {
		return "Materiais [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao
				+ ", medida=" + medida + ", fornecedor=" + fornecedor + ", qtdMin=" + qtdMin + ", qtdMax=" + qtdMax
				+ ", estoque=" + estoque + ", categoria=" + categoria + ", preco=" + preco + "]";
	}
	
	

}
