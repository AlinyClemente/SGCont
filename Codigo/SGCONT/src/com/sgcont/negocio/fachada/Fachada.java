package com.sgcont.negocio.fachada;

import com.sgcont.dados.Usuario;
import com.sgcont.negocio.Controlador;
import com.sgcont.negocio.IControlador;

public class Fachada {

	private static Fachada instance;
	
	private IControlador controlador;
	
	public static synchronized Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		controlador = Controlador.getInstance();
	}
	
	public Usuario pesquisarUsuario(String login, String senha) {
		
		return this.controlador.pesquisarUsuario(login, senha);
		
	}
	
}
