package com.sgcont.fachada;

import java.util.Collection;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.negocio.ControladorCadastro;
import com.sgcont.negocio.ControladorUtil;
import com.sgcont.negocio.IControladorCadastro;
import com.sgcont.negocio.IControladorUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

public class Fachada {

	private static Fachada instance;

	private IControladorCadastro controladorCadastro;
	private IControladorUtil controladorUtil;
	
	public static synchronized Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		controladorCadastro = ControladorCadastro.getInstance();
		controladorUtil = ControladorUtil.getInstance();
	}
	

	/**
	 * M�todo gen�rico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		this.controladorUtil.inserirOuAtualizar(object);
	}

	/**
	 * M�todo gen�rico para remover um objeto.
	 * */
	public void remover(Object object) {
		this.controladorUtil.remover(object);
	}

	/**
	 * M�todo gen�rico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		return this.controladorUtil.pesquisar(classe);
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		return this.controladorUtil.pesquisar(classe, id);
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
		
		return this.controladorCadastro.pesquisarUsuario(login, senha);
		
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
		
		this.controladorCadastro.inserirClientePF(clienteTO, clientePessoaFisicaTO);
		
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
		
		this.controladorCadastro.inserirClientePJ(clienteTO, clientePessoaJuridicaTO);
		
	}
	
}
