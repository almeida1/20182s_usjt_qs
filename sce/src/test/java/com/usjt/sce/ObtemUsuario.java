package com.usjt.sce;

import com.usjt.sce.model.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario aluno = new Usuario();
		aluno.setRa("121212");
		aluno.setNome("Jose Carlos");
		return aluno;
	}
}