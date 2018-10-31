package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.Livro;

public class UC01CadastrarLivro {

	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02cadastrarLivroComISBN_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setIsbn("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	@Test
	public void CT03cadastrarLivroComISBN_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setIsbn(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarLivro_com_sucesso() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		livro.setIsbn("1111");
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	
	
	
	
}
