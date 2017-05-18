package br.com.webevaluationinit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.webevaluationinit.model.Role;
import br.com.webevaluationinit.model.Usuario;
import br.com.webevaluationinit.service.RoleService;
import br.com.webevaluationinit.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;
	private RoleService roleService;
	private int sucesso = -1;

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "role", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				Long id = null;
				if (element instanceof Role) {
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

				return id != null ? roleService.procurarPorId(id) : null;
			}
		});
	}

	@Autowired
	public UsuarioController(UsuarioService usuarioService, RoleService roleService) {
		this.usuarioService = usuarioService;
		this.roleService = roleService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Usuario usuario, Model model) {
		List<Role> lstRole = roleService.procurarTudo();
		usuario.setSenha(null);
		model.addAttribute("usuario", usuario);
		model.addAttribute("lstRole", lstRole);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/usuario/form");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			this.sucesso = 0;
			model.addAttribute("sucesso", this.sucesso);
			return form(usuario, model);
		}
		if (usuario.getId() != null) {
			Usuario usuarioSenha = usuarioService.procurarPorId(usuario.getId());
			usuario.setSenha(usuarioSenha.getSenha());
			
			usuarioService.atualizar(usuario);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return list(model);
		} else {
			usuarioService.salvar(usuario);
			this.sucesso = 1;
			model.addAttribute("sucesso", this.sucesso);
			return form(new Usuario(), model);
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String id, Model model) {
		Long longId = Long.parseLong(id);
		if (longId != null) {
			return form(usuarioService.procurarPorId(longId), model);
		}
		return new ModelAndView("/usuario/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		List<Usuario> lstUsuario = new ArrayList<Usuario>();
		lstUsuario = usuarioService.procurarTudo();
		model.addAttribute("lstUsuario", lstUsuario);
		model.addAttribute("sucesso", this.sucesso);
		this.sucesso = -1;
		return new ModelAndView("/usuario/list");
	}

}
