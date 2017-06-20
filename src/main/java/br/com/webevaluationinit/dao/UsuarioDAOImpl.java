package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Usuario;

@Repository
public class UsuarioDAOImpl extends JPAGenericDAO<Usuario, Long> implements UsuarioDAO{
	
	public List<Usuario> procurarPorEmail(Usuario usuario){
		TypedQuery<Usuario> query = em
				.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE LOWER(e.email) LIKE LOWER('" + usuario.getEmail() + "') AND e.senha LIKE '" + usuario.getSenha() + "'", entityClass);		
		return (List<Usuario>) query.getResultList();
	}
	
}
