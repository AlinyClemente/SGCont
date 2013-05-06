package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.fachada.Fachada;
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
	
	private Collection<Profissao> colecaoProfissoes;
	
	private Collection<ClientePessoaFisica> colecaoClienteTitular;
	
	public InserirClienteManagedBean() {
		this.clienteTO = new ClienteTO();
		this.clientePfTO = new ClientePessoaFisicaTO();
		this.clientePjTO = new ClientePessoaJuridicaTO();
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

	public Collection<Profissao> getColecaoProfissoes() {
		return colecaoProfissoes;
	}

	public void setColecaoProfissoes(Collection<Profissao> colecaoProfissoes) {
		this.colecaoProfissoes = colecaoProfissoes;
	}

	public Collection<ClientePessoaFisica> getColecaoClienteTitular() {
		return colecaoClienteTitular;
	}

	public void setColecaoClienteTitular(
			Collection<ClientePessoaFisica> colecaoClienteTitular) {
		this.colecaoClienteTitular = colecaoClienteTitular;
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

		Fachada fachada = Fachada.getInstance();
		
		this.colecaoProfissoes = (Collection<Profissao>) 
				fachada.pesquisar(Profissao.class);
		
		this.colecaoClienteTitular = (Collection<ClientePessoaFisica>) 
				fachada.pesquisar(ClientePessoaFisica.class);
		
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
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();
		
		if (this.clienteTO.getIndicadorPessoaFisica().equals("1")) {
			fachada.inserirClientePF(this.clienteTO, this.clientePfTO);
		} else {
			fachada.inserirClientePJ(this.clienteTO, this.clientePjTO);
		}
		
		return "tela_sucesso";
		
	}
	
	
}
