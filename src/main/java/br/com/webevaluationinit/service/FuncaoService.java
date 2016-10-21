package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.FuncaoDAO;
import br.com.webevaluationinit.model.Funcao;

@Service
@Transactional
public class FuncaoService {

	private FuncaoDAO funcaoDAO;
	
	@Autowired
	public FuncaoService(FuncaoDAO funcaoDAO) {
		this.funcaoDAO = funcaoDAO;
	}
	
	public Funcao salvar(Funcao funcao){
		return funcaoDAO.salvar(funcao);
	}
	
	public List<Funcao> procurarTudo(){
		return funcaoDAO.procurarTudo();
	}
	
	
	public Funcao procurarPorId(Long id){
		return funcaoDAO.procurarPorId(id);
	}
	
	public Funcao atualizar(Funcao funcao){
		return funcaoDAO.atualizar(funcao);
	}
	
}
