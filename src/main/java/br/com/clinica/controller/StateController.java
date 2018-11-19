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
import br.com.clinica.model.State;
import br.com.clinica.repository.StateRepository;

@RestController 
@RequestMapping("/api")
public class StateController {
	
	@Autowired
	StateRepository stateRepository;
	
	// Get All states
	@GetMapping("/states")
	public List<State> getAllstates() {
	    return stateRepository.findAll();
	}
	
	// Create a new State
	@PostMapping("/states")
	public State createState(@Valid @RequestBody State state) {
	    return stateRepository.save(state);
	}
	
	// Get a Single State
	@GetMapping("/states/{id}")
	public State getStateById(@PathVariable(value = "id") Integer stateId) {
	    return stateRepository.findById(stateId)
	            .orElseThrow(() -> new ResourceNotFoundException("State", "id", stateId));
	}
	
	// Update a State
	@PutMapping("/states/{id}")
	public State updateState(@PathVariable(value = "id") Integer stateId,
	                                        @Valid @RequestBody State stateDetails) {

	    State state = stateRepository.findById(stateId)
	            .orElseThrow(() -> new ResourceNotFoundException("State", "id", stateId));

	    state.setName(stateDetails.getName());
//	    State.setUser(StateDetails.getUser());

	    State updatedState = stateRepository.save(state);
	    return updatedState;
	}
	
	// Delete a State
	@DeleteMapping("/states/{id}")
	public ResponseEntity<?> deleteState(@PathVariable(value = "id") Integer stateId) {
	    State State = stateRepository.findById(stateId)
	            .orElseThrow(() -> new ResourceNotFoundException("State", "id", stateId));

	    stateRepository.delete(State);

	    return ResponseEntity.ok().build();
	}
}
