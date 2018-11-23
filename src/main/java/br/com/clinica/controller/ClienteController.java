package br.com.clinica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.exception.ResourceNotFoundException;
import br.com.clinica.model.Cliente;
import br.com.clinica.repository.ClienteRepository;

@RestController 
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	// Get All clientes
	@GetMapping("/clientes")
	public List<Cliente> getAllclientes() {
	    return clienteRepository.findAll();
	}
	
	// Create a new Cliente
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
	    return clienteRepository.save(cliente);
	}
	
	// Get a Single Cliente
	@GetMapping("/clientes/{id}")
	public Cliente getClienteById(@PathVariable(value = "id") Integer clienteId) {
	    return clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
	}
	
	// Update a Cliente
	@PutMapping("/clientes/{id}")
	public Cliente updateCliente(@PathVariable(value = "id") Integer clienteId,
	                                        @Valid @RequestBody Cliente clienteDetails) {

	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));

	    cliente.setName(clienteDetails.getName());
	    cliente.setLogin(clienteDetails.getLogin());
	    cliente.setNumberChildren(clienteDetails.getNumberChildren());
	    cliente.setPassword(clienteDetails.getPassword());
	    cliente.setDateBirth(clienteDetails.getDateBirth());
	    cliente.setConvenio(clienteDetails.getConvenio());

	    Cliente updatedCliente = clienteRepository.save(cliente);
	    return updatedCliente;
	}
	
	// Delete a Cliente
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Integer clienteId) {
	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));

	    clienteRepository.delete(cliente);

	    return ResponseEntity.ok().build();
	}

}
