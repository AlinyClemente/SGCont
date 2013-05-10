package com.sgcont.negocio;

import java.util.Date;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.repositorio.IRepositorioCadastro;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioCadastro;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

/**
 * Controlador respons�vel pelas regras de neg�cio do m�dulo de cadastro
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
	 * M�todo respons�vel pesquisar um usu�rio a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha) {
		
		return this.repositorioCadastro.pesquisarUsuario(login, senha);
		
	}
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.1.	Caso o usu�rio escolha Pessoa F�sica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa f�sica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO) {
		
		Cliente cliente = clienteTO.getCliente();
		
		cliente.setUltimaAlteracao(new Date());
		cliente.setIndicadorUso(new Short("1"));
		
		this.repositorioUtil.inserirOuAtualizar(cliente);
		
		ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaTO.getClientePessoaFisica();
		clientePessoaFisica.setCliente(cliente);
		
		this.repositorioUtil.inserirOuAtualizar(clientePessoaFisica);
		
	}
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usu�rio escolha Pessoa Jur�dica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa jur�dica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO) {
		
		Cliente cliente = clienteTO.getCliente();
		
		cliente.setUltimaAlteracao(new Date());
		cliente.setIndicadorUso(new Short("1"));
		
		this.repositorioUtil.inserirOuAtualizar(cliente);
		
		ClientePessoaJuridica clientePessoaJuridica = clientePessoaJuridicaTO.getClientePessoaJuridica();
		clientePessoaJuridica.setCliente(cliente);
		
		this.repositorioUtil.inserirOuAtualizar(clientePessoaJuridica);
		
	}
	
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
	public ClientePessoaFisica pesquisarClientePF(String nome) {
		
		return this.repositorioCadastro.pesquisarClientePF(nome);
		
	}

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
	public Profissao pesquisarProfissao(String nome) {
		
		return this.repositorioCadastro.pesquisarProfissao(nome);
		
	}

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
	public Contador pesquisarContador(String nomeRazaoSocial) {
		
		return this.repositorioCadastro.pesquisarContador(nomeRazaoSocial);
		
	}
	
}
