package com.usjt.sce;

import static org.junit.Assert.*;
import org.junit.Test;

import com.usjt.sce.model.ConfiguraDB;
import com.usjt.sce.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// cenario
		FabricaDeConexoes fabrica;
		// acao
		fabrica = new FabricaDeConexoes();
		// verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "aaaa"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com usuario invalido
	 * Pré-condição - o usuario valido e root
	 */
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root1";
		String senha = "a"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)");
		}
	}
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com usuario invalido
	 * Pré-condição - o usuario valido e root
	 */
	@Test
	public void quandoConectaComDriverInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
		String driver = "com.mysql.jdbc.Driver1";
		String usuario = "root";
		String senha = "alunofatec"; 
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.lang.ClassNotFoundException: com.mysql.jdbc.Driver1");
		}
	}
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com url invalida
	 * Pré-condição - a porta de acesso e 3306
	 */
	@Test
	public void quandoConectaComURLInvalida_SQLException() {
		// cenario
		String url = "jdbc1:mysql://localhost:3306/biblioteca?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = ""; 
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			//System.out.println("erro a ser reportado no assert ====>" + e.getMessage());
			assertEquals("java.sql.SQLException: No suitable driver found for jdbc1:mysql://localhost:3306/biblioteca?useSSL=false",
					e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}