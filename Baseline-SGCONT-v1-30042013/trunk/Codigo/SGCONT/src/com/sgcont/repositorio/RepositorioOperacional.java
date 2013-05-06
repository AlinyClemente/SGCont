package com.sgcont.repositorio;

/**
 * Reposit�rio respons�vel pelas consultas do m�dulo operacional
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
