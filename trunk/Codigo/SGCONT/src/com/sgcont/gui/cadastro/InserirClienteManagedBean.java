package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Contador;
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
	
	private Collection<ClientePessoaFisica> colecaoClienteTitular;
	
	private Collection<Profissao> colecaoProfissoes;
	
	private Collection<Contador> colecaoContador;
	
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

	public Collection<ClientePessoaFisica> getColecaoClienteTitular() {
		return colecaoClienteTitular;
	}

	public void setColecaoClienteTitular(
			Collection<ClientePessoaFisica> colecaoClienteTitular) {
		this.colecaoClienteTitular = colecaoClienteTitular;
	}

	public Collection<Profissao> getColecaoProfissoes() {
		return colecaoProfissoes;
	}

	public void setColecaoProfissoes(Collection<Profissao> colecaoProfissoes) {
		this.colecaoProfissoes = colecaoProfissoes;
	}
	
	public Collection<Contador> getColecaoContador() {
		return colecaoContador;
	}

	public void setColecaoContador(Collection<Contador> colecaoContador) {
		this.colecaoContador = colecaoContador;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável por filtrar os resultados da pesquisa do Cliente Titular
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<ClientePessoaFisica> completaClienteTitular(String query) {
		List<ClientePessoaFisica> sugestoes = new ArrayList<ClientePessoaFisica>();
		
		for (ClientePessoaFisica cliente : this.colecaoClienteTitular) {
			
			if (cliente.getCliente().getNome().toLowerCase().contains(query.toLowerCase())
					|| cliente.getNumeroCpf().toLowerCase().contains(query.toLowerCase())) {
				
				sugestoes.add(cliente);
			}
			
		}
		return sugestoes;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável por filtrar os resultados da pesquisa da Profissão
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<Profissao> completaProfissao(String query) {
		List<Profissao> sugestoes = new ArrayList<Profissao>();
		
		for (Profissao profissao : this.colecaoProfissoes) {
			
			if (profissao.getNomeProfissao().toLowerCase()
					.contains(query.toLowerCase())) {
				sugestoes.add(profissao);
			}
			
		}
		return sugestoes;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável por filtrar os resultados da pesquisa da Profissão
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<Contador> completaContador(String query) {
		List<Contador> sugestoes = new ArrayList<Contador>();
		
		for (Contador contador : this.colecaoContador) {
			
			if (contador.getNomeRazaoSocial().toLowerCase()
					.contains(query.toLowerCase())) {
				sugestoes.add(contador);
			}
			
		}
		return sugestoes;
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
		
		this.colecaoContador = (Collection<Contador>) 
				fachada.pesquisar(Contador.class);
		
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
