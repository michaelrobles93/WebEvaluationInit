package br.com.webevaluationinit.model;

public enum Status {

	ATIVO("Ativo"),
	INATIVO("Inativo");
	
private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
