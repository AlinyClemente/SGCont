package com.sgcont.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sgcont.dados.Usuario;
import com.sgcont.negocio.fachada.Fachada;

/**
 * [UCXXX] Efetuar Login
 * 
 * @author Mariana Victor
 * @date 21/03/2013
 * */
public class EfetuarLoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private String resposta;
	
	public EfetuarLoginBean() {
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
	 * [UCXXX] Efetuar Login
	 * 
	 * Método responsável por validar e efetuar o login
	 * 
	 * @author Mariana Victor
	 * @date 21/03/2013
	 * */
	public void login() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		Map<String,String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (parametros.get("sessaoEspirada") != null
				&& parametros.get("sessaoEspirada").toString().trim().equalsIgnoreCase("sim")) {
			//return "LOGIN";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Sessão Expirada!"));
		} else {
		
			Fachada fachada = Fachada.getInstance();
			Usuario usuarioBase = fachada.pesquisarUsuario(usuario.getLogin(), usuario.getSenha());
			
			if(usuarioBase != null
					&& usuarioBase.getId() != null) {
				
				session.setAttribute("usuarioLogado", usuarioBase);
				
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				//return "OK";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atenção", "Usuário e/ou senha incorretos!"));
			}
		}
		//FacesMessage msg = new FacesMessage("Usuário e/ou senha incorretos");
		//FacesContext.getCurrentInstance().addMessage("form", msg);
		//return "";
		
	}
	
	
}
