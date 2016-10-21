package br.com.webevaluationinit.dao;

import java.util.List;

import br.com.webevaluationinit.model.Cargo;

public interface CargoDAO extends GenericDAO<Cargo, Long>{
	List<Cargo> procurarPorEmpresa(Long id);
}
