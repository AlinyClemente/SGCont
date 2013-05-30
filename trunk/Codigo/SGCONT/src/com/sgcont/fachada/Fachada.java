package com.sgcont.fachada;

import java.util.Collection;
import java.util.Map;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.negocio.ControladorAgenda;
import com.sgcont.negocio.ControladorCadastro;
import com.sgcont.negocio.ControladorOperacional;
import com.sgcont.negocio.ControladorUtil;
import com.sgcont.negocio.IControladorAgenda;
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
import com.sgcont.util.CompromissoEvent;

public class Fachada {

	private static Fachada instance;

	private IControladorCadastro controladorCadastro;
	private IControladorUtil controladorUtil;
	private IControladorOperacional controladorOperacional;
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
		controladorOperacional = ControladorOperacional.getInstance();
		controladorAgenda = ControladorAgenda.getInstance();
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
	 * Método genérico que retorna uma lista com objetos a partir dos valores passados como parâmetros.
	 * */
	public Collection<?> pesquisarColecao(Class<?> classe, Map<String, Object> campos) {
		return this.controladorUtil.pesquisarColecao(classe, campos);
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
	 * Método responsável cadastrar um cliente do tipo pessoa Jurídica
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
	public String verificarCPFValidoExistente(String cpf, String codigoCliente) {
		
		return this.controladorCadastro.verificarCPFValidoExistente(cpf, codigoCliente);
		
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
	public String verificarCNPJValidoExistente(String cnpj, String codigoCliente) {
		
		return this.controladorCadastro.verificarCNPJValidoExistente(cnpj, codigoCliente);
		
	}
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg, String codigoCliente) {
		
		return this.controladorCadastro.verificarRGExistente(rg,codigoCliente);
		
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
	public String verificarTituloEleitorExistente(String tituloEleitor, String codigoCliente) {

		return this.controladorCadastro.verificarTituloEleitorExistente(tituloEleitor, codigoCliente);
		
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
	public Collection pesquisarDadosClienteParaCombo(Short indicadorUso) {
		
		return this.controladorCadastro.pesquisarDadosClienteParaCombo(indicadorUso);
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
	 * [UC005] Inserir usuário
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
	 * [UC005] Inserir usuário
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
	 * [UC012] Manter Receita 
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarReceita(ReceitaTO receitaTO) {
		this.controladorOperacional.atualizarReceita(receitaTO);
	}
	
	
	/**
	 * [UC004] ManterContador
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarContador(ContadorTO contadorTO) {
		this.controladorCadastro.atualizarContador(contadorTO);
	}

	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf, String codigoContador) {
		return  this.controladorCadastro.verificarCPFValidoExistenteContador(cpf, codigoContador);
	}
	
	
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS004] - Verificar numero CRC existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCRCExistenteContador(String crc, String codigoContador){
		return  this.controladorCadastro.verificarCRCExistenteContador(crc, codigoContador);
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
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel atualizar um cliente do tipo pessoa f�sica
	 * 
	 * @author Vivianne Sousa
	 * @since 27/05/2013
	 * */
	public void atualizarClientePF(ClienteTO clienteTO){
		
		this.controladorCadastro.atualizarClientePF(clienteTO);
	}
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel atualizar um cliente do tipo pessoa jur�dica
	 * 
	 * @author Vivianne Sousa
	 * @since 27/05/2013
	 * */
	public void atualizarClientePJ(ClienteTO clienteTO){
		
		this.controladorCadastro.atualizarClientePJ(clienteTO);
	}
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 29/05/2013
	 * */
	public void removerCliente(Integer cdCliente){
		this.controladorCadastro.removerCliente(cdCliente);
	}
	
	/**
	 * [UC006] Manter Usuario
	 * 
	 * Método responsável atualizar uma usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 * */
	public void atualizarUsuario(UsuarioTO usuarioTO) {
		this.controladorCadastro.atualizarUsuario(usuarioTO);
	}
	
	/**
	 * [UC006] Manter Usuario
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf, String codigoUsuario) {
		return  this.controladorCadastro.verificarCPFValidoExistenteUsuario(cpf, codigoUsuario);
	}
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String validaIndicadorResponsavel(String indicadorResponsavel,
			String codigoContador){
		return  this.controladorCadastro.validaIndicadorResponsavel(indicadorResponsavel, codigoContador);
	}
	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável pesquisar os usuários
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
	 * Método responsável pesquisar os compromissos a partir do usuário
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
	 * Método responsável pesquisar os responsáveis a partir do compromisso
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
	 * Método responsável inserir ou atualizar o compromisso
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
	 * Método responsável inserir um compromisso recorrente
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
	 * Método responsável por remover um compromisso
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
	 * Método responsável mover o compromisso
	 * 
	 * @author Mariana Victor
	 * @since 26/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public void moverCompromisso(CompromissoEvent compromissoEvent) {
		this.controladorAgenda.moverCompromisso(compromissoEvent);
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável pesquisar os lembretes que ainda não foram enviados por email
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	public Collection<Object[]> pesquisarLembretesPendentes() {
		
		return this.controladorAgenda.pesquisarLembretesPendentes();
		
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável pesquisar os dados do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	public Collection<Object[]> pesquisarCompromissoResponsaveis(Integer codigoCompromisso) {
		
		return this.controladorAgenda.pesquisarCompromissoResponsaveis(codigoCompromisso);
		
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável por atualizar o lembrete
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @parm codigoLembrete
	 * */
	public void atualizarLembretePendente(Integer codigoLembrete) {
		
		this.controladorAgenda.atualizarLembretePendente(codigoLembrete);
		
	}
	
}
