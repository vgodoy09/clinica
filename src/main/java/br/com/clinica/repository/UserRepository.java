package br.com.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {
	@Query(value = 
			"select                      " +
			"	 u.id,                   " +
			"    u.date_birth,           " +
			"    u.login,                " +
			"    u.name,                 " +
			"    u.number_children,      " +
			"    u.password,             " +
			"    u.phone,                " +
			"    u.status                " +
			"from (	select               " +
			"	       c.id,             " +
			"          c.date_birth,     " +
			"          c.login,          " +
			"          c.name,           " +
			"          c.number_children," +
			"          c.password,       " +
			"          c.phone,          " +
			"          c.status          " +
			"		from cliente c       " +
			"		union all            " +
			"		select               " +
			"	       m.id,             " +
			"          m.date_birth,     " +
			"          m.login,          " +
			"          m.name,           " +
			"          m.number_children," +
			"          m.password,       " +
			"          m.phone,          " +
			"          m.status          " +
			"		from medico m)       " +
			"as u                        " +
			"where u.login = ?1          " +
			"	  and u.password = ?2    " +
			"      and status = 'ATIVO'  " 
	, nativeQuery=true)
	public UserDTO login(String login, String password);
	
	@Query(value = 
					"		select               " +
					"	       m.id,             " +
					"          m.date_birth,     " +
					"          m.login,          " +
					"          m.name,           " +
					"          m.number_children," +
					"          m.password,       " +
					"          m.phone,          " +
					"          m.status          " +
					"		from medico m       "
					, nativeQuery=true)
	public List<UserDTO> getMedicos();
} 
