package com.sgcont.negocio;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

/**
 * Interface do controlador responsável pelas regras de negócio do módulo de cadastro
 * */
public interface IControladorCadastro {

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.1.	Caso o usuário escolha Pessoa Física
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa física
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usuário escolha Pessoa Jurídica
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa jurídica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO);
	
	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável pesquisar um cliente a partir do nome
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
	 * Método responsável pesquisar uma profissão a partir do nome
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
	 * Método responsável pesquisar um contador a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return Contador
	 * */
	public Contador pesquisarContador(String nomeRazaoSocial);
	
}
