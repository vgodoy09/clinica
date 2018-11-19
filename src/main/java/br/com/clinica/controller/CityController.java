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
import br.com.clinica.model.City;
import br.com.clinica.repository.CityRepository;

@RestController 
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	// Get All cities
	@GetMapping("/cities")
	public List<City> getAllcities() {
	    return cityRepository.findAll();
	}
	
	// Create a new City
	@PostMapping("/cities")
	public City createCity(@Valid @RequestBody City city) {
	    return cityRepository.save(city);
	}
	
	// Get a Single City
	@GetMapping("/cities/{id}")
	public City getCityById(@PathVariable(value = "id") Integer cityId) {
	    return cityRepository.findById(cityId)
	            .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));
	}
	
	// Update a City
	@PutMapping("/cities/{id}")
	public City updateCity(@PathVariable(value = "id") Integer cityId,
	                                        @Valid @RequestBody City cityDetails) {

	    City city = cityRepository.findById(cityId)
	            .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

	    city.setName(cityDetails.getName());
//	    City.setUser(CityDetails.getUser());

	    City updatedCity = cityRepository.save(city);
	    return updatedCity;
	}
	
	// Delete a City
	@DeleteMapping("/cities/{id}")
	public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Integer cityId) {
	    City city = cityRepository.findById(cityId)
	            .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

	    cityRepository.delete(city);

	    return ResponseEntity.ok().build();
	}
}
