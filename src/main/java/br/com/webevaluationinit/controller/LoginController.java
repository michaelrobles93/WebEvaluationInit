package br.com.webevaluationinit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webevaluationinit.model.Role;
import br.com.webevaluationinit.model.Usuario;
import br.com.webevaluationinit.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private UsuarioService usuarioService;
	private int erro = -1;
	
	@Autowired
	public LoginController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView loginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("erro", this.erro);
		return new ModelAndView("/login");
	}
	
	@RequestMapping(value = "/efetuaLogin", method = RequestMethod.POST)
	public ModelAndView efetuaLogin(Usuario usuario, HttpSession session, Model model) {
		List<Usuario> usuariosLogado = usuarioService.procurarPorEmail(usuario);
		if(usuariosLogado.size() > 0){
			for (Usuario usuarioLogado : usuariosLogado) {
				session.setAttribute("usuarioLogado", usuarioLogado);
				for (Role roleUsuario : usuarioLogado.getRole()) {
					session.setAttribute("roleUsuario", roleUsuario);
				}
				return new ModelAndView("../index");
			}
		}
		this.erro = 0;
		model.addAttribute("erro", this.erro);
		this.erro = -1;
		return new ModelAndView("/login");
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("/login");
	}

}
