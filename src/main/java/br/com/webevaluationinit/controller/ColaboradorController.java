package br.com.webevaluationinit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
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

import br.com.webevaluationinit.model.Admissao;
import br.com.webevaluationinit.model.AdmissaoId;
import br.com.webevaluationinit.model.Cargo;
import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.EstadoCivil;
import br.com.webevaluationinit.model.Genero;
import br.com.webevaluationinit.model.Telefone;
import br.com.webevaluationinit.model.TipoTelefone;
import br.com.webevaluationinit.service.AdmissaoService;
import br.com.webevaluationinit.service.CargoService;
import br.com.webevaluationinit.service.ColaboradorService;
import br.com.webevaluationinit.service.EmpresaService;
import br.com.webevaluationinit.util.DatePropertyEditor;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {

	private ColaboradorService colaboradorService;
	private EmpresaService empresaService;
	private AdmissaoService admissaoService;
	private CargoService cargoService;
	
	private int sucesso = -1;
	
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		//binder.setValidator(userValidator);
		//binder.registerCustomEditor(Profile.class, new ProfilePropertyEditor(profileDao));
		binder.registerCustomEditor(Date.class, new DatePropertyEditor(new SimpleDateFormat("dd/MM/yyyy")));
	}

	@Autowired
	public ColaboradorController(ColaboradorService colaboradorService, 
			EmpresaService empresaService, 
			AdmissaoService admissaoService,
			CargoService cargoservice) {
		this.colaboradorService = colaboradorService;
		this.empresaService = empresaService;
		this.admissaoService = admissaoService;
		this.cargoService = cargoservice;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Colaborador colaborador, Model model) {
		
		List<Cargo> lstCargo = new ArrayList<Cargo>();
		
		model.addAttribute("estadoCivil", EstadoCivil.values());
		model.addAttribute("generos", Genero.values());
		
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("lstEmpresa", empresaService.procurarTudo());
		
		if (colaborador.getAdmissoes() != null){
			for (Admissao admissao : colaborador.getAdmissoes()){
				lstCargo = cargoService.procurarPorEmpresa(admissao.getEmpresa().getId());
				model.addAttribute("lstCargo", lstCargo);
			}
		}
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		
		return new ModelAndView("/colaborador/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid Colaborador colaborador, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.sucesso = 0;
			model.addAttribute("sucesso", this.sucesso);
			return form(colaborador, model);
		}
		
		List<Telefone> lstTelefone = colaborador.getTelefones();
		List<Admissao> lstAdmissao = colaborador.getAdmissoes();
		
		colaborador.setTelefones(insereTelefones(lstTelefone));
		
		if (colaborador.getColaboradorSuperiorImediato().getId() == null){
			colaborador.setColaboradorSuperiorImediato(null);
		}
		
		if (colaborador.getId() != null) {
			colaboradorService.atualizar(colaborador);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			/*for (Admissao admissao : lstAdmissao){
				admissao.setId(new AdmissaoId());
				admissao.setColaborador(new Colaborador());
				admissao.setColaborador(colaborador);
				admissao.getId().setIdColaborador(admissao.getColaborador().getId());
				admissao.getId().setIdEmpresa(admissao.getEmpresa().getId());
				admissaoService.salvar(admissao);
			}*/
			return list(model);
		} else {
			colaboradorService.salvar(colaborador);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			for (Admissao admissao : lstAdmissao){
				admissao.setId(new AdmissaoId());
				//admissao.setColaborador(new Colaborador());
				admissao.setColaborador(colaborador);
				admissao.getId().setIdColaborador(admissao.getColaborador().getId());
				admissao.getId().setIdEmpresa(admissao.getEmpresa().getId());
				
				admissaoService.salvar(admissao);
			}
			return form(new Colaborador(), model);
		}
		
	}
 
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		Colaborador colaborador = new Colaborador();
		if (longId != null) {
			colaborador = colaboradorService.procurarPorId(longId);
			Hibernate.initialize(colaborador.getEnderecos());
			Hibernate.initialize(colaborador.getTelefones());
			model.addAttribute("colaborador", colaborador);
		}
		return form(colaborador, model);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Colaborador> lstColaborador = new ArrayList<Colaborador>();
		lstColaborador = colaboradorService.procurarTudo();
		model.addAttribute("lstColaborador", lstColaborador);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/colaborador/list");
	}
	
	@RequestMapping(value = "/list2", method = RequestMethod.POST)
	public ModelAndView list2(@Valid Colaborador colaborador, Model model, BindingResult bindingResult) {
		System.out.println("aaa");
		if (bindingResult.hasErrors()) {
			System.out.println("bbb");
			return new ModelAndView("/relatorio/form");
			
		}
		System.out.println("ccc");
		List<Colaborador> lstColaborador = new ArrayList<Colaborador>();
		lstColaborador = colaboradorService.procurarRelatorio(colaborador);
		model.addAttribute("lstColaborador", lstColaborador);
		return new ModelAndView("/relatorio/list2");
	}
	
	public List<Telefone> insereTelefones(List<Telefone> lstTelefone){
		if (lstTelefone.get(2).getNumero().trim().equals("")){
			lstTelefone.remove(lstTelefone.get(2));
		}else{
			lstTelefone.get(2).setTipo(TipoTelefone.COMERCIAL);
		}
		if (lstTelefone.get(1).getNumero().trim().equals("")){
			lstTelefone.remove(lstTelefone.get(1));
		}else{
			lstTelefone.get(1).setTipo(TipoTelefone.CELULAR);
		}
		if (lstTelefone.get(0).getNumero().trim().equals("")){
			lstTelefone.remove(lstTelefone.get(0));
		}else{
			lstTelefone.get(0).setTipo(TipoTelefone.RESIDENCIAL);
		}
		return lstTelefone;
	}

}
