package com.sgcont.repositorio;

import org.hibernate.Session;

import com.sgcont.conexao.HibernateUtil;
import com.sgcont.dados.Usuario;

public class Repositorio implements IRepositorio {

	private static IRepositorio instance;

	public static IRepositorio getInstancia() {
		if (instance == null) {
			instance = new Repositorio();
		}
		return instance;
	}


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
		
		return usuario;
				
	}

}
