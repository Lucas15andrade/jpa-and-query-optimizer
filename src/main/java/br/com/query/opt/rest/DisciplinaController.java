package br.com.query.opt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.query.opt.dominio.Disciplina;
import br.com.query.opt.dominio.TipoDisciplina;
import br.com.query.repository.DisciplinaRepository;
import br.com.query.repository.TipoDisciplinaRepository;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	TipoDisciplinaRepository tipoRepository;

	@GetMapping(path = "/all", produces = "application/json")
	public Iterable<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Disciplina findById(@PathVariable("id") int id) {
		return disciplinaRepository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/countPorTipo", produces = "application/json")
	public List<Map<Integer,Integer>> countDisciplinaPorTipo() {
		return disciplinaRepository.countDisciplinasPorTipo();
	}
	
	@GetMapping(path = "/tipos", produces = "application/json")
	public Iterable<TipoDisciplina> findAllTipos() {
		return tipoRepository.findAll();
	}
}
