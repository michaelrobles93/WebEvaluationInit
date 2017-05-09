package br.com.webevaluationinit.dao;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Role;

@Repository
public class RoleDAOImpl extends JPAGenericDAO<Role, Long> implements RoleDAO{

}
