package com.sgcont.negocio;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

/**
 * Interface do controlador respons�vel pelas regras de neg�cio do m�dulo de cadastro
 * */
public interface IControladorCadastro {

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
	 * 2.1.1.	Caso o usu�rio escolha Pessoa F�sica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa f�sica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usu�rio escolha Pessoa Jur�dica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa jur�dica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO);
	
}
