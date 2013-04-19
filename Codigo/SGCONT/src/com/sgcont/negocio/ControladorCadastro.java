package com.sgcont.negocio;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.repositorio.IRepositorioCadastro;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioCadastro;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

/**
 * Controlador responsável pelas regras de negócio do módulo de cadastro
 * */
public class ControladorCadastro implements IControladorCadastro {

	private static ControladorCadastro instance;

	protected IRepositorioCadastro repositorioCadastro = null;
	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorCadastro getInstance(){
		if (instance == null){
			instance = new ControladorCadastro();
		}
		return instance;
	}
	
	private ControladorCadastro() {

		repositorioCadastro = RepositorioCadastro.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();
		
	}

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha) {
		
		return this.repositorioCadastro.pesquisarUsuario(login, senha);
		
	}
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.1.	Caso o usuário escolha Pessoa Física
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa física
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO) {
		//TODO
	}
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usuário escolha Pessoa Jurídica
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa jurídica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO) {
		//TODO
	}
	
}
