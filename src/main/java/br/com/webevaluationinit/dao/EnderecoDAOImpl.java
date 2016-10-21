package br.com.webevaluationinit.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Endereco;

@Repository
public class EnderecoDAOImpl extends JPAGenericDAO<Endereco, Long> implements EnderecoDAO{
	private EntityManager manager;
	
}
