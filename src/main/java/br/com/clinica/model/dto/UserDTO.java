package br.com.clinica.model.dto;

import javax.persistence.Entity;

import br.com.clinica.model.User;

@Entity
public class UserDTO extends User {

	@Override
	public String toString() {
		return "UserDTO [getId()=" + getId() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", getDateBirth()=" + getDateBirth() + ", getName()=" + getName() + ", getNumberChildren()="
				+ getNumberChildren() + ", getStatus()=" + getStatus() + ", getPhone()=" + getPhone() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
