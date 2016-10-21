package br.com.webevaluationinit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.webevaluationinit.dao.CargoDAO;
import br.com.webevaluationinit.model.Cargo;
import br.com.webevaluationinit.model.Educacao;

@Service
@Transactional
public class CargoService {

	private CargoDAO cargoDAO;
	
	@Autowired
	public CargoService(CargoDAO cargoDAO) {
		this.cargoDAO = cargoDAO;
	}
	
	public Cargo salvar(Cargo cargo){
		return cargoDAO.salvar(cargo);
	}
	
	public List<Cargo> procurarTudo(){
		return cargoDAO.procurarTudo();
	}
	
	public Cargo procurarPorId(Long id){
		return cargoDAO.procurarPorId(id);
	}
	
	public Cargo atualizar(Cargo cargo){
		return cargoDAO.atualizar(cargo);
	}
	
	public List<Cargo> procurarPorEmpresa(Long id){
		return cargoDAO.procurarPorEmpresa(id);
	}
	
	public Educacao[] getEducacao(){
		return Educacao.values();
	}
	
}
