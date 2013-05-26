package com.sgcont.fachada;

import java.util.Collection;
import java.util.Map;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.negocio.ControladorCadastro;
import com.sgcont.negocio.ControladorOperacional;
import com.sgcont.negocio.ControladorUtil;
import com.sgcont.negocio.IControladorCadastro;
import com.sgcont.negocio.IControladorOperacional;
import com.sgcont.negocio.IControladorUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.transferobject.DespesaTO;
import com.sgcont.transferobject.EmpresaContabilTO;
import com.sgcont.transferobject.ReceitaTO;
import com.sgcont.transferobject.UsuarioTO;

public class Fachada {

	private static Fachada instance;

	private IControladorCadastro controladorCadastro;
	private IControladorUtil controladorUtil;
	private IControladorOperacional controladorOperacional;
	
	public static synchronized Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		controladorCadastro = ControladorCadastro.getInstance();
		controladorUtil = ControladorUtil.getInstance();
		controladorOperacional = ControladorOperacional.getInstance();
	}
	

	/**
	 * Método genérico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		this.controladorUtil.inserirOuAtualizar(object);
	}

	/**
	 * Método genérico para remover um objeto.
	 * */
	public void remover(Object object) {
		this.controladorUtil.remover(object);
	}

	/**
	 * Método genérico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		return this.controladorUtil.pesquisar(classe);
	}

	/**
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		return this.controladorUtil.pesquisar(classe, id);
	}

	/**
	 * Método genérico que retorna um objeto a partir dos valores passados como parâmetros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos) {
		
		return this.controladorUtil.pesquisar(classe, campos);
		
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
		
		return this.controladorCadastro.pesquisarUsuario(login, senha);
		
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
		
		this.controladorCadastro.inserirClientePF(clienteTO, clientePessoaFisicaTO);
		
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
		
		this.controladorCadastro.inserirClientePJ(clienteTO, clientePessoaJuridicaTO);
		
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
		
		return this.controladorCadastro.verificarCPFValidoExistente(cpf);
		
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
		
		return this.controladorCadastro.verificarCNPJValidoExistente(cnpj);
		
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
		
		return this.controladorCadastro.verificarRGExistente(rg);
		
	}
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável pesquisar um tipo de despesa a partir da descrição
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * 
	 * @param descrição
	 * @return TipoDespesa
	 * */
	public TipoDespesa pesquisarTipoDespesa(String descricao){
		
		return this.controladorOperacional.pesquisarTipoDespesa(descricao);
		
	}
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável cadastrar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 14/05/2013
	 * */
	public void inserirDespesa(DespesaTO despesaTO){
		
		 this.controladorOperacional.inserirDespesa(despesaTO);
		
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

		return this.controladorCadastro.verificarTituloEleitorExistente(tituloEleitor);
		
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
	public EmpresaContabil pesquisarEmpresaContabil(String nome){
		
		return this.controladorCadastro.pesquisarEmpresaContabil(nome);
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
		
		return this.controladorOperacional.pesquisarTipoReceita(descricao);
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
		
		this.controladorCadastro.inserirContador(contadorTO);
		
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
		
		this.controladorOperacional.inserirReceita(receitaTO);
		
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
		
		return this.controladorCadastro.pesquisarDadosClienteParaCombo();
	}

	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente  
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return ClienteTO
	 * */
	public ClienteTO pesquisarClienteTO(String nome){
		
		return this.controladorCadastro.pesquisarClienteTO(nome);
	}

	/**
	 * [UC005] Inserir Usuario 
	 * 
	 * Método responsável cadastrar um usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 * */
	public void inserirUsuario(UsuarioTO usuarioTO){
		this.controladorCadastro.inserirUsuario(usuarioTO);
	}

	
	/**
	 * [UC015] Inserir Empresa Contábil 
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Vivianne Sousa
	 * @since 20/05/2013
	 * */
	public void inserirEmpresaContabil(EmpresaContabilTO empresaContabilTO){
		
		this.controladorCadastro.inserirEmpresaContabil(empresaContabilTO);
	
	}
	
	/**
	 * [UC003] Inserir Contador
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf) {
		
		return this.controladorCadastro.verificarCPFValidoExistenteContador(cpf);
		
	}
	
	/**
	 * [UC005] Inserir Usuário
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf){
		return this.controladorCadastro.verificarCPFValidoExistenteUsuario(cpf);
	}
	
	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável pesquisar o CPF / CNPJ do cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * 
	 * @return Usuario
	 * */
	public ClienteTO pesquisarDocumentoCliente(ClienteTO clienteTO){
		return this.controladorCadastro.pesquisarDocumentoCliente(clienteTO);
	}
	
	/**
	 * [UC005] Inserir Usuário
	 * 
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar USUARIO
	 * existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public Usuario verificarLoginUsuarioExistente(String login) {
		return this.controladorCadastro.verificarLoginUsuarioExistente(login);
	}
	
	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável atualizar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public void atualizarDespesa(DespesaTO despesaTO){
		
		this.controladorOperacional.atualizarDespesa(despesaTO);
	
	}
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * Método responsável pesquisar a colecao de cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 */
	public Collection<ClienteTO> pesquisarColecaoClienteTO(){
		
		return this.controladorCadastro.pesquisarColecaoClienteTO();
	}
	
	/**
	* Método genérico para remover um objeto a partir dos valores passados como parâmetros.
	* */
	public void remover(Class<?> classe, Map<String, Object> campos){
		
		this.controladorUtil.remover(classe, campos);
		
	}
}
