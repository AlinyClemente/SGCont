package com.sgcont.repositorio;

import java.util.Collection;

import com.sgcont.dados.cadastro.Usuario;

/**
 * Interface do reposit�rio respons�vel pelas consultas do m�dulo de cadastro
 * */
public interface IRepositorioCadastro {

	/**
	 * [UC010] Efetuar Login
	 * 
	 * M�todo respons�vel pesquisar um usu�rio a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha);

	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar os usu�rios
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoUsuario
	 * @return Collection<Usuario>
	 * */
	public Collection<Usuario> pesquisarUsuarios(Integer codigoUsuario);
	
}
