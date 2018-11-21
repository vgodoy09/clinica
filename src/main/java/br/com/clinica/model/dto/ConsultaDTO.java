package br.com.clinica.model.dto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.clinica.model.enuns.Status;

@Entity 
public class ConsultaDTO implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="data_consulta")
	private LocalDate dataConsulta;
	@Column(name="descricao")
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
    private Status status;
	@Column(name="medico_name")
	private String medicoName;
	@Column(name="cliente_name")
	private String clienteName;
	
	public ConsultaDTO() {}
	public ConsultaDTO(Integer id) {this.id = id;}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(LocalDate dataConsulta) {
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
	public String getMedicoName() {
		return medicoName;
	}
	public void setMedicoName(String medicoName) {
		this.medicoName = medicoName;
	}
	public String getClienteName() {
		return clienteName;
	}
	public void setClienteName(String clienteName) {
		this.clienteName = clienteName;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(dataConsulta);
		out.writeObject(status);
		out.writeObject(descricao);
		out.writeObject(medicoName);
		out.writeObject(clienteName);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		dataConsulta = (LocalDate) in.readObject(); //serial date sql
		status = (Status) in.readObject();
		descricao = (String) in.readObject();
		medicoName = (String) in.readObject();
		clienteName = (String) in.readObject();
	}
	
	
}
