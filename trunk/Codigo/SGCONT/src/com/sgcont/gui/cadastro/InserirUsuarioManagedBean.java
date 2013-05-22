package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.UsuarioTO;
import com.sgcont.util.CepWebService;


/**
 * [UC005] Inserir Usuario 
 * 
 * @author Rômulo Aurélio
 * @since 21/05/2013
 * */
@ManagedBean (name="InserirUsuarioBean")
@SessionScoped
public class InserirUsuarioManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioTO usuarioTO;
	
	public InserirUsuarioManagedBean() {
		this.usuarioTO = new UsuarioTO();
	}
	

	public String exibirInserirUsuario() {

		
		return "inserir_usuario";
		
	}	
	
	
	/**
	 * [UC003] Inserir Usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();
		
		fachada.inserirUsuario(this.usuarioTO);
		
		return "tela_sucesso";
		
	}
	
	
	
	

	/** 
	 * Método responsável por verificar se deve ser exibida mensagem para o campo validado
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	private void verificarMensagemCampo(FacesContext context,
			UIComponent toValidate, String mensagem) {
		if (mensagem != null) {
			((UIInput) toValidate).setValid(false);  

	        FacesMessage message = new FacesMessage(mensagem);  
	        message.setSeverity(FacesMessage.SEVERITY_ERROR);  
	        context.addMessage(toValidate.getClientId(context), message);
		} else {
			((UIInput) toValidate).setValid(true);
		}
	}

	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}

	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	} 
	
	
	/** 
	 * [FS0002] - Verificar existência de dados
	 * [FS004] - Verificar CPF inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaCPF(FacesContext context, UIComponent toValidate, Object value) {  
        String cpf = ((String) value)
        		.replace(".", "")
				.replace("-", "");
        
        String mensagem = Fachada.getInstance().verificarCPFValidoExistenteUsuario(cpf);

		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
}
