package br.com.query.opt.dominio;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.query.App;

@Entity
@Table(schema = App.SCHEMA)
@Cacheable
public class Disciplina {

	@Id
	private int id;
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoDisciplina tipo;
	
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

	public TipoDisciplina getTipo() {
		return tipo;
	}

	public void setTipo(TipoDisciplina tipo) {
		this.tipo = tipo;
	}

}
