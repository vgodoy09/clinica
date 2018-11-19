package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {  

}
