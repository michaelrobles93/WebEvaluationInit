package br.com.webevaluationinit.model;

public enum Genero {

	MASCULINO("Masculino", 0), FEMININO("Feminino", 1), INDEFINIDO("Indefinido", 2);

	private String descricao;
	private int value;
	
	Genero(String descricao, int value) {
		this.descricao = descricao;
		this.value = value;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
