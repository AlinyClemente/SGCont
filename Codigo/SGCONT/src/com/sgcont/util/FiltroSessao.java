package com.sgcont.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sgcont.dados.Usuario;

public class FiltroSessao implements Filter{  
  
    public void init( FilterConfig filterConfig ) throws ServletException{  
    }  
  
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException{  
        HttpServletResponse response = (HttpServletResponse)res;  
        HttpServletRequest request = (HttpServletRequest )req;  
     
        if( !this.authorize( (HttpServletRequest)req ) ){  
        	
            response.sendRedirect(request.getContextPath() + "/sessao_expirada.xhtml");
            
        }else{  
            chain.doFilter(request, response);
        }  
    }  
  
    public void destroy(){  
    	
    }  
    
    private boolean authorize( HttpServletRequest req ){  
        boolean retorno = false;  
        HttpSession session = req.getSession(false);         
        if(session != null){  
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");          
            if(usuario != null && usuario.getCodigo() != null){                  
                retorno = true;  
            }              
        }  
        return retorno;  
    }  
}  