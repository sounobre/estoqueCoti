package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materiais")
public class Materiais {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id_material;
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
	private Double qtd_Min;
	@Column
	private Double qtd_Max;
	@Column
	private Double estoque;
	@Column
	private Double preco;
	
	 
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Materiais(Integer id_material, String codigo, String nome, String descricao, String medida,
			String fornecedor, Double qtd_Min, Double qtd_Max, Double estoque, Double preco) {
		super();
		this.id_material = id_material;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.medida = medida;
		this.fornecedor = fornecedor;
		this.qtd_Min = qtd_Min;
		this.qtd_Max = qtd_Max;
		this.estoque = estoque;
		this.preco = preco;
	}
	public Materiais() {
		super();
	}
	public Integer getId_material() {
		return id_material;
	}
	public void setId_material(Integer id_material) {
		this.id_material = id_material;
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
	public Double getQtd_Min() {
		return qtd_Min;
	}
	public void setQtd_Min(Double qtd_Min) {
		this.qtd_Min = qtd_Min;
	}
	public Double getQtd_Max() {
		return qtd_Max;
	}
	public void setQtd_Max(Double qtd_Max) {
		this.qtd_Max = qtd_Max;
	}
	public Double getEstoque() {
		return estoque;
	}
	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Materiais [id_material=" + id_material + ", codigo=" + codigo + ", nome=" + nome + ", descricao="
				+ descricao + ", medida=" + medida + ", fornecedor=" + fornecedor + ", qtd_Min=" + qtd_Min
				+ ", qtd_Max=" + qtd_Max + ", estoque=" + estoque + ", preco=" + preco
				+ "]";
	}
	
	
	
	
}