package br.com.query.opt.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.query.App;

@Entity
@Table(schema = App.SCHEMA)
public class Aluno {

	@Id
	private int id;
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	private Curso curso;

	@JsonIgnore
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	List<Matricula> matriculas;

	@Transient
	private int totalMatriculas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public int getTotalMatriculas() {
		return totalMatriculas;
	}

	public void setTotalMatriculas(int totalMatriculas) {
		this.totalMatriculas = totalMatriculas;
	}

}