package com.sgcont.negocio;

import java.util.Collection;

/**
 * Interface do controlador respons�vel pelas opera��es b�sicas
 * */
public interface IControladorUtil {


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
