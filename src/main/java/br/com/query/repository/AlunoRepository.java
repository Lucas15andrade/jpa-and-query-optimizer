package br.com.query.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.query.opt.dominio.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>, PagingAndSortingRepository<Aluno, Integer> {

	
	@Query("from Aluno a left outer join fetch a.matriculas")
	public List<Aluno> findAllWithFetch(Pageable page);
	
	public List<AlunoProjection> findByNomeStartingWith(String nome, Pageable page);
	
}
