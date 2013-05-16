package com.sgcont.repositorio;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Receita;
import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.util.HibernateUtil;

/**
 * Reposit�rio respons�vel pelas consultas do m�dulo de cadastro
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
	 * M�todo respons�vel pesquisar um usu�rio a partir do login e da senha
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
	public TipoReceita pesquisarTipoReceita(String descricao) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT tipoReceita "
				+ " FROM TipoReceita tipoReceita "
				+ " WHERE tipoReceita.descricao = :descricao ";
		
		TipoReceita tipoReceita = 
				(TipoReceita) session
					.createQuery(consulta)
	                .setParameter("descricao", descricao)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return tipoReceita;
				
	}
	
	
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
	public EmpresaContabil pesquisarEmpresaContabil(String nome) {
		
		
	Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT empresaContabil "
				+ " FROM EmpresaContabil empresaContabil "
				+ " WHERE empresaContabil.nomeFantasia = :nome ";
		
		EmpresaContabil empresaContabil = 
				(EmpresaContabil) session
					.createQuery(consulta)
	                .setParameter("nome", nome)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return empresaContabil;
	}
	
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
	public Collection pesquisarDadosClienteParaCombo() {
		
		Session session = HibernateUtil.getSession();
		
		Collection retorno = null;
		
		String consulta = "SELECT clie.cdcliente as codigo, " 
				+ "clie.nmcliente as nomeCliente, "
				+ " clipf.nncpf as cpf,  "
				+ " clipj.cnpj as cnpj "
				+ " FROM cadastro.cliente clie "
				+ " LEFT JOIN cadastro.cliente_pf clipf on clipf.cdcliente = clie.cdcliente "
				+ " LEFT JOIN cadastro.cliente_pj clipj on clipj.cdcliente = clie.cdcliente "
				;
		
		retorno =  session
				.createSQLQuery(consulta)
				.addScalar("codigo", StandardBasicTypes.INTEGER)
                .addScalar("nomeCliente", StandardBasicTypes.STRING)
                .addScalar("cpf", StandardBasicTypes.STRING)
                .addScalar("cnpj", StandardBasicTypes.STRING)
                .list()
                ;
		
		return retorno;
				
	}
	

	
	
}
