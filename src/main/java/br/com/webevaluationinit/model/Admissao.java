package br.com.webevaluationinit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="admissao")
public class Admissao {

	@EmbeddedId
	private AdmissaoId id;
	
	@ManyToOne
	@JoinColumn(name="id_colaborador", nullable=false, insertable=false, updatable=false)
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false, insertable=false, updatable=false)
	private Empresa empresa;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao")
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_demissao")
	private Date dataDemissao;
	
	private Boolean responsavel;
	
	public AdmissaoId getId() {
		return id;
	}
	public void setId(AdmissaoId id) {
		this.id = id;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
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
		Admissao other = (Admissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Boolean getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
}
