package br.com.webevaluationinit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.webevaluationinit.model.Cargo;
import br.com.webevaluationinit.model.Cbo;
import br.com.webevaluationinit.model.Educacao;
import br.com.webevaluationinit.model.Empresa;
import br.com.webevaluationinit.model.Funcao;
import br.com.webevaluationinit.model.Habilidade;
import br.com.webevaluationinit.model.Status;
import br.com.webevaluationinit.service.CargoService;
import br.com.webevaluationinit.service.CboService;
import br.com.webevaluationinit.service.EmpresaService;
import br.com.webevaluationinit.service.FuncaoService;
import br.com.webevaluationinit.service.HabilidadeService;

@Controller
@RequestMapping("/cargo")
public class CargoController {

	private CargoService cargoService;
	private EmpresaService empresaService;
	private CboService cboService;
	private HabilidadeService habilidadeService;
	private FuncaoService funcaoService;
	private int sucesso = -1;

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "habilidades", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				Long id = null;
				if (element instanceof Habilidade) {
					return element;
				} else if (element instanceof String && !((String) element).equals("")) {
					// From the JSP 'element' will be a String
					try {
						id = Long.parseLong((String) element);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				} else if (element instanceof Long) {
					// From the database 'element' will be a Long
					id = (Long) element;
				}

				return id != null ? habilidadeService.procurarPorId(id) : null;
			}
		});
		// binder.setValidator(userValidator);
		// binder.registerCustomEditor(Profile.class, new
		// ProfilePropertyEditor(profileDao));
		// binder.registerCustomEditor(Date.class, new DatePropertyEditor(new
		// SimpleDateFormat("dd/MM/yyyy")));
	}

	@Autowired
	public CargoController(CargoService cargoService, EmpresaService empresaService, CboService cboService,
			HabilidadeService habilidadeService, FuncaoService funcaoService) {
		this.cargoService = cargoService;
		this.empresaService = empresaService;
		this.cboService = cboService;
		this.habilidadeService = habilidadeService;
		this.funcaoService = funcaoService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Cargo cargo, Model model) {

		List<Empresa> lstEmpresa = empresaService.procurarTudo();
		List<Cbo> lstCbo = cboService.procurarTudo();
		List<Habilidade> lstHabilidade = habilidadeService.procurarTudo();
		List<Funcao> lstFuncao = funcaoService.procurarTudo();

		model.addAttribute("lstEmpresa", lstEmpresa);
		model.addAttribute("lstCbo", lstCbo);
		model.addAttribute("lstHabilidade", lstHabilidade);
		model.addAttribute("cargo", cargo);
		model.addAttribute("lstFuncao", lstFuncao);
		model.addAttribute("lstEducacao", Educacao.values());
		model.addAttribute("lstStatus", Status.values());
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;

		return new ModelAndView("/cargo/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST, name = "novoCargo")
	public ModelAndView novo(@Valid Cargo cargo, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			form(cargo, model);
		}
		if (cargo.getCargoSuperiorDireto().getId() == 0){
			cargo.setCargoSuperiorDireto(null);
		}
		if (cargo.getCbo().getId() == 0){
			cargo.setCbo(null);
		}
		if (cargo.getFuncao().getId() == 0){
			cargo.setFuncao(null);
		}
		if (cargo.getId() != null) {
			cargoService.atualizar(cargo);
			this.sucesso = 1;
			return list(model);
		} else {
			cargoService.salvar(cargo);
			this.sucesso = 1;
			return form(new Cargo(), model);
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		if (longId != null) {
			return form(cargoService.procurarPorId(longId), model);
		}
		return new ModelAndView("/cargo/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Cargo> lstCargo = new ArrayList<Cargo>();
		lstCargo = cargoService.procurarTudo();
		model.addAttribute("lstCargo", lstCargo);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/cargo/list");
	}

}
