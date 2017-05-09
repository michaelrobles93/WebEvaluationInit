package br.com.webevaluationinit.dao;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Usuario;

@Repository
public class UsuarioDAOImpl extends JPAGenericDAO<Usuario, Long> implements UsuarioDAO{

}
