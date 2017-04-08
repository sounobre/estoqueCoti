package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
public class MovimentacaoEstoque {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String nome;
	@Column
	private String codigo;
	@Column
	private String categoria;
	@Column
	private String local;
	@Column
	private String qtdEntrada;
	@Column
	private String qtdEstoque;
	@Column
	private String qtdMin;
	@Column
	private String qtdMax;
	
	//controle
	@Column
	private String loginMov;
	@Column
	private String tipo; //entrada ou saída
	@Column
	private Date data;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getQtdEntrada() {
		return qtdEntrada;
	}
	public void setQtdEntrada(String qtdEntrada) {
		this.qtdEntrada = qtdEntrada;
	}
	public String getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(String qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public String getQtdMin() {
		return qtdMin;
	}
	public void setQtdMin(String qtdMin) {
		this.qtdMin = qtdMin;
	}
	public String getQtdMax() {
		return qtdMax;
	}
	public void setQtdMax(String qtdMax) {
		this.qtdMax = qtdMax;
	}
	public String getLoginMov() {
		return loginMov;
	}
	public void setLoginMov(String loginMov) {
		this.loginMov = loginMov;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public MovimentacaoEstoque(Integer id, String nome, String codigo, String categoria, String local,
			String qtdEntrada, String qtdEstoque, String qtdMin, String qtdMax, String loginMov, String tipo,
			Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.local = local;
		this.qtdEntrada = qtdEntrada;
		this.qtdEstoque = qtdEstoque;
		this.qtdMin = qtdMin;
		this.qtdMax = qtdMax;
		this.loginMov = loginMov;
		this.tipo = tipo;
		this.data = data;
	}
	public MovimentacaoEstoque() {
		super();
	}
	

	
	
	
}
