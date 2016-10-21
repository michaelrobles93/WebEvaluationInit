package br.com.webevaluationinit.model;

public enum Genero {

	MASCULINO("Masculino"), FEMININO("Feminino"), INDEFINIDO("Indefinido");

	private String descricao;
	
	Genero(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
