package com.sgcont.gui.cadastro;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean (name="LogoutBean")
@SessionScoped
public class EfetuarLogoutManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    public String efetuarLogout(){  
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
        session.invalidate();
        return "login.xhtml?faces-redirect=true";

    }  
}
