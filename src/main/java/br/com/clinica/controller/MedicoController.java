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
import br.com.clinica.model.Medico;
import br.com.clinica.repository.MedicoRepository;

@RestController
@RequestMapping("/api")
public class MedicoController {
	
	@Autowired
	MedicoRepository  medicoRepository;
	
	// Get All medicos
	@GetMapping("/medicos")
	public List<Medico> getAllmedicos() {
	    return medicoRepository.findAll();
	}
	
	// Create a new Medico
	@PostMapping("/medicos")
	public Medico createMedico(@RequestBody Medico medico) {
	    return medicoRepository.save(medico);
	}
	
	// Get a Single Medico
	@GetMapping("/medicos/{id}")
	public Medico getMedicoById(@PathVariable(value = "id") Integer medicoId) {
	    return medicoRepository.findById(medicoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", medicoId));
	}
	
	// Update a Medico
	@PutMapping("/medicos/{id}")
	public Medico updateMedico(@PathVariable(value = "id") Integer medicoId,
	                                        @Valid @RequestBody Medico medicoDetails) {
	    Medico medico = medicoRepository.findById(medicoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", medicoId));

	    medico.setName(medicoDetails.getName());
	    medico.setLogin(medicoDetails.getLogin());
	    medico.setNumberChildren(medicoDetails.getNumberChildren());
	    medico.setPassword(medicoDetails.getPassword());
	    medico.setDateBirth(medicoDetails.getDateBirth());
	    medico.setEspecialidade(medicoDetails.getEspecialidade());
	    Medico updatedMedico = medicoRepository.save(medico);
	    return updatedMedico;
	}
	
	// Delete a Medico
	@DeleteMapping("/medicos/{id}")
	public ResponseEntity<?> deleteMedico(@PathVariable(value = "id") Integer medicoId) {
	    Medico medico = medicoRepository.findById(medicoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", medicoId));

	    medicoRepository.delete(medico);

	    return ResponseEntity.ok().build();
	}

}
