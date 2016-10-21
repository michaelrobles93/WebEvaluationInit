package br.com.webevaluationinit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="{empresa.nomefantasia.nulo)")
	@NotEmpty
	@Column(nullable=false, name="nome_fantasia")
	private String nomeFantasia;
	
	@NotNull(message="{empresa.razaosocial.nulo)")
	@NotEmpty
	@Column(nullable=false, name="razao_social")
	private String razaoSocial;
	
	@NotNull(message="{empresa.cnpj.nulo)")
	@NotEmpty
	@Column(nullable=false, unique=true)
	private String cnpj;
	
	@NotNull(message="{empresa.inscricaoestadual.nulo)")
	@NotEmpty
	@Column(nullable=false, unique=true, name="inscricao_estadual")
	private String inscricaoEstadual;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
	private List<Admissao> admissaoColaboradores;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<>(0);
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public List<Admissao> getAdmissaoColaboradores() {
		return admissaoColaboradores;
	}
	public void setAdmissaoColaboradores(List<Admissao> admissaoColaboradores) {
		this.admissaoColaboradores = admissaoColaboradores;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}