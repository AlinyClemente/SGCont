package com.sgcont.repositorio;

import java.util.Collection;

import org.hibernate.Session;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.util.HibernateUtil;

/**
 * Repositório responsável pelas consultas do módulo de cadastro
 * */
public class RepositorioCadastro implements IRepositorioCadastro {

	private static IRepositorioCadastro instance;

	public static IRepositorioCadastro getInstancia() {
		if (instance == null) {
			instance = new RepositorioCadastro();
		}
		return instance;
	}

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * 
	 * @param login
	 * @param senha
	 * @return Usuario
	 * */
	public Usuario pesquisarUsuario(String login, String senha) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT usur "
				+ " FROM Usuario usur "
				+ " WHERE login = :login "
				+ "   and senha = :senha ";
		
		Usuario usuario = (Usuario) session
				.createQuery(consulta)
                .setParameter("login", login)
                .setParameter("senha", senha)
                .uniqueResult();

		HibernateUtil.closeSession(session);
				
		return usuario;
				
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
	@SuppressWarnings("unchecked")
	public Collection<Usuario> pesquisarUsuarios(Integer codigoUsuario) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT usur "
				+ " FROM Usuario usur "
				+ " WHERE usur.codigo <> :codigoUsuario ";
		
		Collection<Usuario> colecaoUsuario = (Collection<Usuario>) 
				session.createQuery(consulta)
	                .setParameter("codigoUsuario", codigoUsuario)
	                .list();

		HibernateUtil.closeSession(session);
				
		return colecaoUsuario;
				
	}

}
