package com.sgcont.gui;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sgcont.dados.Usuario;
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
	
	private String resposta;
	
	public EfetuarLoginManagedBean() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável por validar e efetuar o login
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public void login() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		Map<String,String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (parametros.get("sessaoEspirada") != null
				&& parametros.get("sessaoEspirada").toString().trim().equalsIgnoreCase("sim")) {
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Sessão Expirada!"));
			
		} else {
		
			Fachada fachada = Fachada.getInstance();
			Usuario usuarioBase = fachada.pesquisarUsuario(usuario.getLogin(), usuario.getSenha());
			
			if(usuarioBase != null
					&& usuarioBase.getCodigo() != null) {
				
				session.setAttribute("usuarioLogado", usuarioBase);
				
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atenção", "Usuário e/ou senha incorretos!"));
			}
			
		}
		
	}
	
	
}
