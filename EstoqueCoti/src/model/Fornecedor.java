package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;




@Entity
@Table(name ="fornecedor")
public class Fornecedor extends Pessoa{
	
	
	@Column
	private Integer codigo;
	@Column
	private String pessoaContato;
	@Column
	private String cnpj;
	@Column
	private Date inicioAtividades;
	public Fornecedor(Integer id, String nome, String telefone, String endereco, String numeroDoEndereco,
			String cep, String bairro, String cidade, String estado, String email, Integer codigo, String pessoaContato,
			String cnpj, Date inicioAtividades) {
		super(id, nome, telefone, endereco, numeroDoEndereco, cep, bairro, cidade, estado, email);
		this.codigo = codigo;
		this.pessoaContato = pessoaContato;
		this.cnpj = cnpj;
		this.inicioAtividades = inicioAtividades;
	}
	public Fornecedor() {
		super();
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getPessoaContato() {
		return pessoaContato;
	}
	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getInicioAtividades() {
		return inicioAtividades;
	}
	public void setInicioAtividades(Date inicioAtividades) {
		this.inicioAtividades = inicioAtividades;
	}
	
	
	
	
	
	
	
	
	
	
	

}
