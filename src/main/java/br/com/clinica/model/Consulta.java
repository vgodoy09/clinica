package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.clinica.model.enuns.Status;

@Entity 
@Table(name = "consulta")
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Consulta implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="data_consulta")
	private String dataConsulta;
	@Column(name="descricao")
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
    private Status status;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_medico", insertable=true, updatable=false, referencedColumnName="id")
//	@JsonBackReference(value="medico-consultas")
	private Medico medico;
//	private String medicoName;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente", insertable=true, updatable=false, referencedColumnName="id")
//	@JsonBackReference(value="cliente-consultas")
	private Cliente cliente;
//	private String clienteName;
	
	public Consulta() {}
	public Consulta(Integer id) {this.id = id;}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
//	public String getMedicoName() {
//		return medico != null ? medico.getName() : "";
//	}
//	public String getClienteName() {
//		return cliente != null ? cliente.getName() : "";
//	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(dataConsulta);
		out.writeObject(status);
		out.writeObject(descricao);
		out.writeObject(medico);
		out.writeObject(cliente);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		dataConsulta = (String) in.readObject(); //serial date sql
		status = (Status) in.readObject();
		descricao = (String) in.readObject();
		medico = (Medico) in.readObject();
		cliente = (Cliente) in.readObject();
	}
	
	
}
