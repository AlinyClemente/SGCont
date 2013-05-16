package com.sgcont.negocio;

import java.util.Collection;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.transferobject.ReceitaTO;

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
	public String verificarCPFValidoExistente(String cpf);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CNPJ inv�lido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj);
	
	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg);

	/**
	 * [UC001] Inserir Cliente
	 *  
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarTituloEleitorExistente(String tituloEleitor);

	/**
	 * [UC011] Inserir Receita 
	 * 
	 * M�todo respons�vel cadastrar uma receita
	 * 
	 * @author R�mulo Aur�lio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO);
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar um tipo de receita a partir do nome
	 * 
	 * @author R�mulo Aur�lio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return TipoReceita
	 * */
	public TipoReceita pesquisarTipoReceita(String descricao);
	
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
	public Collection pesquisarDadosClienteParaCombo() ;
}
