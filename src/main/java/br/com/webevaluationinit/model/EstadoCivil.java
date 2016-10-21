package br.com.webevaluationinit.model;

public enum EstadoCivil {

	SOLTEIRO("Solteiro"), 
	CASADO("Casado"),
	DIVORCIADO("Divorciado"), 
	VIUVO("Viuvo");
	
	private String descricao;
	
	EstadoCivil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
