package br.com.clinica.config;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.model.User;

@Service
public class UserCredencial {

	@Autowired
    private HttpSession httpSession;
	
	static final String CURRENT_USER_KEY = "CURRENT_USER";
	
	public void loggin(User user) {
		httpSession.setAttribute(CURRENT_USER_KEY, user);
	}
	
	public boolean isLogger() {
		return httpSession.getAttribute(CURRENT_USER_KEY) == null ? false : true;
	}
	
	public User getCurrentUser() {
		return (User)httpSession.getAttribute(CURRENT_USER_KEY);
	}
	
	public void logout() {
		httpSession.removeAttribute(CURRENT_USER_KEY);
	}
	
}