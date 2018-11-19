package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> { 

}
