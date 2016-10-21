package br.com.webevaluationinit.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Habilidade;

@Repository
public class HabilidadeDAOImpl extends JPAGenericDAO<Habilidade, Long> implements HabilidadeDAO{
	private EntityManager manager;
}
