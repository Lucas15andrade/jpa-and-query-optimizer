package br.com.query.opt.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.query.App;

@Entity
@Table(schema = App.SCHEMA)
public class Curso {

	@Id
	private int id;
	private String nome;

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

}
