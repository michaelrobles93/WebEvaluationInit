package br.com.webevaluationinit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="colaborador")
public class Colaborador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="{colaborador.nome.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String nome;
	
	@NotNull(message="{colaborador.sobrenome.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String sobrenome;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "id_colaborador_superior_imediato")
	private Colaborador colaboradorSuperiorImediato;
	
	@NotNull(message="{colaborador.dataNascimento.nulo)")
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	@NotNull(message="{colaborador.email.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String email;
	
	@NotNull(message="{colaborador.genero.nulo)")
	@Enumerated
	private Genero genero;
	
	@NotNull(message="{colaborador.estadoCivil.nulo)")
	@Enumerated
	@Column(name="estado_civil")
	private EstadoCivil estadoCivil;
	
	@NotNull(message="{colaborador.rg.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String rg;
	
	@NotNull(message="{colaborador.cpf.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String cpf;
	
	@NotNull(message="{colaborador.ctps.nulo)")
	@NotEmpty
	@Column(nullable=false)
	private String ctps;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Telefone> telefones;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Endereco> enderecos;
	
	@JsonIgnore
	@NotNull (message = "{admissao.dataAdmissao.nulo)")
	@NotEmpty
	@OneToMany(fetch = FetchType.EAGER, mappedBy="colaborador")
	private List<Admissao> admissoes;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="colaborador_habilidade")
	private List<Habilidade> habilidades;
	
	@Enumerated
	private Educacao educacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Colaborador getColaboradorSuperiorImediato() {
		return colaboradorSuperiorImediato;
	}
	public void setColaboradorSuperiorImediato(Colaborador colaboradorSuperiorImediato) {
		this.colaboradorSuperiorImediato = colaboradorSuperiorImediato;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Admissao> getAdmissoes() {
		return admissoes;
	}
	public void setAdmissoes(List<Admissao> admissoes) {
		this.admissoes = admissoes;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
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
		Colaborador other = (Colaborador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
