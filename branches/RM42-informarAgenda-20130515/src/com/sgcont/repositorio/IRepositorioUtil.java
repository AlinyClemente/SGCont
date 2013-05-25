package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Map;

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
	 * M�todo gen�rico que retorna uma lista com objetos a partir dos valores passados como par�metros.
	 * */
	public Collection<?> pesquisarColecao(Class<?> classe, Map<String, Object> campos);

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id);

	/**
	 * M�todo gen�rico que retorna um objeto a partir dos valores passados como par�metros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos);

	/**
	 * M�todo gen�rico para remover um objeto a partir dos valores passados como par�metros.
	 * */
	public void remover(Class<?> classe, Map<String, Object> campos);
	
}
