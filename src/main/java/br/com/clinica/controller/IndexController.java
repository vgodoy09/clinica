package br.com.clinica.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clinica.config.UserCredencial;
import br.com.clinica.model.Cliente;

@Controller
@RequestMapping("/")
public class IndexController {
	
	static final String INDEX = "index";
	
	@Autowired
	private UserCredencial userCredencial;
	
	@Autowired
	@Qualifier("paciente")
	private Map<Integer, Cliente> mapClient;
	
	
	@GetMapping
	public ModelAndView index() { 
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("tabela_consulta");
		}
		return mv;
	}
	
	@GetMapping("/consulta")
	public ModelAndView consulta() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("tabela_consulta");
		}
		return mv;
	}
	
	@GetMapping("/medico")
	public ModelAndView medicos() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("tabela_medico");
		}
		return mv;
	}
	
	@GetMapping("/especialidade")
	public ModelAndView especialidade() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("tabela_especialidade");
		}
		return mv;
	}
	
	@GetMapping("/paciente")
	public ModelAndView paciente() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("tabela_paciente");
		}
		return mv;
	}
	
	@GetMapping("/cadastropaciente") 
	public ModelAndView cadastropaciente() {   
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) { 
			mv.setViewName("paciente");
		}
		return mv;
	}
	
	@GetMapping("/cadastroespecialidade")
	public ModelAndView cadastroespecialidade() { 
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("especialidade"); 
		}
		return mv;
	}
	
	@GetMapping("/cadastromedico")
	public ModelAndView cadastromedico() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("medico");
		}
		return mv;
	}
	@GetMapping("/cadastroconsulta")
	public ModelAndView cadastroconsulta() {
		ModelAndView mv = new ModelAndView(INDEX);
		if(userCredencial.isLogger()) {
			mv.setViewName("consulta");
		}
		return mv;
	}
	
//	@GetMapping("/paciente/created")
//	public ModelAndView created() {
//		ModelAndView mv = new ModelAndView(INDEX);
//		if(userCredencial.isLogger()) {
//			mv.setViewName("redirect:/cadastropaciente");
//		}
//		return mv;
//	}
	
	
}
