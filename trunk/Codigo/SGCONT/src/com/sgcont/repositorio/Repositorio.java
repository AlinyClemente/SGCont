package com.sgcont.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;

import com.sgcont.conexao.Conexao;
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


	public Usuario pesquisarUsuarioHibernate(String login, String senha) {
		
		Session session = HibernateUtil.getSession();
		
		Usuario usuario = (Usuario) session.get(Usuario.class, 1);
		
		return usuario;
				
	}
	
	public Usuario pesquisarUsuario(String login, String senha) {

		Usuario usuario = new Usuario();
		
		try {
			
			Connection conexao = Conexao.getConnection();
			
			String query = "select * " +
					" from usuario " +
					" where login = ? " +
					"   and senha = ? "; 
			
			PreparedStatement preparedStatement = conexao.prepareStatement(query);
			preparedStatement.setString(1,login);
			preparedStatement.setString(2,senha);
			  
			ResultSet resultado = preparedStatement.executeQuery();

			if(resultado.next()) {
				usuario.setId(resultado.getInt(1));
				usuario.setLogin(resultado.getString(2));
				usuario.setSenha(resultado.getString(3));
			}
			
			resultado.close();
			preparedStatement.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
