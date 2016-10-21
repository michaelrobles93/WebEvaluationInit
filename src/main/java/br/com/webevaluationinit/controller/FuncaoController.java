package br.com.webevaluationinit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.webevaluationinit.model.Funcao;
import br.com.webevaluationinit.service.FuncaoService;
import br.com.webevaluationinit.util.DatePropertyEditor;

@Controller
@RequestMapping("/funcao")
public class FuncaoController {

	private FuncaoService funcaoService;
	private int sucesso = -1;

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		//binder.setValidator(userValidator);
		//binder.registerCustomEditor(Profile.class, new ProfilePropertyEditor(profileDao));
		binder.registerCustomEditor(Date.class, new DatePropertyEditor(new SimpleDateFormat("dd/MM/yyyy")));
	}

	@Autowired
	public FuncaoController(FuncaoService funcaoService) {
		this.funcaoService = funcaoService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Funcao funcao, Model model) {
		//model.addAttribute("estadoCivil", EstadoCivil.values());
		//model.addAttribute("generos", Genero.values());
		model.addAttribute("funcao", funcao);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/funcao/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid Funcao funcao, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.sucesso = 0;
			model.addAttribute("sucesso", this.sucesso);
			return form(funcao, model);
		}
		if (funcao.getId() != null) {
			funcaoService.atualizar(funcao);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return list(model);
		} else {
			funcaoService.salvar(funcao);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return form(new Funcao(), model);
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		if (longId != null) {
			return form(funcaoService.procurarPorId(longId), model);
		}
		return new ModelAndView("/funcao/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Funcao> lstFuncao = new ArrayList<Funcao>();
		lstFuncao = funcaoService.procurarTudo();
		model.addAttribute("lstFuncao", lstFuncao);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/funcao/list");
	}
	
}
