package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Habilidade;

@Repository
public class HabilidadeDAOImpl extends JPAGenericDAO<Habilidade, Long> implements HabilidadeDAO{
	public List<Habilidade> procurarTudo() {
        TypedQuery<Habilidade> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e ORDER BY e.nomeHabilidade", entityClass);
        return query.getResultList();
    }
}
