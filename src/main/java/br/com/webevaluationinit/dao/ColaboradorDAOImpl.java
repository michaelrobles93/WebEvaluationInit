package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Colaborador;

@Repository
public class ColaboradorDAOImpl extends JPAGenericDAO<Colaborador, Long> implements ColaboradorDAO{
	
	public List<Colaborador> procurarPorCargo(Long idCargo){
		TypedQuery<Colaborador> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE id_cargo = :idCargo", entityClass).setParameter("idCargo", idCargo);
        return (List<Colaborador>) query.getResultList();
	}
	
	public List<Colaborador> procurarRelatorio(Colaborador colaborador){
		TypedQuery<Colaborador> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
		return (List<Colaborador>) query.getResultList();
	}
	
}
