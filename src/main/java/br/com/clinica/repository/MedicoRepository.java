package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Medico;

@Repository 
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
