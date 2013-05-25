package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Map;

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
	 * Método genérico que retorna uma lista com objetos a partir dos valores passados como parâmetros.
	 * */
	public Collection<?> pesquisarColecao(Class<?> classe, Map<String, Object> campos);

	/**
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id);

	/**
	 * Método genérico que retorna um objeto a partir dos valores passados como parâmetros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos);

	/**
	 * Método genérico para remover um objeto a partir dos valores passados como parâmetros.
	 * */
	public void remover(Class<?> classe, Map<String, Object> campos);
	
}
