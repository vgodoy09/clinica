package br.com.clinica.model.dto;

import java.util.List;

import br.com.clinica.model.Cliente;
import br.com.clinica.model.Medico;

public class Wrapper {
	private List<Medico> medicos;
	private List<Cliente> clientes;
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}	
}
