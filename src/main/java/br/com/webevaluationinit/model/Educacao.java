package br.com.webevaluationinit.model;

public enum Educacao {
	
	NAO_ALFABETIZADO("Não alfabetizado"),
	ENSINO_BASICO("Ensino básico"),
	ENSINO_FUNDAMENTAL("Ensino fundamental"),
	ENSINO_MEDIO("Ensino médio"),
	CURSO_TECNICO("Curso técnico"),
	ENSINO_SUPERIOR_INCOMPLETO("Ensino superior incompleto"),
	ENSINO_SUPERIOR_COMPLETO("Ensino superior completo"),
	POS_GRADUACAO("Pós-graduação"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	POS_DOUTORADO("Pós-doutorado");

	private String descricao;
	
	Educacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
