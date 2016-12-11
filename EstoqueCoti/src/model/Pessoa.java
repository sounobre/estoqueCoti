package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer idPessoa;
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
	public Pessoa(Integer idPessoa, String nome, String telefone, String endereco, String numeroDoEndereco, String cep,
			String bairro, String cidade, String estado, String email) {
		super();
		this.idPessoa = idPessoa;
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
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", numeroDoEndereco=" + numeroDoEndereco + ", cep=" + cep + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", email=" + email + "]";
	}
	
	
	
}
	
	
