package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity 
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Cliente extends User implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean convenio;
	
	public Cliente() {}
	public Cliente(Integer id) {this.id = id;}
	
	
	public Boolean getConvenio() {
		return convenio;
	}
	public void setConvenio(Boolean convenio) {
		this.convenio = convenio;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(convenio);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		convenio = (Boolean) in.readObject();
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", convenio=" + convenio + ", login=" + getLogin() + ", password=" + getPassword() + ", dateBirth=" + getDateBirth() + ", name="
				+ getName() + ", numberChildren=" + getNumberChildren() + ", status=" + getStatus() + ", phone=" + getPhone() + "]";
	}
}
