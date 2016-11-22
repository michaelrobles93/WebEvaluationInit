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

import br.com.webevaluationinit.model.Admissao;
import br.com.webevaluationinit.model.Cargo;
import br.com.webevaluationinit.model.Cbo;
import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.Educacao;
import br.com.webevaluationinit.model.Empresa;
import br.com.webevaluationinit.model.EstadoCivil;
import br.com.webevaluationinit.model.Funcao;
import br.com.webevaluationinit.model.Genero;
import br.com.webevaluationinit.model.Habilidade;
import br.com.webevaluationinit.model.Status;
import br.com.webevaluationinit.service.CargoService;
import br.com.webevaluationinit.service.CboService;
import br.com.webevaluationinit.service.ColaboradorService;
import br.com.webevaluationinit.service.EmpresaService;
import br.com.webevaluationinit.service.FuncaoService;
import br.com.webevaluationinit.service.HabilidadeService;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	private ColaboradorService colaboradorService;
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
	public RelatorioController(CargoService cargoService, EmpresaService empresaService, CboService cboService,
			HabilidadeService habilidadeService, FuncaoService funcaoService, ColaboradorService colaboradorService) {
		this.cargoService = cargoService;
		this.empresaService = empresaService;
		this.cboService = cboService;
		this.habilidadeService = habilidadeService;
		this.funcaoService = funcaoService;
		this.colaboradorService = colaboradorService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Model model) {

		List<Empresa> lstEmpresa = empresaService.procurarTudo();
		List<Cbo> lstCbo = cboService.procurarTudo();
		List<Habilidade> lstHabilidade = habilidadeService.procurarTudo();
		List<Funcao> lstFuncao = funcaoService.procurarTudo();
		Colaborador colaborador = new Colaborador();

		model.addAttribute("lstEmpresa", lstEmpresa);
		model.addAttribute("lstCbo", lstCbo);
		model.addAttribute("lstHabilidade", lstHabilidade);
		model.addAttribute("lstFuncao", lstFuncao);
		model.addAttribute("lstEducacao", Educacao.values());
		model.addAttribute("lstGenero", Genero.values());
		model.addAttribute("lstStatus", Status.values());
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("i", 0);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;

		return new ModelAndView("/relatorio/form");
	}

	/*@RequestMapping(value = "/novo", method = RequestMethod.POST, name = "novoCargo")
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
*/
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		if (longId != null) {
			Colaborador colaborador = colaboradorService.procurarPorId(longId);
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
			return new ModelAndView("/relatorio/view");
		}
		return new ModelAndView("/relatorio/list");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView list(@Valid Colaborador colaborador, BindingResult bindingResult, Model model) {
		List<Colaborador> lstColaborador = new ArrayList<Colaborador>();
		lstColaborador = colaboradorService.procurarRelatorio(colaborador);
		model.addAttribute("lstColaborador", lstColaborador);
		return new ModelAndView("/relatorio/list");
	}
}
