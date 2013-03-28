package com.sgcont.repositorio;

/**
 * Reposit�rio respons�vel pelas consultas do m�dulo da agenda
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
