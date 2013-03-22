package com.sgcont.negocio;

import com.sgcont.dados.Usuario;
import com.sgcont.repositorio.IRepositorio;
import com.sgcont.repositorio.Repositorio;

public class Controlador implements IControlador {

	private static Controlador instance;

	protected IRepositorio repositorio = null;
	
	public static synchronized IControlador getInstance(){
		if (instance == null){
			instance = new Controlador();
		}
		return instance;
	}
	
	private Controlador() {

		repositorio = Repositorio.getInstancia();
		
	}
	
	public Usuario pesquisarUsuario(String login, String senha) {
		
		return this.repositorio.pesquisarUsuario(login, senha);
		
	}
	
}
