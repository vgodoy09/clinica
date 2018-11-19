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
import br.com.clinica.model.Country;
import br.com.clinica.repository.CountryRepository;

@RestController 
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;
	
	// Get All countries
	@GetMapping("/countries")
	public List<Country> getAllcountries() {
	    return countryRepository.findAll();
	}
	
	// Create a new Country
	@PostMapping("/countries")
	public Country createCountry(@Valid @RequestBody Country country) {
	    return countryRepository.save(country);
	}
	
	// Get a Single Country
	@GetMapping("/countries/{id}")
	public Country getCountryById(@PathVariable(value = "id") Integer countryId) {
	    return countryRepository.findById(countryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Country", "id", countryId));
	}
	
	// Update a Country
	@PutMapping("/countries/{id}")
	public Country updateCountry(@PathVariable(value = "id") Integer countryId,
	                                        @Valid @RequestBody Country countryDetails) {

	    Country country = countryRepository.findById(countryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Country", "id", countryId));

	    country.setName(countryDetails.getName());
//	    Country.setUser(CountryDetails.getUser());

	    Country updatedCountry = countryRepository.save(country);
	    return updatedCountry;
	}
	
	// Delete a Country
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable(value = "id") Integer countryId) {
	    Country country = countryRepository.findById(countryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Country", "id", countryId));

	    countryRepository.delete(country);

	    return ResponseEntity.ok().build();
	}
}
