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

@RestController
public class StateClient {

	@Autowired
	@Qualifier("paciente")
	private Map<Integer, Cliente> mapClient;
	
	
	@PostMapping("saveInMemory")
	public Boolean saveMemory(@RequestBody Cliente cliente) {
		mapClient.put(cliente.getId(), cliente);
		return true;
	}
	
	@GetMapping("getClientMemory/{id}")
	public Cliente getClient(@PathVariable("id") Integer id) {
		return mapClient.get(id);
	}
	
	
}
