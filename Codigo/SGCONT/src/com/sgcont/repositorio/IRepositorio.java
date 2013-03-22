package com.sgcont.repositorio;

import com.sgcont.dados.Usuario;

public interface IRepositorio {
	
	public Usuario pesquisarUsuario(String login, String senha);
	
}
