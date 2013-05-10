package com.sgcont.repositorio;

import java.util.Collection;

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
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		Session session = HibernateUtil.getSession();
		
		Object objeto = session.get(classe.getName(), id);

		HibernateUtil.closeSession(session);
		
		return objeto;
	}

}
