package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity 
@Table(name = "medico")
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Medico extends User implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_especialidade", insertable=true, updatable=false, referencedColumnName="id")
//	@JsonBackReference(value="especialidade-medicos")
	private Especialidade especialidade;
//	private Integer especialidadeId;
//	private String especialidadeName;
	
	public Medico() {}
	public Medico(Integer id) {this.id = id;}
	
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public String getEspecialidadeName() {
//		return especialidade != null ? especialidade.getName() : "";
//	}
//	public Integer getEspecialidadeId() {
//		return especialidade != null ? especialidade.getId() : 0;
//	}
	
//	public void setEspecialidadeId(Integer especialidadeId) {
//		this.especialidadeId = especialidadeId;
//	}
//	public void setEspecialidadeName(String especialidadeName) {
//		this.especialidadeName = especialidadeName;
//	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(especialidade);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		especialidade = (Especialidade) in.readObject();
	}
	
	
}
