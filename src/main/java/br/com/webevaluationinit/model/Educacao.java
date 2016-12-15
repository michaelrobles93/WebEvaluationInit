package br.com.webevaluationinit.model;

public enum Educacao {
	
	NAO_ALFABETIZADO("Não alfabetizado", 0),
	ENSINO_BASICO("Ensino básico", 1),
	ENSINO_FUNDAMENTAL("Ensino fundamental", 2),
	ENSINO_MEDIO("Ensino médio", 3),
	CURSO_TECNICO("Curso técnico", 4),
	ENSINO_SUPERIOR_INCOMPLETO("Ensino superior incompleto", 5),
	ENSINO_SUPERIOR_COMPLETO("Ensino superior completo", 6),
	POS_GRADUACAO("Pós-graduação", 7),
	MESTRADO("Mestrado", 8),
	DOUTORADO("Doutorado", 9),
	POS_DOUTORADO("Pós-doutorado", 10);

	private String descricao;
	private int value;
	
	Educacao(String descricao, int value) {
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
