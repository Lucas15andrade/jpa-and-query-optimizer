package br.com.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.query.opt.dominio.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Integer>{

	@Query("select m from Matricula m where m.disciplina.id = :disciplina")
	public List<Matricula> findByDisciplina(@Param("disciplina") int idDisciplina);
	
	@Query("select m from Matricula m where m.aluno.id = :aluno")
	public List<Matricula> findByAluno(@Param("aluno") int idDisciplina);
  
	
}
