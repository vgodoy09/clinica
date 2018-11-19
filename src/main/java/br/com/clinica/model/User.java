package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.clinica.model.enuns.Status;

@Entity 
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"accounts", "dreams", "categories"})
//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@NotBlank(message="Informar um Login")
	private String login;
	@NotBlank(message="Informar um Passoword")
	private String password;
	private LocalDate dateBirth;
	@NotBlank(message="Informar um Nome")
	private String name;
	@Column
	private Integer numberChildren;
	@Enumerated(EnumType.STRING)
    private Status status;
	@Column
	private String phone;
//	@JsonIgnoreProperties("userCategory")
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCategory")
//	@JsonManagedReference(value="user-categories")
//	private List<Category> categories;
//	@JsonIgnoreProperties("user")
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	@JsonManagedReference(value="user-dreams")
//	private List<Dream> dreams;
//	@JsonIgnoreProperties("users")
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy="users")
//	private List<Accounts> accounts;
	
	public User() {}
	public User(Integer id) {this.id = id;}
	public User(Integer id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberChildren() {
		return numberChildren;
	}

	public void setNumberChildren(Integer numberChildren) {
		this.numberChildren = numberChildren;
	}

////	@JsonIgnore
//	public List<Category> getCategories() {
//		return categories;
//	}
//
////	@JsonIgnore
//	public List<Accounts> getAccounts() {
//		return accounts;
//	}
//
////	@JsonIgnore
//	public void setAccounts(List<Accounts> accounts) {
//		this.accounts = accounts;
//	}
//
////	@JsonIgnore
//	public void setCategories(List<Category> categories) {
//		this.categories = categories;
//	}
//	
////	@JsonIgnore
//	public List<Dream> getDreams() {
//		return dreams;
//	}
//	
////	@JsonIgnore
//	public void setDreams(List<Dream> dreams) {
//		this.dreams = dreams;
//	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(login);
		out.writeObject(password);
		out.writeObject(dateBirth);
		out.writeObject(name);
		out.writeObject(numberChildren);
//		out.writeObject(categories);
//		out.writeObject(accounts);
//		out.writeObject(dreams);
		out.writeObject(status);
		out.writeObject(phone);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		login = (String) in.readObject();
		password = (String) in.readObject();
		dateBirth = (LocalDate) in.readObject(); //serial date sql
		name = (String) in.readObject();
		numberChildren = (Integer) in.readObject();
//		categories = (List<Category>) in.readObject();
//		accounts = (List<Accounts>) in.readObject();
//		dreams = (List<Dream>) in.readObject();
		status = (Status) in.readObject();
		phone = (String) in.readObject();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", dateBirth=" + dateBirth + ", name="
				+ name + ", numberChildren=" + numberChildren + ", status=" + status + ", phone=" + phone + "]";
	}
	
	
}
