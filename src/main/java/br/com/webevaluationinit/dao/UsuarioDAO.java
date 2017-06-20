package br.com.webevaluationinit.dao;

import java.util.List;

import br.com.webevaluationinit.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Long>{
	List<Usuario> procurarPorEmail(Usuario usuario);
}
