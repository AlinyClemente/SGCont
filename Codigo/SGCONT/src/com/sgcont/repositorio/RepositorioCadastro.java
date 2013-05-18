package com.sgcont.repositorio;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.transferobject.ClienteTO;
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
	 * Método responsável pesquisar os cliente cadastrados concatenando CPF / CNPJ e  nome 
	 * 
	 * @author Rômulo Aurélio
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
	public ClienteTO pesquisarClienteTO(String codigo) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT cliente "
				+ " FROM Cliente cliente "
				+ " WHERE cliente.codigo = :codigo ";
		
		Cliente cliente = 
				(Cliente) session
					.createQuery(consulta)
	                .setParameter("codigo", new Integer(codigo))
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		
		ClienteTO clienteTO = new ClienteTO();
		
		clienteTO.setCodigo(cliente.getCodigo().toString());
		clienteTO.setNome(cliente.getNome());
		
		return clienteTO;
				
	}
	
	
}
