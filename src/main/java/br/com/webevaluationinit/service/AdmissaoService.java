package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.AdmissaoDAO;
import br.com.webevaluationinit.model.Admissao;

@Service
@Transactional
public class AdmissaoService {

	private AdmissaoDAO admissaoDAO;
	
	@Autowired
	public AdmissaoService(AdmissaoDAO admissaoDAO) {
		this.admissaoDAO = admissaoDAO;
	}
	
	public Admissao salvar(Admissao admissao){
		return admissaoDAO.salvar(admissao);
	}
	
	public List<Admissao> procurarTudo(){
		return admissaoDAO.procurarTudo();
	}
	
	
	public Admissao procurarPorId(Long id){
		return admissaoDAO.procurarPorId(id);
	}
	
	public Admissao atualizar(Admissao admissao){
		return admissaoDAO.atualizar(admissao);
	}
	
}
