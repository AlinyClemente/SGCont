package com.sgcont.conexao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sgcont.dados.Usuario;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static final Session session;
	
	static {
//		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
	    .configure().buildServiceRegistry();
		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(Usuario.class);
		Metadata metadata = metadataSources.buildMetadata();
		sessionFactory = metadata.buildSessionFactory();
		session = sessionFactory.getCurrentSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		return session;
	}

}
