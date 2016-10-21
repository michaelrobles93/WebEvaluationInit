package br.com.webevaluationinit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cargo")
public class Cargo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomeCargo;
	
	@ManyToOne
	@JoinColumn(name="id_cbo")
	private Cbo cbo;
	
	@ManyToOne
	@JoinColumn(name="id_cargo_superior_direto")
	private Cargo cargoSuperiorDireto;
	
	@Column(nullable=false)
	private String missao;
	
	@ManyToOne
	@JoinColumn(name="id_funcao")
	private Funcao funcao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="cargo_competencia")
	private List<Competencia> competencias;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="cargo_habilidade")
	private List<Habilidade> habilidades;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@Column
	private String experiencia;
	
	@Column(name = "bo_experiencia", nullable=false)
	private boolean boExperiencia;
	
	@Enumerated
	private Educacao educacao;
	
	@Enumerated
	private Status status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cbo getCbo() {
		return cbo;
	}
	public void setCbo(Cbo cbo) {
		this.cbo = cbo;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public Cargo getCargoSuperiorDireto() {
		return cargoSuperiorDireto;
	}
	public void setCargoSuperiorDireto(Cargo cargoSuperiorDireto) {
		this.cargoSuperiorDireto = cargoSuperiorDireto;
	}
	public String getMissao() {
		return missao;
	}
	public void setMissao(String missao) {
		this.missao = missao;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public List<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	public boolean isBoExperiencia() {
		return boExperiencia;
	}
	public void setBoExperiencia(boolean boExperiencia) {
		this.boExperiencia = boExperiencia;
	}
	public Educacao getEducacao() {
		return educacao;
	}
	public void setEducacao(Educacao educacao) {
		this.educacao = educacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

