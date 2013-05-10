package com.sgcont.repositorio;

import org.hibernate.Session;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.Profissao;
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
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável pesquisar um cliente a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return ClientePessoaFisica
	 * */
	public ClientePessoaFisica pesquisarClientePF(String nome) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT clie "
				+ " FROM ClientePessoaFisica clie "
				+ " WHERE clie.cliente.nome = :nome ";
		
		ClientePessoaFisica clientePF = 
				(ClientePessoaFisica) session
					.createQuery(consulta)
	                .setParameter("nome", nome)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return clientePF;
				
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável pesquisar uma profissão a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return Profissao
	 * */
	public Profissao pesquisarProfissao(String nome) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT prof "
				+ " FROM Profissao prof "
				+ " WHERE prof.nomeProfissao = :nome ";
		
		Profissao profissao = 
				(Profissao) session
					.createQuery(consulta)
	                .setParameter("nome", nome)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return profissao;
				
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * Método responsável pesquisar um contador a partir do nome
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * 
	 * @param nome
	 * @return Contador
	 * */
	public Contador pesquisarContador(String nomeRazaoSocial) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT contd "
				+ " FROM Contador contd "
				+ " WHERE contd.nomeRazaoSocial = :nome ";
		
		Contador contador = 
				(Contador) session
					.createQuery(consulta)
	                .setParameter("nome", nomeRazaoSocial)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return contador;
				
	}

}
