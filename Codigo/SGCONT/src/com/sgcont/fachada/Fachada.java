package com.sgcont.fachada;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.negocio.ControladorCadastro;
import com.sgcont.negocio.IControladorCadastro;

public class Fachada {

	private static Fachada instance;
	
	private IControladorCadastro controladorCadastro;
	
	public static synchronized Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		controladorCadastro = ControladorCadastro.getInstance();
	}
	
	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha) {
		
		return this.controladorCadastro.pesquisarUsuario(login, senha);
		
	}
	
}
