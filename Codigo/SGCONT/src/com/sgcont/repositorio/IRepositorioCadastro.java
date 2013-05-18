package com.sgcont.repositorio;

import java.util.Collection;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.transferobject.ClienteTO;

/**
 * Interface do reposit�rio respons�vel pelas consultas do m�dulo de cadastro
 * */
public interface IRepositorioCadastro {

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
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar os cliente cadastrados concatenando CPF / CNPJ e  nome 
	 * 
	 * @author R�mulo Aur�lio
	 * @since 07/05/2013
	 * 
	 * @return Usuario
	 * */
	public Collection pesquisarDadosClienteParaCombo();
	
	
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
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar os cliente  
	 * 
	 * @author R�mulo Aur�lio
	 * @since 07/05/2013
	 * 
	 * @return ClienteTO
	 * */
	public ClienteTO pesquisarClienteTO(String nome) ;
}
