package com.sgcont.repositorio;

import com.sgcont.dados.cadastro.Usuario;

/**
 * Interface do repositório responsável pelas consultas do módulo de cadastro
 * */
public interface IRepositorioCadastro {

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha);
	
}
