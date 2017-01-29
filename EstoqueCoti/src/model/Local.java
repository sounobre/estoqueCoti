package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localizacao")
public class Local {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer lId; 
	@Column
	private String lNome;
	@Column
	private String lCodigo;
	@Column
	private String ldescricao;
	@Column
	private String cNome;
	@Column
	private String cCodigo;
	@Column
	private String cDescricao;
	@Column
	private String pNome;
	@Column
	private String pCodigo;
	@Column
	private String pDescricao;
	
	public Local(Integer lId, String lNome, String lCodigo, String ldescricao, String cNome, String cCodigo,
			String cDescricao, String pNome, String pCodigo, String pDescricao) {
		super();
		this.lId = lId;
		this.lNome = lNome;
		this.lCodigo = lCodigo;
		this.ldescricao = ldescricao;
		this.cNome = cNome;
		this.cCodigo = cCodigo;
		this.cDescricao = cDescricao;
		this.pNome = pNome;
		this.pCodigo = pCodigo;
		this.pDescricao = pDescricao;
	}

	public Local() {
		super();
	}

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public String getlNome() {
		return lNome;
	}

	public void setlNome(String lNome) {
		this.lNome = lNome;
	}

	public String getlCodigo() {
		return lCodigo;
	}

	public void setlCodigo(String lCodigo) {
		this.lCodigo = lCodigo;
	}

	public String getLdescricao() {
		return ldescricao;
	}

	public void setLdescricao(String ldescricao) {
		this.ldescricao = ldescricao;
	}

	public String getcNome() {
		return cNome;
	}

	public void setcNome(String cNome) {
		this.cNome = cNome;
	}

	public String getcCodigo() {
		return cCodigo;
	}

	public void setcCodigo(String cCodigo) {
		this.cCodigo = cCodigo;
	}

	public String getcDescricao() {
		return cDescricao;
	}

	public void setcDescricao(String cDescricao) {
		this.cDescricao = cDescricao;
	}

	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public String getpCodigo() {
		return pCodigo;
	}

	public void setpCodigo(String pCodigo) {
		this.pCodigo = pCodigo;
	}

	public String getpDescricao() {
		return pDescricao;
	}

	public void setpDescricao(String pDescricao) {
		this.pDescricao = pDescricao;
	}
	
	
	
}
