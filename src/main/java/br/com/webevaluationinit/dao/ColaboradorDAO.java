package br.com.webevaluationinit.dao;

import java.util.List;

import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.Relatorio;

public interface ColaboradorDAO extends GenericDAO<Colaborador, Long>{
	
	List<Colaborador> procurarPorCargo(Long id);
	
	List<Colaborador> procurarPorEmpresa(Long id);
	
	List<Colaborador> procurarRelatorio(Relatorio relatorio);

}
