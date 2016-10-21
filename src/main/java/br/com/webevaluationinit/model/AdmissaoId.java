package br.com.webevaluationinit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdmissaoId implements Serializable{

	private static final long serialVersionUID = -5132101021058932173L;

	@Column(name="id_colaborador")
	private Long idColaborador;
	
	@Column(name="id_empresa")
	private Long idEmpresa;
	
	public Long getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idColaborador == null) ? 0 : idColaborador.hashCode());
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
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
		AdmissaoId other = (AdmissaoId) obj;
		if (idColaborador == null) {
			if (other.idColaborador != null)
				return false;
		} else if (!idColaborador.equals(other.idColaborador))
			return false;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		return true;
	}
	
	
	
}
