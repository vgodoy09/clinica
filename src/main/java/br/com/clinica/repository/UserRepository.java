package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

} 
