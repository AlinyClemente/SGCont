package com.sgcont.gui.cadastro;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
@ManagedBean (name="InserirClienteBean")
@SessionScoped
public class InserirClienteManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteTO clienteTO;
	
	private ClientePessoaFisicaTO clientePfTO;
	
	private ClientePessoaJuridicaTO clientePjTO;
	
	public InserirClienteManagedBean() {
		clienteTO = new ClienteTO();
		clientePfTO = new ClientePessoaFisicaTO();
		clientePjTO = new ClientePessoaJuridicaTO();
	}

	public ClienteTO getClienteTO() {
		return clienteTO;
	}

	public void setClienteTO(ClienteTO clienteTO) {
		this.clienteTO = clienteTO;
	}
	
	public ClientePessoaFisicaTO getClientePfTO() {
		return clientePfTO;
	}

	public void setClientePfTO(ClientePessoaFisicaTO clientePfTO) {
		this.clientePfTO = clientePfTO;
	}

	public ClientePessoaJuridicaTO getClientePjTO() {
		return clientePjTO;
	}

	public void setClientePjTO(ClientePessoaJuridicaTO clientePjTO) {
		this.clientePjTO = clientePjTO;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável por exibir a tela de cadastro do cliente 
	 * 
	 * @author Mariana Victor
	 * @since 11/04/2013
	 * */
	public String exibirInserirCliente() {
		
		return "inserir_cliente";
		
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável por cadastrar o cliente
	 * 
	 * @author Mariana Victor
	 * @since 11/04/2013
	 * */
	public void cadastrar() {
		//TODO
		
	}
	
	
}
