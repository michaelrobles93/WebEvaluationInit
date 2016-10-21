package br.com.webevaluationinit.dao;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Admissao;

@Repository
public class AdmissaoDAOImpl extends JPAGenericDAO<Admissao, Long> implements AdmissaoDAO{
	
}
