package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.CboDAO;
import br.com.webevaluationinit.model.Cbo;

@Service
@Transactional
public class CboService {

	
	private CboDAO cboDAO;
	
	@Autowired
	public CboService(CboDAO cboDAO) {
		this.cboDAO = cboDAO;
	}
	
	public Cbo salvar(Cbo cbo){
		return cboDAO.salvar(cbo);
	}
	
	public List<Cbo> procurarTudo(){
		return cboDAO.procurarTudo();
	}
	
	
	public Cbo procurarPorId(Long id){
		return cboDAO.procurarPorId(id);
	}
	
	public Cbo atualizar(Cbo cbo){
		return cboDAO.atualizar(cbo);
	}
	
}
