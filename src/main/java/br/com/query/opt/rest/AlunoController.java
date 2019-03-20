package br.com.query.opt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.query.opt.dominio.Aluno;
import br.com.query.repository.AlunoProjection;
import br.com.query.repository.AlunoRepository;

@RestController
@RequestMapping("alunos")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;

	@GetMapping(path = "/all", produces = "application/json")
	public Iterable<Aluno> findAll(Pageable page) {
		Iterable<Aluno> it = alunoRepository.findAll(page);
		for (Aluno i : it) {
			i.setTotalMatriculas(i.getMatriculas().size());
		}
		return it;
	}

	@GetMapping(path = "/allFetch", produces = "application/json")
	public List<Aluno> findAllFetch(Pageable page) {
		List<Aluno> it = alunoRepository.findAllWithFetch(page);
		for (Aluno i : it) {
			i.setTotalMatriculas(i.getMatriculas().size());
		}
		return it;
	}

	@GetMapping(path = "/allByNome", produces = "application/json")
	public List<AlunoProjection> findAllProjection(@Param("nome") String nome, Pageable page) {
		return alunoRepository.findByNomeStartingWith(nome, page);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Aluno findById(@PathVariable("id") int id) {
		return alunoRepository.findById(id).orElse(null);
	}

}
