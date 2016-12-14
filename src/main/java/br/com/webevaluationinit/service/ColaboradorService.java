package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.ColaboradorDAO;
import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.EstadoCivil;
import br.com.webevaluationinit.model.Relatorio;

@Service
@Transactional
public class ColaboradorService {

	private ColaboradorDAO colaboradorDAO;
	
	@Autowired
	public ColaboradorService(ColaboradorDAO colaboradorDAO) {
		this.colaboradorDAO = colaboradorDAO;
	}
	
	public Colaborador salvar(Colaborador colaborador){
		return colaboradorDAO.salvar(colaborador);
	}
	
	public List<Colaborador> procurarTudo(){
		return colaboradorDAO.procurarTudo();
	}
	
	public List<Colaborador> procurarRelatorio(Relatorio relatorio){
		return colaboradorDAO.procurarRelatorio(relatorio);
	}	
	
	public Colaborador procurarPorId(Long id){
		return colaboradorDAO.procurarPorId(id);
	}
	
	public Colaborador atualizar(Colaborador colaborador){
		return colaboradorDAO.atualizar(colaborador);
	}
	
	public EstadoCivil[] getEstadoCivil(){
		return EstadoCivil.values();
	}
	
	public List<Colaborador> procurarPorCargo(Long id){
		return colaboradorDAO.procurarPorCargo(id);
	}
}
