package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.EnderecoDAO;
import br.com.webevaluationinit.model.Endereco;

@Service
@Transactional
public class EnderecoService {

	private EnderecoDAO enderecoDAO;
	
	@Autowired
	public EnderecoService(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
	
	public Endereco salvar(Endereco endereco){
		return enderecoDAO.salvar(endereco);
	}
	
	public List<Endereco> procurarTudo(){
		return enderecoDAO.procurarTudo();
	}
	
	
	public Endereco procurarPorId(Long id){
		return enderecoDAO.procurarPorId(id);
	}
	
	public Endereco atualizar(Endereco endereco){
		return enderecoDAO.atualizar(endereco);
	}
	
}
