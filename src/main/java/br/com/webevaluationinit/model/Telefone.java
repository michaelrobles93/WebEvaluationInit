package br.com.webevaluationinit.model;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {

	private TipoTelefone tipo;
	private String numero;
	
	public TipoTelefone getTipo() {
		return tipo;
	}
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
