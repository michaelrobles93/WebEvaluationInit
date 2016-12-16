package br.com.webevaluationinit.service;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.EmpresaDAO;
import br.com.webevaluationinit.model.Empresa;

@Service
@Transactional
public class EmpresaService {

	private EmpresaDAO empresaDAO;
	
	@Autowired
	public EmpresaService(EmpresaDAO empresaDAO) {
		this.empresaDAO = empresaDAO;
	}
	
	public Empresa salvar(Empresa empresa){
		return empresaDAO.salvar(empresa);
	}
	
	public List<Empresa> procurarTudo(){
		return empresaDAO.procurarTudo();
	}
	
	
	public Empresa procurarPorId(Long id){
		return empresaDAO.procurarPorId(id);
	}
	
	public Empresa atualizar(Empresa empresa){
		return empresaDAO.atualizar(empresa);
	}
	
}
