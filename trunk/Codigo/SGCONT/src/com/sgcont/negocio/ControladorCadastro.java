package com.sgcont.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Receita;
import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;
import com.sgcont.repositorio.IRepositorioCadastro;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioCadastro;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.transferobject.ReceitaTO;
import com.sgcont.util.Util;

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
		
		Cliente cliente = clienteTO.getCliente();
		ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaTO.getClientePessoaFisica();
		
		this.inserirCliente(cliente);
		
		clientePessoaFisica.setCliente(cliente);
		this.repositorioUtil.inserirOuAtualizar(clientePessoaFisica);
		
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
	 * [FS0002] - Verificar existência de dados
	 * [FS004] - Verificar CPF inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistente(String cpf) {
		String mensagem = null;
		
		if (!Util.validacaoCPF(cpf)) {
        	mensagem = "Dígito verificador do CPF não confere.";
        } else {
        	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) 
					Fachada.getInstance().pesquisar(ClientePessoaFisica.class, parametros);
			
			if (clientePessoaFisica != null) {
				 mensagem = "CPF já cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
			}
        }
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CNPJ inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj) {
		String mensagem = null;
		
		if (!Util.validacaoCNPJ(cnpj)) {
        	mensagem = "Dígito verificador do CNPJ não confere.";
        } else {
    		Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCnpj", cnpj);
			ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) 
					this.repositorioUtil.pesquisar(ClientePessoaJuridica.class, parametros);
			
			if (clientePessoaJuridica != null) {
				mensagem = "CNPJ já cadastrado para o Cliente " + clientePessoaJuridica.getCliente().getNome() + ".";
			}
	    }
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
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
			mensagem = "RG já cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
		}
		
		return mensagem;
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
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
			mensagem = "Título de Eleitor já cadastrado para o Cliente " + clientePessoaFisica.getCliente().getNome() + ".";
		}
		
		return mensagem;
	}



	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar um tipo de receita a partir do nome
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return TipoReceita
	 * */
	public TipoReceita pesquisarTipoReceita(String descricao) {
		
		return this.repositorioCadastro.pesquisarTipoReceita(descricao);
		
	}
	
	/**
	 * [UC003] Inserir Contador 
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public void inserirContador(ContadorTO contadorTO) {
		
		if(contadorTO != null){
			
			//contadorTO.setContador(contador);
			
			repositorioUtil.inserirOuAtualizar(contadorTO.getContador());
			
		}
		
		
	}
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente cadastrados concatenando CPF / CNPJ e  nome 
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return Usuario
	 * */
	public Collection pesquisarDadosClienteParaCombo() { 
		
		Collection<ClienteTO> colecaoClientesCombo = new ArrayList();

		Collection<?> retornoConsulta = null;
		
		try {
			
			retornoConsulta = repositorioCadastro.pesquisarDadosClienteParaCombo();
			
			if (retornoConsulta != null && !retornoConsulta.isEmpty()){
				
				Iterator<?> iterator = retornoConsulta.iterator();

				while (iterator.hasNext()) {

					ClienteTO clienteTO = new ClienteTO();
					
					Object[] objetoPesquisa = (Object[]) iterator.next();

					//Codigo
					if (objetoPesquisa[0] != null) {
						clienteTO.setCodigo(((Integer) objetoPesquisa[0]).toString());
					}

					//Nome 
					if (objetoPesquisa[1] != null) {
						clienteTO.setNome((String) objetoPesquisa[1]);
					}
					
					//Cpf
					if (objetoPesquisa[2] != null) {
						clienteTO.setCpf((String) objetoPesquisa[2]);
					}
					
					//Cnpf
					if (objetoPesquisa[3] != null) {
						clienteTO.setCnpj( ((String) objetoPesquisa[3]));
					}
					
					
					clienteTO.setarDadosClienteFormato();
					colecaoClientesCombo.add(clienteTO);
				}
			}			
			
			
			return colecaoClientesCombo;

		} catch (Exception e) {
			throw new ServiceException("erro.sistema",e );
		}
			
	}
	
	/**
	 * [UC011] Inserir Receita 
	 * 
	 * Método responsável cadastrar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO) {
		
		if(receitaTO != null){
			
			receitaTO.setReceita(receitaTO);
			
			Receita receita = receitaTO.getReceita();
			
			repositorioUtil.inserirOuAtualizar(receita);
			
		}
		
		
	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar um tipo de receita a partir do nome
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return EmpresaContabil
	 * */
	public EmpresaContabil pesquisarEmpresaContabil(String nome) {
		
		return this.repositorioCadastro.pesquisarEmpresaContabil(nome);
		
	}
	

}
