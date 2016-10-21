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

import br.com.webevaluationinit.model.Habilidade;
import br.com.webevaluationinit.service.HabilidadeService;
import br.com.webevaluationinit.util.DatePropertyEditor;

@Controller
@RequestMapping("/habilidade")
public class HabilidadeController {

	private HabilidadeService habilidadeService;
	private int sucesso = -1;

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		//binder.setValidator(userValidator);
		//binder.registerCustomEditor(Profile.class, new ProfilePropertyEditor(profileDao));
		binder.registerCustomEditor(Date.class, new DatePropertyEditor(new SimpleDateFormat("dd/MM/yyyy")));
	}

	@Autowired
	public HabilidadeController(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Habilidade habilidade, Model model) {
		//model.addAttribute("estadoCivil", EstadoCivil.values());
		//model.addAttribute("generos", Genero.values());
		model.addAttribute("habilidade", habilidade);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/habilidade/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid Habilidade habilidade, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.sucesso = 0;
			model.addAttribute("sucesso", this.sucesso);
			return form(habilidade, model);
		}
		if (habilidade.getId() != null) {
			habilidadeService.atualizar(habilidade);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return list(model);
		} else {
			habilidadeService.salvar(habilidade);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return form(new Habilidade(), model);
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		if (longId != null) {
			return form(habilidadeService.procurarPorId(longId), model);
		}
		return new ModelAndView("/habilidade/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Habilidade> lstHabilidade = new ArrayList<Habilidade>();
		lstHabilidade = habilidadeService.procurarTudo();
		model.addAttribute("lstHabilidade", lstHabilidade);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/habilidade/list");
	}

}
