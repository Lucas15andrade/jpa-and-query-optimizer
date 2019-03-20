package br.com.query.opt.rest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.query.opt.dominio.Aluno;
import br.com.query.opt.dominio.Curso;
import br.com.query.opt.dominio.Disciplina;
import br.com.query.opt.dominio.Matricula;
import br.com.query.opt.dominio.TipoDisciplina;
import br.com.query.repository.AlunoRepository;
import br.com.query.repository.DisciplinaRepository;
import br.com.query.repository.MatriculaRepository;

@RestController
@RequestMapping(path = "bootstrap")
public class StartupController {

	@Autowired
	EntityManager em;

	@Autowired
	DisciplinaRepository discRepository;
	
	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	MatriculaRepository matriculaRepository;
	
	@GetMapping(path = "tipoDisciplina")
	@Transactional
	public void tipoDisciplina() {

		TipoDisciplina t = new TipoDisciplina();
		t.setId(1);
		t.setNome("Disciplina");
		em.persist(t);

		TipoDisciplina t2 = new TipoDisciplina();
		t2.setId(2);
		t2.setNome("TCC");
		em.persist(t2);

	}

	@GetMapping(path = "disciplinas")
	public String disciplinas() {

		// gerando 100 disciplinas do tipo 1 e mais 100 do tipo 2

		TipoDisciplina t1 = new TipoDisciplina();
		t1.setId(1);

		TipoDisciplina t2 = new TipoDisciplina();
		t2.setId(2);

		for (int i = 0; i < 100; i++) {
			Disciplina d = new Disciplina();
			d.setId(i);
			d.setNome("Disciplina " + i);
			d.setTipo(t1);
			discRepository.save(d);

		}

		for (int i = 100; i < 200; i++) {
			Disciplina d = new Disciplina();
			d.setId(i);
			d.setNome("TCC " + i);
			d.setTipo(t2);
			discRepository.save(d);

		}

		return "200 disciplinas inseridas";

	}

	@GetMapping(path = "cursos")
	@Transactional
	public String cursos() {

		Curso c1 = new Curso();
		c1.setId(1);
		c1.setNome("Computação");
		em.persist(c1);

		Curso c2 = new Curso();
		c2.setId(2);
		c2.setNome("Eng. Elétrica");
		em.persist(c2);

		return "2 cursos inseridos";

	}

	@GetMapping(path = "alunos")
	public String alunos() {

		// Gerando 50 mil alunos e matriculando aleatoriamente em 5 disciplinas

		// Gerando 25 mil alunos de computação

		Curso computacao = new Curso();
		computacao.setId(1);

		Curso eletrica = new Curso();
		eletrica.setId(2);

		for (int i = 1; i <= 3000; i++) {

			Aluno a = new Aluno();
			a.setId(i);
			a.setCurso(computacao);
			a.setNome("Aluno " + i);
			alunoRepository.save(a);
			
			for ( int i2 = 0; i2 < 5; i2++ ) {
				
				Matricula m = new Matricula();
				m.setDisciplina(getRandom());
				m.setAluno(a);
				m.setAno(2019);
				m.setPeriodo(1);
				matriculaRepository.save(m);
			}
			

		}
		
		
		for (int i = 3001; i <= 6000; i++) {

			Aluno a = new Aluno();
			a.setId(i);
			a.setCurso(eletrica);
			a.setNome("Aluno " + i);
			alunoRepository.save(a);
			
			for ( int i2 = 0; i2 < 5; i2++ ) {
				
				Matricula m = new Matricula();
				m.setDisciplina(getRandom());
				m.setAluno(a);
				m.setAno(2019);
				m.setPeriodo(1);
				matriculaRepository.save(m);
			}
			

		}
		
		return "50 mil alunos gerados";

	}

	private Disciplina getRandom() {

		int id = (int) (Math.random() * 200);
		Disciplina d = new Disciplina();
		d.setId(id);
		return d;
	}

}
