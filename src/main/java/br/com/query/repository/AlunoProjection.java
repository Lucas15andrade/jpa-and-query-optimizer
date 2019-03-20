package br.com.query.repository;

/**
 * Projection interface 
 * @author gleydson
 *
 */
public interface AlunoProjection {

	String getNome();
	
	CursoInfo getCurso();
	
	interface CursoInfo {
		String getNome();
	}
}
