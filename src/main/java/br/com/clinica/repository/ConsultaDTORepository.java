package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.dto.ConsultaDTO;

@Repository
public interface ConsultaDTORepository extends JpaRepository<ConsultaDTO, Integer> {
	@Query(value = 
			"select                      " +
			"	u.id,                    " +
			"    u.date_birth,           " +
			"    u.login,                " +
			"    u.name,                 " +
			"    u.number_children,      " +
			"    u.password,             " +
			"    u.phone,                " +
			"    u.status                " +
			"from (	select               " +
			"			*            	 " +
			"		from cliente         " +
			"		union all            " +
			"		select               " +
			"			*            	 " +
			"		from medico)         " +
			"as u                        " +
			"where u.login = ?1          " +
			"	  and u.password = ?2    " +
			"      and status = 'ATIVO'  " 
	, nativeQuery=true)
	public ConsultaDTO login(String login, String password);
} 
