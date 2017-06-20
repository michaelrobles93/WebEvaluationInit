package br.com.webevaluationinit.dao;

import java.util.List;

import br.com.webevaluationinit.model.Habilidade;

public interface HabilidadeDAO extends GenericDAO<Habilidade, Long>{
	public List<Habilidade> procurarTudo();
}
