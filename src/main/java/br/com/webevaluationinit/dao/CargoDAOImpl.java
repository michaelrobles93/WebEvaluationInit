package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Cargo;

@Repository
public class CargoDAOImpl extends JPAGenericDAO<Cargo, Long> implements CargoDAO{
	
	public List<Cargo> procurarPorEmpresa(Long idEmpresa){
		TypedQuery<Cargo> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE id_empresa = :idEmpresa", entityClass).setParameter("idEmpresa", idEmpresa);
        return (List<Cargo>) query.getResultList();
	}

}
