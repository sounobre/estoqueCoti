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
	public Funcionario(Integer id, String nome, String telefone, String endereco, String numeroDoEndereco, String cep,
			String bairro, String cidade, String estado, String email, String cargo, String salario, String setor,
			String perfil, String identidade) {
		super(id, nome, telefone, endereco, numeroDoEndereco, cep, bairro, cidade, estado, email);
		this.cargo = cargo;
		this.salario = salario;
		this.setor = setor;
		this.perfil = perfil;
		this.identidade = identidade;
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
	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", salario=" + salario + ", setor=" + setor + ", perfil=" + perfil
				+ ", identidade=" + identidade + "]";
	}
	
}
	