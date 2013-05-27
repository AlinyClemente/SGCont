package com.sgcont.fachada;

import java.util.Collection;
import java.util.Map;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.negocio.ControladorAgenda;
import com.sgcont.negocio.ControladorCadastro;
import com.sgcont.negocio.ControladorUtil;
import com.sgcont.negocio.IControladorAgenda;
import com.sgcont.negocio.IControladorCadastro;
import com.sgcont.negocio.IControladorUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.util.CompromissoEvent;

public class Fachada {

	private static Fachada instance;

	private IControladorCadastro controladorCadastro;
	private IControladorUtil controladorUtil;
	private IControladorAgenda controladorAgenda;
	
	public static synchronized Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		controladorCadastro = ControladorCadastro.getInstance();
		controladorUtil = ControladorUtil.getInstance();
		controladorAgenda = ControladorAgenda.getInstance();
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
	 * M�todo gen�rico que retorna uma lista com objetos a partir dos valores passados como par�metros.
	 * */
	public Collection<?> pesquisarColecao(Class<?> classe, Map<String, Object> campos) {
		return this.controladorUtil.pesquisarColecao(classe, campos);
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		return this.controladorUtil.pesquisar(classe, id);
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir dos valores passados como par�metros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos) {
		
		return this.controladorUtil.pesquisar(classe, campos);
		
	}

	/**
	 * M�todo gen�rico para remover um objeto a partir dos valores passados como par�metros.
	 * */
	public void remover(Class<?> classe, Map<String, Object> campos) {
		
		this.controladorUtil.remover(classe, campos);
		
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
		
		return this.controladorCadastro.verificarCPFValidoExistente(cpf);
		
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
		
		return this.controladorCadastro.verificarCNPJValidoExistente(cnpj);
		
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
		
		return this.controladorCadastro.verificarRGExistente(rg);
		
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

		return this.controladorCadastro.verificarTituloEleitorExistente(tituloEleitor);
		
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
		
		return this.controladorCadastro.pesquisarUsuarios(codigoUsuario);
		
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar os compromissos a partir do usu�rio
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoUsuario
	 * @return Collection<Compromisso>
	 * */
	public Collection<Compromisso> pesquisarCompromisso(Integer codigoUsuario) {
		
		return this.controladorAgenda.pesquisarCompromisso(codigoUsuario);
		
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar os respons�veis a partir do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoCompromisso
	 * @return Collection<Usuario>
	 * */
	public Collection<Usuario> pesquisarResponsaveis(Integer codigoCompromisso) {
		
		return this.controladorAgenda.pesquisarResponsaveis(codigoCompromisso);
		
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel inserir ou atualizar o compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public Integer inserirOuAtualizarCompromisso(CompromissoEvent compromissoEvent, Usuario usuarioLogado) {
		
		return this.controladorAgenda.inserirOuAtualizarCompromisso(compromissoEvent, usuarioLogado);
		
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel inserir um compromisso recorrente
	 * 
	 * @author Mariana Victor
	 * @since 23/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public Compromisso inserirCompromissoRecorrente(Compromisso compromisso,
			CompromissoEvent compromissoEvent, Usuario usuarioLogado,
			Integer idCompromissoPrincipal) {
		
		return this.controladorAgenda.inserirCompromissoRecorrente(
				compromisso, compromissoEvent, usuarioLogado, idCompromissoPrincipal);
		
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel por remover um compromisso
	 * 
	 * @author Mariana Victor
	 * @since 26/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public void removerCompromisso(Compromisso compromisso) {
		
		this.controladorAgenda.removerCompromisso(compromisso);
		
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel mover o compromisso
	 * 
	 * @author Mariana Victor
	 * @since 26/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public void moverCompromisso(CompromissoEvent compromissoEvent) {
		this.controladorAgenda.moverCompromisso(compromissoEvent);
	}
	
}
