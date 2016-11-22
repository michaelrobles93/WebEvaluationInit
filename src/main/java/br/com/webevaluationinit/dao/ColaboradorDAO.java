package br.com.webevaluationinit.dao;

import java.util.List;

import br.com.webevaluationinit.model.Colaborador;

public interface ColaboradorDAO extends GenericDAO<Colaborador, Long>{
	
	List<Colaborador> procurarPorCargo(Long id);
	
	List<Colaborador> procurarRelatorio(Colaborador colaborador);

}
