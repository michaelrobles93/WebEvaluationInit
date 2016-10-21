package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.HabilidadeDAO;
import br.com.webevaluationinit.model.Habilidade;

@Service
@Transactional
public class HabilidadeService {

	private HabilidadeDAO habilidadeDAO;
	
	@Autowired
	public HabilidadeService(HabilidadeDAO habilidadeDAO) {
		this.habilidadeDAO = habilidadeDAO;
	}
	
	public Habilidade salvar(Habilidade habilidade){
		return habilidadeDAO.salvar(habilidade);
	}
	
	public List<Habilidade> procurarTudo(){
		return habilidadeDAO.procurarTudo();
	}
	
	
	public Habilidade procurarPorId(Long id){
		return habilidadeDAO.procurarPorId(id);
	}
	
	public Habilidade atualizar(Habilidade habilidade){
		return habilidadeDAO.atualizar(habilidade);
	}
	
}
