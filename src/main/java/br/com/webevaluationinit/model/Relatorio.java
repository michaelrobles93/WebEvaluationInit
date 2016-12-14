package br.com.webevaluationinit.model;

import java.util.List;

public class Relatorio {
	private Empresa empresa;
	private List<Educacao> lstEducacao; 
	private List<Habilidade> lstHabilidade;
	private List<Funcao> lstFuncao;
	private List<Genero> lstGenero;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Educacao> getLstEducacao() {
		return lstEducacao;
	}
	public void setLstEducacao(List<Educacao> lstEducacao) {
		this.lstEducacao = lstEducacao;
	}
	public List<Habilidade> getLstHabilidade() {
		return lstHabilidade;
	}
	public void setLstHabilidade(List<Habilidade> lstHabilidade) {
		this.lstHabilidade = lstHabilidade;
	}
	public List<Funcao> getLstFuncao() {
		return lstFuncao;
	}
	public void setLstFuncao(List<Funcao> lstFuncao) {
		this.lstFuncao = lstFuncao;
	}
	public List<Genero> getLstGenero() {
		return lstGenero;
	}
	public void setLstGenero(List<Genero> lstGenero) {
		this.lstGenero = lstGenero;
	}
	
}
