package br.com.webevaluationinit.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Funcao;

@Repository
public class FuncaoDAOImp extends JPAGenericDAO<Funcao, Long> implements FuncaoDAO{
	private EntityManager manager;
}
