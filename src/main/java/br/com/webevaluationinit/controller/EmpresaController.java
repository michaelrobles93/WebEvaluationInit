package br.com.webevaluationinit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.webevaluationinit.model.Empresa;
import br.com.webevaluationinit.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	private EmpresaService empresaService;
	private int sucesso = -1;
	private int msgErro = -1;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Empresa empresa, Model model) {
		model.addAttribute("empresa", empresa);
		model.addAttribute("sucesso", this.sucesso);
		model.addAttribute("msgErro", this.msgErro);
		this.sucesso = -1;
		this.msgErro = -1;
		return new ModelAndView("/empresa/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid Empresa empresa, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.sucesso = 0;
			return form(empresa, model);
		}
		if (empresa.getId() != null) {
			empresaService.atualizar(empresa);
			this.sucesso = 1;
			return list(model);
		} else {
			try {
				empresaService.salvar(empresa);
			} catch (Exception e){
				this.sucesso = 0;
				this.msgErro = 1;
				System.out.println(this.msgErro);
				return form(empresa, model);
			}
			this.sucesso = 1;
			return form(new Empresa(), model);
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		Empresa empresa = new Empresa();
		if (longId != null) {
			empresa = empresaService.procurarPorId(longId);
			Hibernate.initialize(empresa.getEnderecos());
			model.addAttribute("empresa", empresa);
		}
		return form(empresa, model);
	}

	@RequestMapping(value = "/addEndereco", method = RequestMethod.POST)
	public ModelAndView addEndereco(Empresa empresa, Model model) {
		// empresa.getEnderecos().add(new Endereco());
		return form(empresa, model);
	}

	// sucesso: -1 nada / 0 erro / 1 sucesso
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Empresa> lstEmpresa = new ArrayList<Empresa>();
		lstEmpresa = empresaService.procurarTudo();
		model.addAttribute("lstEmpresa", lstEmpresa);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/empresa/list");
	}

}
