package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Session;

import com.sgcont.util.HibernateUtil;

public class RepositorioUtil implements IRepositorioUtil {

	private static IRepositorioUtil instance;

	public static IRepositorioUtil getInstancia() {
		if (instance == null) {
			instance = new RepositorioUtil();
		}
		return instance;
	}

	/**
	 * Método genérico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		Session session = HibernateUtil.getSession();

		session.saveOrUpdate(object);
		
		HibernateUtil.closeSession(session);
	}

	/**
	 * Método genérico para remover um objeto.
	 * */
	public void remover(Object object) {
		Session session = HibernateUtil.getSession();
		
		session.delete(object);
		
		HibernateUtil.closeSession(session);
	}

	/**
	 * Método genérico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		Session session = HibernateUtil.getSession();
		
		Collection<?> colecao = session.createQuery(
				"from " + classe.getName())
				.list();
		
		HibernateUtil.closeSession(session);
		
		return colecao;
	}

	/**
	 * Método genérico que retorna uma lista com objetos a partir dos valores passados como parâmetros.
	 * */
	public Collection<?> pesquisarColecao(Class<?> classe, Map<String, Object> campos) {
		Session session = HibernateUtil.getSession();
		
		String consulta = "from " + classe.getName() + " where ";
		
		Iterator<String> keys = campos.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();  
	        Object campo = campos.get(key);  
	  
	        if (campo instanceof String) {
	            consulta = consulta + key + " = '" + campo + "' and ";
	        } else {
	            consulta = consulta + key + " = " + campo + " and ";  
	        }  
		}
		
		consulta = consulta.substring(0, consulta.length() - 4);
		
		Collection<?> colecao = session.createQuery(
				consulta)
				.list();
		
		HibernateUtil.closeSession(session);
		
		return colecao;
	}

	/**
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		Session session = HibernateUtil.getSession();
		
		Object objeto = session.get(classe.getName(), id);

		HibernateUtil.closeSession(session);
		
		return objeto;
	}

	/**
	 * Método genérico que retorna um objeto a partir dos valores passados como parâmetros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos) {

		Session session = HibernateUtil.getSession();
		
		String consulta = "from " + classe.getName() + " where ";
				
		Iterator<String> keys = campos.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();  
	        Object campo = campos.get(key);  
	  
	        if (campo instanceof String) {
	            consulta = consulta + key + " = '" + campo + "' and ";
	        } else {
	            consulta = consulta + key + " = " + campo + " and ";  
	        }  
		}
		
		consulta = consulta.substring(0, consulta.length() - 4);
		
		Object objeto = session
				.createQuery(consulta)
				.setMaxResults(1).uniqueResult();
		
		HibernateUtil.closeSession(session);
		
		return objeto;
	}

	/**
	 * Método genérico para remover um objeto a partir dos valores passados como parâmetros.
	 * */
	public void remover(Class<?> classe, Map<String, Object> campos) {
		Session session = HibernateUtil.getSession();
		String query = "delete from " + classe.getName() + " where ";
		
		Iterator<String> keys = campos.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();  
	        Object campo = campos.get(key);  
	  
	        if (campo instanceof String) {
	        	query = query + key + " = '" + campo + "' and ";
	        } else {
	        	query = query + key + " = " + campo + " and ";  
	        }  
		}
		
		query = query.substring(0, query.length() - 4);
		
		session.createQuery(query)
				.executeUpdate();
		
		HibernateUtil.closeSession(session);
	}


}
