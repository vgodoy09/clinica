package br.com.clinica.controller;

import static br.com.clinica.config.utils.CheckInstanceObject.IsNullOrIsEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.config.LogServer;
import br.com.clinica.config.UserCredencial;
import br.com.clinica.model.dto.LoginError;
import br.com.clinica.model.dto.UserDTO;
import br.com.clinica.repository.UserRepository;

@RestController
public class LoginRest {

	@Autowired
	private LogServer logServer;
	@Autowired
	private UserCredencial userCredencial;
	@Autowired
	private UserRepository userRepository;
	
//	private RestTemplate rest = new RestTemplate();
    
	@PostMapping("/login/{login}/{password}")
	public LoginError login(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) {
		
		if(IsNullOrIsEmpty(login)) 
			return new LoginError(true, "Preencha o Login!"); 
		if(IsNullOrIsEmpty(password)) 
			return new LoginError(true, "Preencha o Password!"); 
		
		
		UserDTO userDTO = logger(login, password);
		if(userDTO == null) {
			return new LoginError(true, "Usuario não encontrado!");
		}
		
		userCredencial.loggin(userDTO);
		return new LoginError(false, null);
	}
	
	@GetMapping("/getNamePerson")
	public String getName() {
		
		if(userCredencial != null && userCredencial.getCurrentUser() != null) {
			return "Bem-Vindo "+userCredencial.getCurrentUser().getName()+"!";
		}
		
		return "";
	}
	
	@GetMapping("/getId")
	public String getID() {
		
		if(userCredencial != null && userCredencial.getCurrentUser() != null) {
			return ""+userCredencial.getCurrentUser().getId();
		}
		
		return "";
	}
	
	public UserDTO logger(String login, String password) {
		UserDTO userDTO = null;
		
		try {
			userDTO = userRepository.login(login, password);
			System.out.println(userDTO);
//			UserDTO = rest.getForObject(Configuration.URL_LOGIN+login+"", UserDTO.class);
		} catch(Exception e) {
			logServer.monitoringErrorLog("LoginRest.logger", e.getMessage(), login);
			e.printStackTrace();
		}
		
		if(userDTO != null) {
			userDTO.setName(userDTO.getName().split(" ")[0]);
		}
		return userDTO;
	}


}
