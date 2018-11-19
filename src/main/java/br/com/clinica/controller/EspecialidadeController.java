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
import br.com.clinica.model.Especialidade;
import br.com.clinica.repository.EspecialidadeRepository;

@RestController 
@RequestMapping("/api")
public class EspecialidadeController {
	
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	
	// Get All especialidades
	@GetMapping("/especialidades")
	public List<Especialidade> getAllespecialidades() {
	    return especialidadeRepository.findAll();
	}
	
	// Create a new Especialidade
	@PostMapping("/especialidades")
	public Especialidade createEspecialidade(@Valid @RequestBody Especialidade especialidade) {
	    return especialidadeRepository.save(especialidade);
	}
	
	// Get a Single Especialidade
	@GetMapping("/especialidades/{id}")
	public Especialidade getEspecialidadeById(@PathVariable(value = "id") Integer especialidadeId) {
	    return especialidadeRepository.findById(especialidadeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Especialidade", "id", especialidadeId));
	}
	
	// Update a Especialidade
	@PutMapping("/especialidades/{id}")
	public Especialidade updateEspecialidade(@PathVariable(value = "id") Integer especialidadeId,
	                                        @Valid @RequestBody Especialidade especialidadeDetails) {

	    Especialidade especialidade = especialidadeRepository.findById(especialidadeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Especialidade", "id", especialidadeId));

	    especialidade.setName(especialidadeDetails.getName());

	    Especialidade updatedEspecialidade = especialidadeRepository.save(especialidade);
	    return updatedEspecialidade;
	}
	
	// Delete a Especialidade
	@DeleteMapping("/especialidades/{id}")
	public ResponseEntity<?> deleteEspecialidade(@PathVariable(value = "id") Integer especialidadeId) {
	    Especialidade especialidade = especialidadeRepository.findById(especialidadeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Especialidade", "id", especialidadeId));

	    especialidadeRepository.delete(especialidade);

	    return ResponseEntity.ok().build();
	}

}
