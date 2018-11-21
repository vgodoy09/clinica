package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Consulta;

@Repository
public interface ConsultasRepository extends JpaRepository<Consulta, Integer> {

} 
