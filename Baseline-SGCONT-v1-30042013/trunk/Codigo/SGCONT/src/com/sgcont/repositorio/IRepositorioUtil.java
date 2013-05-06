package com.sgcont.repositorio;

import java.util.Collection;

public interface IRepositorioUtil {

	/**
	 * Método genérico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object);

	/**
	 * Método genérico para remover um objeto.
	 * */
	public void remover(Object object);

	/**
	 * Método genérico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe);

	/**
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id);
	
}
