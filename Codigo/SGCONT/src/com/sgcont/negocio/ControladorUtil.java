package com.sgcont.negocio;

import java.util.Collection;
import java.util.Map;

import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioUtil;

/**
 * Controlador responsável pelas operações básicas
 * */
public class ControladorUtil implements IControladorUtil {

	private static ControladorUtil instance;

	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorUtil getInstance(){
		if (instance == null){
			instance = new ControladorUtil();
		}
		return instance;
	}
	
	private ControladorUtil() {

		repositorioUtil = RepositorioUtil.getInstancia();
		
	}

	/**
	 * Método genérico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		this.repositorioUtil.inserirOuAtualizar(object);
	}

	/**
	 * Método genérico para remover um objeto.
	 * */
	public void remover(Object object) {
		this.repositorioUtil.remover(object);
	}

	/**
	 * Método genérico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		return this.repositorioUtil.pesquisar(classe);
	}

	/**
	 * Método genérico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		return this.repositorioUtil.pesquisar(classe, id);
	}

	/**
	 * Método genérico que retorna um objeto a partir dos valores passados como parâmetros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos) {
		
		return this.repositorioUtil.pesquisar(classe, campos);
		
	}
	
	/**
	* Método genérico para remover um objeto a partir dos valores passados como parâmetros.
	* */
	public void remover(Class<?> classe, Map<String, Object> campos) {
		
		this.repositorioUtil.remover(classe, campos);
		
	}
}
