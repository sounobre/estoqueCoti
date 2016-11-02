package model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id_categoria;
	@Column
	private String categoria;
	@Column
	private String descricao;
	
	@OneToMany(mappedBy="categoria")
	private List<Materiais> listaMateriais;
	
	public List<Materiais> getListaMateriais() {
		return listaMateriais;
	}

	public void setListaMateriais(List<Materiais> listaMateriais) {
		this.listaMateriais = listaMateriais;
	}

	public Categoria(Integer id_categoria, String categoria, String descricao) {
		super();
		this.id_categoria = id_categoria;
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public Categoria() {
		super();
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", categoria=" + categoria + ", descricao=" + descricao
				+ "]";
	}
	
	

}
