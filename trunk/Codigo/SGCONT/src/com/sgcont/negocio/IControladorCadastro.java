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
 * Interface do controlador respons�vel pelas regras de neg�cio do m�dulo de cadastro
 * */
public interface IControladorCadastro {

	/**
	 * [UC010] Efetuar Login
	 * 
	 * M�todo respons�vel pesquisar um usu�rio a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.1.	Caso o usu�rio escolha Pessoa F�sica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa f�sica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO, ClientePessoaFisicaTO clientePessoaFisicaTO);
	
	/**
	 * [UC001] Inserir Cliente 
	 * 2.1.2.	Caso o usu�rio escolha Pessoa Jur�dica
	 * 
	 * M�todo respons�vel cadastrar um cliente do tipo pessoa jur�dica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO, ClientePessoaJuridicaTO clientePessoaJuridicaTO);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS004] - Verificar CPF inv�lido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistente(String cpf, String codigoCliente);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CNPJ inv�lido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj, String codigoCliente);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg, String codigoCliente);

	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarTituloEleitorExistente(String tituloEleitor, String codigoCliente);

	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar um tipo de receita a partir do nome
	 * 
	 * @author R�mulo Aur�lio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return EmpresaContabil
	 * */
	public EmpresaContabil pesquisarEmpresaContabil(String nome);
	
	/**
	 * [UC006] Inserir Contador 
	 * 
	 * M�todo respons�vel cadastrar um contador
	 * 
	 * @author R�mulo Aur�lio
	 * @since 11/05/2013
	 * */
	public void inserirContador(ContadorTO contadorTO);
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar os cliente cadastrados concatenando CPF / CNPJ e  nome 
	 * 
	 * @author R�mulo Aur�lio
	 * @since 07/05/2013
	 * 
	 * @return Usuario
	 * */
	public Collection pesquisarDadosClienteParaCombo(Short indicadorUso) ;
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar os cliente  
	 * 
	 * @author R�mulo Aur�lio
	 * @since 07/05/2013
	 * 
	 * @return ClienteTO
	 * */
	public ClienteTO pesquisarClienteTO(String nome);
	
	/**
	 * [UC005] Inserir Usuario 
	 * 
	 * M�todo respons�vel cadastrar um usuario
	 * 
	 * @author R�mulo Aur�lio
	 * @since 21/05/2013
	 * */
	public void inserirUsuario(UsuarioTO usuarioTO);
	
	/**
	 * [UC005] Inserir Usu�rio
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CPF inv�lido
	 * 
	 * @author R�mulo Aur�lio
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf);
	
	/**
	 * [UC003] Inserir Contador
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CPF inv�lido
	 * 
	 * @author R�mulo Aur�lio
	 * @since 21/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf);
	
	/**
	 * [UC015] Inserir Empresa Cont�bil 
	 * 
	 * M�todo respons�vel cadastrar um contador
	 * 
	 * @author Vivianne Sousa
	 * @since 20/05/2013
	 * */
	public void inserirEmpresaContabil(EmpresaContabilTO empresaContabilTO);
	
	/**
	 * [UC014] Manter Despesa
	 * 
	 * M�todo respons�vel pesquisar o CPF / CNPJ do cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * 
	 * @return Usuario
	 * */
	public ClienteTO pesquisarDocumentoCliente(ClienteTO clienteTO);
	
	/**
	 * [UC005] Inserir Usu�rio
	 * 
	 * [FS0002] - Verificar exist�ncia de dados [FS004] - Verificar USUARIO
	 * existente
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 */
	public Usuario verificarLoginUsuarioExistente(String login) ;
	
	/**
	* [UC004] ManterContador
	 * 
	 * M�todo respons�vel atualizar uma receita
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 * */
	public void atualizarContador(ContadorTO contadorTO);
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar exist�ncia de dados [FS003] - Verificar CPF inv�lido
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf, String codigoContador);
	
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS004] - Verificar numero CRC existente
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 */
	public String verificarCRCExistenteContador(String crc, String codigoContador);
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel pesquisar a colecao de cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 */
	public Collection<ClienteTO> pesquisarColecaoClienteTO();
	
	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel atualizar um cliente do tipo pessoa f�sica
	 * 
	 * @author Vivianne Sousa
	 * @since 27/05/2013
	 * */
	public void atualizarClientePF(ClienteTO clienteTO);

	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel atualizar um cliente do tipo pessoa jur�dica
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
	 * M�todo respons�vel atualizar uma usuario
	 * 
	 * @author R�mulo Aur�lio
	 * @since 27/05/2013
	 * */
	public void atualizarUsuario(UsuarioTO usuarioTO);
	
	/**
	 * [UC006] Manter Usuario
	 * 
	 * [FS0002] - Verificar exist�ncia de dados [FS003] - Verificar CPF inv�lido
	 * 
	 * @author R�mulo Aur�lio
	 * @since 27/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf, String codigoUsuario);
	
	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar exist�ncia de dados [FS003] - Verificar CPF inv�lido
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 */
	public String validaIndicadorResponsavel(String indicadorResponsavel,
			String codigoContador) ;
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
	public Collection<Usuario> pesquisarUsuarios(Integer codigoUsuario);
	
}

