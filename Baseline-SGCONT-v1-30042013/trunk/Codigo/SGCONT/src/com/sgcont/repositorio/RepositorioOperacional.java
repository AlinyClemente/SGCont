package com.sgcont.repositorio;

/**
 * Repositório responsável pelas consultas do módulo operacional
 * */
public class RepositorioOperacional implements IRepositorioOperacional {

	private static IRepositorioOperacional instance;

	public static IRepositorioOperacional getInstancia() {
		if (instance == null) {
			instance = new RepositorioOperacional();
		}
		return instance;
	}

}
