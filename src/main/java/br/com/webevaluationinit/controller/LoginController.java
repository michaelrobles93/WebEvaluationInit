package br.com.webevaluationinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView hello() {
		return new ModelAndView("/login");
	}

}
