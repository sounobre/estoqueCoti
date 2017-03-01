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
	

	
	
	
}
