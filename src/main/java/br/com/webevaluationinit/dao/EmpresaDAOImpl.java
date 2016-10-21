package br.com.webevaluationinit.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Empresa;

@Repository
public class EmpresaDAOImpl extends JPAGenericDAO<Empresa, Long> implements EmpresaDAO{
	private EntityManager manager;
	
}
