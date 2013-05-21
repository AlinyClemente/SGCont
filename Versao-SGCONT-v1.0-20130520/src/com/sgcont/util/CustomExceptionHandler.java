package com.sgcont.util;

import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private static final Logger log = Logger.getLogger(CustomExceptionHandler.class.getCanonicalName());
    private ExceptionHandler wrapped;
 
    CustomExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }
 
    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }
 
    @Override
    public void handle() throws FacesException {
 
        final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context =
                    (ExceptionQueuedEventContext) event.getSource();
 
            // obtém a exceção
            Throwable t = context.getException();
 
            final FacesContext fc = FacesContext.getCurrentInstance();
            final Flash flash = fc.getExternalContext().getFlash();
            final NavigationHandler nav = fc.getApplication().getNavigationHandler();
 
            try {
 
                log.log(Level.SEVERE, "Critical Exception!", t);
                
                flash.put("mensagemExcecao", t.getCause());
                flash.put("dataHoraAtual", Util.formatarDataComHora(new Date()));
                
                // redireciona a página de acordo com o tipo da exceção
                if (t instanceof ViewExpiredException) {
                	nav.handleNavigation(fc, null, "sessao_espirada?faces-redirect=true");
                } else {
                	nav.handleNavigation(fc, null, "erro?faces-redirect=true");
                }
                
                fc.renderResponse();
 
 
            } finally {
                i.remove();
            }
        }
        getWrapped().handle();
    }
}