package com.sgcont.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.Endereco;
import com.sgcont.dados.cadastro.Usuario;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		Configuration configuration = new Configuration();
		
		//Classes das entidades
		configuration
			.addAnnotatedClass(Usuario.class)
			.addAnnotatedClass(Endereco.class)
			.addAnnotatedClass(Cliente.class);
		
	    configuration.configure();
	    ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();	    
		
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession() {
		Session session = sessionFactory.openSession();
  		return session;
	}

}
