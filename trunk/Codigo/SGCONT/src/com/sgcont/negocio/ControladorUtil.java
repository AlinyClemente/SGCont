package com.sgcont.negocio;

import java.util.Collection;
import java.util.Map;

import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioUtil;

/**
 * Controlador respons�vel pelas opera��es b�sicas
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
	 * M�todo gen�rico para inserir ou atualizar um objeto.
	 * */
	public void inserirOuAtualizar(Object object) {
		this.repositorioUtil.inserirOuAtualizar(object);
	}

	/**
	 * M�todo gen�rico para remover um objeto.
	 * */
	public void remover(Object object) {
		this.repositorioUtil.remover(object);
	}

	/**
	 * M�todo gen�rico que retorna uma lista com objetos.
	 * */
	public Collection<?> pesquisar(Class<?> classe) {
		return this.repositorioUtil.pesquisar(classe);
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir do ID.
	 * */
	public Object pesquisar(Class<?> classe, Integer id) {
		return this.repositorioUtil.pesquisar(classe, id);
	}

	/**
	 * M�todo gen�rico que retorna um objeto a partir dos valores passados como par�metros.
	 * */
	public Object pesquisar(Class<?> classe, Map<String, Object> campos) {
		
		return this.repositorioUtil.pesquisar(classe, campos);
		
	}
	
	/**
	* M�todo gen�rico para remover um objeto a partir dos valores passados como par�metros.
	* */
	public void remover(Class<?> classe, Map<String, Object> campos) {
		
		this.repositorioUtil.remover(classe, campos);
		
	}
}
