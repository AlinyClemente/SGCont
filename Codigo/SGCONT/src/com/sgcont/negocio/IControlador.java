package com.sgcont.negocio;

import com.sgcont.dados.Usuario;

public interface IControlador {
	
	public Usuario pesquisarUsuario(String login, String senha);
	
}
