package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity 
@Table(name = "especialidade")
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Especialidade implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column
	private String name;
	
	
//	@JsonIgnoreProperties("medico")
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialidade")
//	@JsonManagedReference(value="especialidade-medicos")
//	private List<Medicos> medicos;
	
	
	public Especialidade() {}
	public Especialidade(Integer id) {this.id = id;}
	public Especialidade(Integer id, @NotBlank String name) {this.id = id;this.name = name;}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

////	@JsonIgnore
//	public List<Medicos> getMedicos() {
//		return medicos;
//	}
//
////	@JsonIgnore
//	public void setMedicos(List<Medico> medicos) {
//		this.medicos = medicos;
//	}
	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(name);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		name = (String) in.readObject();
	}
	

}
