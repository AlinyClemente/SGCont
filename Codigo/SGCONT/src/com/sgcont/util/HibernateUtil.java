package com.sgcont.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Endereco;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.dados.cadastro.Receita;
import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.dados.cadastro.Usuario;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		Configuration configuration = new Configuration();
		
		//Classes das entidades
		configuration
			.addAnnotatedClass(Usuario.class)
			.addAnnotatedClass(Endereco.class)
			.addAnnotatedClass(EmpresaContabil.class)
			.addAnnotatedClass(Contador.class)
			.addAnnotatedClass(Profissao.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(ClientePessoaFisica.class)
			.addAnnotatedClass(ClientePessoaJuridica.class)
			.addAnnotatedClass(Receita.class)
			.addAnnotatedClass(TipoReceita.class);
		
	    configuration.configure();
	    ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();	    
		
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
  		return session;
	}
	
	public static void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}

}
