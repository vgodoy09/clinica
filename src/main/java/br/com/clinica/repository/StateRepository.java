package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> { 

}
