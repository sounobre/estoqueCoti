package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario extends Pessoa{
	
	@Column
	private String cargo;
	@Column
	private String salario;
	@Column
	private String setor;
	@Column
	private String perfil;
	@Column
	private String identidade;
	@Column
	private String login;
	@Column
	private String senha;
	public Funcionario(Integer id, String nome, String telefone, String endereco, String numeroDoEndereco, String cep,
			String bairro, String cidade, String estado, String email, String cargo, String salario, String setor,
			String perfil, String identidade, String login, String senha) {
		super(id, nome, telefone, endereco, numeroDoEndereco, cep, bairro, cidade, estado, email);
		this.cargo = cargo;
		this.salario = salario;
		this.setor = setor;
		this.perfil = perfil;
		this.identidade = identidade;
		this.login = login;
		this.senha = senha;
	}
	public Funcionario() {
		super();
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		
		return super.toString() + "Funcionario [cargo=" + cargo + ", salario=" + salario + ", setor=" + setor + ", perfil=" + perfil
				+ ", identidade=" + identidade + ", login=" + login + ", senha=" + senha + "]";
	}
	
	
	
	
}
	