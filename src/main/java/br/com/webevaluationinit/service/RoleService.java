package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.RoleDAO;
import br.com.webevaluationinit.model.Role;

@Service
@Transactional
public class RoleService {

	private RoleDAO roleDAO;
	
	@Autowired
	public RoleService(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	public Role salvar(Role role){
		return roleDAO.salvar(role);
	}
	
	public List<Role> procurarTudo(){
		return roleDAO.procurarTudo();
	}
	
	
	public Role procurarPorId(Long id){
		return roleDAO.procurarPorId(id);
	}
	
	public Role atualizar(Role role){
		return roleDAO.atualizar(role);
	}
	
}
