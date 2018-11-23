package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Medico;

@Repository 
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	@Query(value =
			"UPDATE `clinica`.`medico`     " +
			"SET                           " +
			"`date_birth` = ?1,            " +
			"`login` = ?2,                 " +
			"`name` = ?3,                  " +
			"`number_children` = ?4,       " +
			"`password` = ?5,              " +
			"`phone` = ?6,                 " +
			"`id_especialidade` = ?7,      " +
			"WHERE `id` = ?8			   ", nativeQuery=true)
	public void update(String dateBirth, String login, String name, Integer numberChildren, String password, String phone, Integer especialidade_id, Integer id);
}
