package br.com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clinica.config.UserCredencial;

@Controller
@RequestMapping("/")
public class IndexController {
	
	static final String INDEX = "index";
	
	@Autowired
	private UserCredencial userCredencial;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("tabela_consulta");
		}
		return mv;
	}
	
	@GetMapping("/consulta")
	public ModelAndView consulta() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("tabela_consulta");
		}
		return mv;
	}
	
	@GetMapping("/medico")
	public ModelAndView medicos() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("tabela_medico");
		}
		return mv;
	}
	
	@GetMapping("/especialidade")
	public ModelAndView especialidade() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("tabela_especialidade");
		}
		return mv;
	}
	
	@GetMapping("/paciente")
	public ModelAndView paciente() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("tabela_paciente");
		}
		return mv;
	}
	
	@GetMapping("/cadastropaciente")
	public ModelAndView cadastropaciente() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("paciente");
			mv.addObject("titulo", "Cadastro Paciente");
		}
		return mv;
	}
	
	@GetMapping("/paciente/created")
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/admin");
			mv = new ModelAndView("redirect:/cadastropaciente");
		}
		return mv;
	}
	
	
}
