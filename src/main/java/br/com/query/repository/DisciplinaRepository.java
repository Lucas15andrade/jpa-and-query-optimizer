package br.com.query.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.query.App;
import br.com.query.opt.dominio.Disciplina;

public interface DisciplinaRepository  extends CrudRepository<Disciplina, Integer>{

	@Query(value = "SELECT TIPO_ID, COUNT(ID) FROM " + App.SCHEMA + ".DISCIPLINA GROUP BY TIPO_ID ORDER BY TIPO_ID", nativeQuery = true)
	public List<Map<Integer,Integer>> countDisciplinasPorTipo();
	
}
