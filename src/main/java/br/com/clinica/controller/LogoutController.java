package br.com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clinica.config.UserCredencial;

@Controller
public class LogoutController {

	@Autowired
	private UserCredencial user; 

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("redirect:/");
		user.logout();
		return mv;
	}
}
