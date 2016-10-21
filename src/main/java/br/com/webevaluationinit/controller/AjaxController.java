package br.com.webevaluationinit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.webevaluationinit.model.Cargo;
import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.Empresa;
import br.com.webevaluationinit.service.CargoService;
import br.com.webevaluationinit.service.ColaboradorService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	CargoService cargoService;
	ColaboradorService colaboradorService;
	
	@Autowired
	public AjaxController(CargoService cargoService, ColaboradorService colaboradorService) {
		this.cargoService = cargoService;
		this.colaboradorService = colaboradorService;
	}
	

	@RequestMapping(value = "/searchingCargos",
			method = RequestMethod.POST,
			headers="Accept=*/*")
	public @ResponseBody List<Cargo> getSearchResultAjax(@RequestBody Empresa empresa){
		
		List<Cargo> cargo = new ArrayList<Cargo>();
		
		cargo = cargoService.procurarPorEmpresa(empresa.getId());
		
		return cargo;
	}
	
	@RequestMapping(value = "/searchingColaboradores",
			method = RequestMethod.POST,
			headers="Accept=*/*")
	public @ResponseBody List<Colaborador> getSearchResultAjax(@RequestBody Cargo cargo){
		
		List<Colaborador> colaborador = new ArrayList<Colaborador>();
		
		colaborador = colaboradorService.procurarPorCargo(cargo.getId());
		
		return colaborador;
	}

}
