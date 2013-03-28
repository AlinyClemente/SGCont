package com.sgcont.repositorio;

import java.util.Collection;

public interface IRepositorioUtil {

	/**
	 * M�todo gen�rico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object);

	/**
	 * M�todo gen�rico para remover um objeto.
	 * */
	public void remover(Object object);

	/**
	 * M�todo gen�rico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe);

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id);
	
}
