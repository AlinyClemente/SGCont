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
	 * M�todo gen�rico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		Session session = HibernateUtil.getSession();
		
		session.saveOrUpdate(object);
	}

	/**
	 * M�todo gen�rico para remover um objeto.
	 * */
	public void remover(Object object) {
		Session session = HibernateUtil.getSession();
		
		session.delete(object);
	}

	/**
	 * M�todo gen�rico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		Session session = HibernateUtil.getSession();
		
		return session.createQuery(
				"from " + classe.getName())
				.list();
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		Session session = HibernateUtil.getSession();
		
		return session.get(classe.getName(), id);
	}

}
