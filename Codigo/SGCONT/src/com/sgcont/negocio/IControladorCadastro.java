package com.sgcont.negocio;

import java.util.Collection;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.transferobject.EmpresaContabilTO;
import com.sgcont.transferobject.UsuarioTO;

/**
 * Interface do controlador responsável pelas regras de negócio do módulo de cadastro
 * */
public interface IControladorCadastro {

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.1.	Caso o usuário escolha Pessoa Física
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa física
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usuário escolha Pessoa Jurídica
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa jurídica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS004] - Verificar CPF inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistente(String cpf, String codigoCliente);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CNPJ inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj, String codigoCliente);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg, String codigoCliente);

	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarTituloEleitorExistente(String tituloEleitor, String codigoCliente);

	
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
	public EmpresaContabil pesquisarEmpresaContabil(String nome);
	
	/**
	 * [UC006] Inserir Contador 
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public void inserirContador(ContadorTO contadorTO);
	
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
	@SuppressWarnings("rawtypes")
	public Collection pesquisarDadosClienteParaCombo(Short indicadorUso) ;
	
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
	public ClienteTO pesquisarClienteTO(String nome);
	
	/**
	 * [UC005] Inserir Usuario 
	 * 
	 * Método responsável cadastrar um usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 * */
	public void inserirUsuario(UsuarioTO usuarioTO);
	
	/**
	 * [UC005] Inserir Usuário
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf);
	
	/**
	 * [UC003] Inserir Contador
	 *  
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf);
	
	/**
	 * [UC015] Inserir Empresa Contábil 
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Vivianne Sousa
	 * @since 20/05/2013
	 * */
	public void inserirEmpresaContabil(EmpresaContabilTO empresaContabilTO);
	
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
	public ClienteTO pesquisarDocumentoCliente(ClienteTO clienteTO);
	
	/**
	 * [UC005] Inserir Usuário
	 * 
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar USUARIO
	 * existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public Usuario verificarLoginUsuarioExistente(String login) ;
	
	/**
	* [UC004] ManterContador
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarContador(ContadorTO contadorTO);
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf, String codigoContador);
	
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS004] - Verificar numero CRC existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCRCExistenteContador(String crc, String codigoContador);
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * Método responsável pesquisar a colecao de cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 */
	public Collection<ClienteTO> pesquisarColecaoClienteTO();
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * Método responsável atualizar um cliente do tipo pessoa física
	 * 
	 * @author Vivianne Sousa
	 * @since 27/05/2013
	 * */
	public void atualizarClientePF(ClienteTO clienteTO);

	/**
	 * [UC002] Manter Cliente 
	 * 
	 * Método responsável atualizar um cliente do tipo pessoa jurídica
	 * 
	 * @author Vivianne Sousa
	 * @since 27/05/2013
	 * */
	public void atualizarClientePJ(ClienteTO clienteTO);
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 29/05/2013
	 * */
	public void removerCliente(Integer cdCliente);
	
	/**
	 * [UC006] Manter Usuario
	 * 
	 * Método responsável atualizar uma usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 * */
	public void atualizarUsuario(UsuarioTO usuarioTO);
	
	/**
	 * [UC006] Manter Usuario
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf, String codigoUsuario);
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String validaIndicadorResponsavel(String indicadorResponsavel,
			String codigoContador) ;
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
	public Collection<Usuario> pesquisarUsuarios(Integer codigoUsuario);
	
}

