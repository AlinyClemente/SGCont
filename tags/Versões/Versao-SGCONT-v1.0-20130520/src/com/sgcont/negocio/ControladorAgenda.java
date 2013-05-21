package com.sgcont.negocio;

import com.sgcont.repositorio.IRepositorioAgenda;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioAgenda;
import com.sgcont.repositorio.RepositorioUtil;

/**
 * Controlador respons�vel pelas regras de neg�cio do m�dulo da agenda
 * */
public class ControladorAgenda implements IControladorAgenda {

	private static ControladorAgenda instance;

	protected IRepositorioAgenda repositorioAgenda = null;
	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorAgenda getInstance(){
		if (instance == null){
			instance = new ControladorAgenda();
		}
		return instance;
	}
	
	private ControladorAgenda() {

		repositorioAgenda = RepositorioAgenda.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();
		
	}

	
}
