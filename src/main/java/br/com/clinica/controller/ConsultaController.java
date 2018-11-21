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
import br.com.clinica.model.Consulta;
import br.com.clinica.repository.ConsultasRepository;

@RestController 
@RequestMapping("/api")
public class ConsultaController {
	
	@Autowired
	ConsultasRepository consultasRepository;
	
	// Get All consultas
	@GetMapping("/consultas")
	public List<Consulta> getAllconsultas() {
	    return consultasRepository.findAll();
	}
	
	// Create a new Consulta
	@PostMapping("/consultas")
	public Consulta createConsulta(@Valid @RequestBody Consulta consulta) {
	    return consultasRepository.save(consulta);
	}
	
	// Get a Single Consulta
	@GetMapping("/consultas/{id}")
	public Consulta getConsultaById(@PathVariable(value = "id") Integer consultaId) {
	    return consultasRepository.findById(consultaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", consultaId));
	}
	
	// Update a Consulta
	@PutMapping("/consultas/{id}")
	public Consulta updateConsulta(@PathVariable(value = "id") Integer consultaId,
	                                        @Valid @RequestBody Consulta consultaDetails) {

	    Consulta consulta = consultasRepository.findById(consultaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", consultaId));

	    consulta.setDataConsulta(consultaDetails.getDataConsulta());
	    consulta.setDescricao(consultaDetails.getDescricao());
	    consulta.setStatus(consultaDetails.getStatus());
	    consulta.setMedico(consultaDetails.getMedico());
	    consulta.setCliente(consultaDetails.getCliente());

	    Consulta updatedConsulta = consultasRepository.save(consulta);
	    return updatedConsulta;
	}
	
	// Delete a Consulta
	@DeleteMapping("/consultas/{id}")
	public ResponseEntity<?> deleteConsulta(@PathVariable(value = "id") Integer consultaId) {
	    Consulta consulta = consultasRepository.findById(consultaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", consultaId));

	    consultasRepository.delete(consulta);

	    return ResponseEntity.ok().build();
	}

}
