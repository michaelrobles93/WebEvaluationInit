package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Cbo;

@Repository
public class CboDAOImpl extends JPAGenericDAO<Cbo, Long> implements CboDAO{
	
	@Override
	public List<Cbo> procurarTudo() {
		TypedQuery<Cbo> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e ORDER BY 2", entityClass);
        return query.getResultList();
	}
}
