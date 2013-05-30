package com.sgcont.repositorio;

import java.util.Collection;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.transferobject.ClienteTO;

/**
 * Interface do repositório responsável pelas consultas do módulo de cadastro
 * */
public interface IRepositorioCadastro {

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
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente cadastrados concatenando CPF / CNPJ e  nome 
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return Usuario
	 * */
	public Collection pesquisarDadosClienteParaCombo();

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
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente  
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return ClienteTO
	 * */
	public ClienteTO pesquisarClienteTO(String nome) ;
	
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
	public Object[] pesquisarCpfCnpjCliente(Integer cdCliente);
}
