package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	@Column
	private Integer id;
	@Column
	private String nome;
	@Column
	private String telefone;
	@Column
	private String endereco;
	
	private String numeroDoEndereco;
	@Column
	private String cep;
	@Column
	private String bairro;
	@Column 
	private String cidade;
	@Column
	private String estado;
	@Column
	private String email;
	public Pessoa(Integer id, String nome, String telefone, String endereco, String numeroDoEndereco, String cep,
			String bairro, String cidade, String estado, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numeroDoEndereco = numeroDoEndereco;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
	}
	public Pessoa() {
		super();
	}
	
	
	
	
	
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroDoEndereco() {
		return numeroDoEndereco;
	}
	public void setNumeroDoEndereco(String numeroDoEndereco) {
		this.numeroDoEndereco = numeroDoEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", numeroDoEndereco=" + numeroDoEndereco + ", cep=" + cep + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", email=" + email + "]";
	}
	
	
	
}
	
	
