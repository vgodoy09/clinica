package br.com.clinica.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.model.Cliente;
import br.com.clinica.model.Consulta;
import br.com.clinica.model.Especialidade;
import br.com.clinica.model.Medico;

@RestController
public class StateClient {

	@Autowired
	@Qualifier("paciente")
	private Map<Integer, Cliente> mapClient;
	@Autowired
	@Qualifier("especialidade")
	private Map<Integer, Especialidade> mapEspecialidade;
	@Autowired
	@Qualifier("consulta")
	private Map<Integer, Consulta> mapConsulta;
	@Autowired
	@Qualifier("medico")
	private Map<Integer, Medico> mapMedico;
	
	
	
	@PostMapping("saveInMemoryCliente")
	public Boolean saveMemory(@RequestBody Cliente cliente) {
		mapClient.put(cliente.getId(), cliente);
		return true;
	}
	
	@GetMapping("getClientMemory/{id}")
	public Cliente getClient(@PathVariable("id") Integer id) {
		return mapClient.get(id);
	}
	
	@PostMapping("saveInMemoryEspecialidade")
	public Boolean saveMemoryEspecialidade(@RequestBody Especialidade especialidade) {
		mapEspecialidade.put(especialidade.getId(), especialidade);
		return true;
	}
	
	@GetMapping("getEspecialidadeMemory/{id}")
	public Especialidade getEspecialidade(@PathVariable("id") Integer id) {
		return mapEspecialidade.get(id);
	}
	
	@PostMapping("saveInMemoryConsulta")
	public Boolean saveMemoryConsulta(@RequestBody Consulta consulta) {
		mapConsulta.put(consulta.getId(), consulta);
		return true;
	}
	
	@GetMapping("getConsultaMemory/{id}")
	public Consulta getConsulta(@PathVariable("id") Integer id) {
		return mapConsulta.get(id);
	}
	
	@PostMapping("saveInMemoryMedico")
	public Boolean saveMemoryMedico(@RequestBody Medico medico) {
		mapMedico.put(medico.getId(), medico);
		return true;
	}
	
	@GetMapping("getMedicoMemory/{id}")
	public Medico getMedico(@PathVariable("id") Integer id) {
		Medico medico = mapMedico.get(id);
		return medico;
	}
	
	
}
