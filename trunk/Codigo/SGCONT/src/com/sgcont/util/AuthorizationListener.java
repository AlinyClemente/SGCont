package com.sgcont.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {

	    FacesContext facesContext = event.getFacesContext();
	    String currentPage = facesContext.getViewRoot().getViewId();

	    boolean paginaLogin = (currentPage.lastIndexOf("login.xhtml") > -1);
	    boolean paginaErro = (currentPage.lastIndexOf("erro.xhtml") > -1);
	    boolean paginaSessaoExpirada = (currentPage.lastIndexOf("sessao_expirada.xhtml") > -1);
	    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	    Object currentUser = session.getAttribute("usuarioLogado");

	    if (!paginaLogin 
    		&& !paginaErro 
    		&& !paginaSessaoExpirada 
    		&& currentUser == null) {
	      NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
	      nh.handleNavigation(facesContext, null, "sessao_expirada");
	    }
	  }

	  public void beforePhase(PhaseEvent event) {
	  }

	  public PhaseId getPhaseId() {
	    return PhaseId.RESTORE_VIEW;
	  }

	}