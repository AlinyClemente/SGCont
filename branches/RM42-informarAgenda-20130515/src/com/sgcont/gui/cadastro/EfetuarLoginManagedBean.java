package com.sgcont.gui.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;

/**
 * [UC010] Efetuar Login
 * 
 * @author Mariana Victor
 * @since 21/03/2013
 * */
@ManagedBean (name="LoginBean")
@SessionScoped
public class EfetuarLoginManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	public EfetuarLoginManagedBean() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável por validar e efetuar o login
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public String login() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		Fachada fachada = Fachada.getInstance();
		Usuario usuarioBase = fachada.pesquisarUsuario(usuario.getLogin(), usuario.getSenha());
		
		if(usuarioBase != null
				&& usuarioBase.getCodigo() != null) {
			
			session.setAttribute("usuarioLogado", usuarioBase);
			
			return "paginaInicial";
			
		} else {

			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção", "Login/Senha inválido."));
		}
			
		
		return "";
		
	}
	
	
}
