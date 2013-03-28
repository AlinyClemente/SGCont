package com.sgcont.negocio;

import com.sgcont.repositorio.IRepositorioOperacional;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioOperacional;
import com.sgcont.repositorio.RepositorioUtil;

/**
 * Controlador respons�vel pelas regras de neg�cio do m�dulo operacional
 * */
public class ControladorOperacional implements IControladorOperacional {

	private static ControladorOperacional instance;

	protected IRepositorioOperacional repositorioOperacional = null;
	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorOperacional getInstance(){
		if (instance == null){
			instance = new ControladorOperacional();
		}
		return instance;
	}
	
	private ControladorOperacional() {

		repositorioOperacional = RepositorioOperacional.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();
		
	}

	
}
