package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.UsuarioDAO;
import br.com.webevaluationinit.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario salvar(Usuario usuario){
		return usuarioDAO.salvar(usuario);
	}
	
	public List<Usuario> procurarTudo(){
		return usuarioDAO.procurarTudo();
	}
	
	
	public Usuario procurarPorId(Long id){
		return usuarioDAO.procurarPorId(id);
	}
	
	public Usuario atualizar(Usuario usuario){
		return usuarioDAO.atualizar(usuario);
	}
	
}
