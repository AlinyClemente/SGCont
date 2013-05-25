package com.sgcont.negocio;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;
import com.sgcont.repositorio.IRepositorioCadastro;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioCadastro;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.util.Util;

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
		ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaTO.getClientePessoaFisica();
		
		this.inserirCliente(cliente);
		
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
		ClientePessoaJuridica clientePessoaJuridica = clientePessoaJuridicaTO.getClientePessoaJuridica();
		
		this.inserirCliente(cliente);
		
		clientePessoaJuridica.setCliente(cliente);
		this.repositorioUtil.inserirOuAtualizar(clientePessoaJuridica);
			
	}

	private void inserirCliente(Cliente cliente) {
		cliente.getEndereco().setUltimaAlteracao(new Date());
		this.repositorioUtil.inserirOuAtualizar(cliente.getEndereco());
		
		cliente.setUltimaAlteracao(new Date());
		cliente.setIndicadorUso(new Short("1"));
		this.repositorioUtil.inserirOuAtualizar(cliente);
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS004] - Verificar CPF inv�lido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistente(String cpf) {
		String mensagem = null;
		
		if (!Util.validacaoCPF(cpf)) {
        	mensagem = "D�gito verificador do CPF n�o confere.";
        } else {
        	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) 
					Fachada.getInstance().pesquisar(ClientePessoaFisica.class, parametros);
			
			if (clientePessoaFisica != null) {
				 mensagem = "CPF j� cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
			}
        }
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CNPJ inv�lido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj) {
		String mensagem = null;
		
		if (!Util.validacaoCNPJ(cnpj)) {
        	mensagem = "D�gito verificador do CNPJ n�o confere.";
        } else {
    		Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCnpj", cnpj);
			ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) 
					this.repositorioUtil.pesquisar(ClientePessoaJuridica.class, parametros);
			
			if (clientePessoaJuridica != null) {
				mensagem = "CNPJ j� cadastrado para o Cliente " + clientePessoaJuridica.getCliente().getNome() + ".";
			}
	    }
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg) {
		String mensagem = null;
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numeroRg", rg);
		ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) 
				this.repositorioUtil.pesquisar(ClientePessoaFisica.class, parametros);
		
		if (clientePessoaFisica != null) {
			mensagem = "RG j� cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
		}
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarTituloEleitorExistente(String tituloEleitor) {
		String mensagem = null;
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numeroTituloEleitor", tituloEleitor);
		ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) 
				this.repositorioUtil.pesquisar(ClientePessoaFisica.class, parametros);
		
		if (clientePessoaFisica != null) {
			mensagem = "T�tulo de Eleitor j� cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
		}
		
		return mensagem;
	}
	
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
	public Collection<Usuario> pesquisarUsuarios(Integer codigoUsuario) {
		
		return this.repositorioCadastro.pesquisarUsuarios(codigoUsuario);
		
	}
	
}
