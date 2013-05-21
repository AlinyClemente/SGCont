package com.sgcont.repositorio;

/**
 * Repositório responsável pelas consultas do módulo da agenda
 * */
public class RepositorioAgenda implements IRepositorioAgenda {

	private static IRepositorioAgenda instance;

	public static IRepositorioAgenda getInstancia() {
		if (instance == null) {
			instance = new RepositorioAgenda();
		}
		return instance;
	}

}
