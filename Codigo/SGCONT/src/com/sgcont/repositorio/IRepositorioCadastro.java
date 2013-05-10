package com.sgcont.repositorio;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.Profissao;
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
	 * [UC001] Inserir Cliente
	 * 
	 * M�todo respons�vel pesquisar um cliente a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return ClientePessoaFisica
	 * */
	public ClientePessoaFisica pesquisarClientePF(String nome);

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * M�todo respons�vel pesquisar uma profiss�o a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return Profissao
	 * */
	public Profissao pesquisarProfissao(String nome);

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * M�todo respons�vel pesquisar um contador a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return Contador
	 * */
	public Contador pesquisarContador(String nomeRazaoSocial);
	
}
