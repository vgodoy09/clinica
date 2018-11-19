package br.com.clinica.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity 
@Table(name = "followup")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class FollowUp implements Externalizable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="followUpType_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private FollowUpType followUpType;
	@Column(name="[table]")
	private String table;
	@Column
	private Integer idTable;
	@Column
	private Integer registryUser;
	private LocalDate registryDate;
	private LocalTime registryTime;
	
	public FollowUp() {}
	public FollowUp(String description, FollowUpType followUpType, String table, Integer idTable, Integer registryUser, LocalDate registryDate, LocalTime registryTime) {
		this.description = description;
		this.followUpType = followUpType;
		this.table = table;
		this.idTable = idTable;
		this.registryUser = registryUser;
		this.registryDate = registryDate;
		this.registryTime = registryTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FollowUpType getFollowUpType() {
		return followUpType;
	}
	public void setFollowUpType_id(FollowUpType followUpType) {
		this.followUpType = followUpType;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public Integer getIdTable() {
		return idTable;
	}
	public void setIdTable(Integer idTable) {
		this.idTable = idTable;
	}
	public Integer getRegistryUser() {
		return registryUser;
	}
	public void setRegistryUser(Integer registryUser) {
		this.registryUser = registryUser;
	}
	public LocalDate getRegistryDate() {
		return registryDate;
	}
	public void setRegistryDate(LocalDate registryDate) {
		this.registryDate = registryDate;
	}
	public LocalTime getRegistryTime() {
		return registryTime;
	}
	public void setRegistryTime(LocalTime registryTime) {
		this.registryTime = registryTime;
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id               = (Integer) in.readObject();
		description      = (String) in.readObject();
		followUpType     = (FollowUpType) in.readObject();
		table            = (String) in.readObject();
		idTable          = (Integer) in.readObject();
		registryUser     = (Integer) in.readObject();
		registryDate     = (LocalDate) in.readObject();
		registryTime     = (LocalTime) in.readObject();
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(description);
		out.writeObject(followUpType);
		out.writeObject(table);
		out.writeObject(idTable);
		out.writeObject(registryUser);
		out.writeObject(registryDate);
		out.writeObject(registryTime);
	}
}
