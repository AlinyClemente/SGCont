package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.UsuarioTO;

/**
 * [UC006] Manter Usuario
 * 
 * @author Rômulo Aurélio
 * @since 25/05/2013
 * */
@ManagedBean(name = "ManterUsuarioBean")
@SessionScoped
public class ManterUsuarioManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioTO usuarioTO;

	private Collection<UsuarioTO> colecaoUsuarioTO;

	private Collection<UsuarioTO> colecaoUsuarioTOFiltro;

	private UsuarioTO usuarioTOSelecionada;

	public ManterUsuarioManagedBean() {
		this.usuarioTO = new UsuarioTO();
	}

	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}

	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}

	public Collection<UsuarioTO> getColecaoUsuarioTO() {
		return colecaoUsuarioTO;
	}

	public void setColecaoUsuarioTO(Collection<UsuarioTO> colecaoUsuarioTO) {
		this.colecaoUsuarioTO = colecaoUsuarioTO;
	}

	public Collection<UsuarioTO> getColecaoUsuarioTOFiltro() {
		return colecaoUsuarioTOFiltro;
	}

	public void setColecaoUsuarioTOFiltro(
			Collection<UsuarioTO> colecaoUsuarioTOFiltro) {
		this.colecaoUsuarioTOFiltro = colecaoUsuarioTOFiltro;
	}

	public UsuarioTO getUsuarioTOSelecionada() {
		return usuarioTOSelecionada;
	}

	public void setUsuarioTOSelecionada(UsuarioTO usuarioTOSelecionada) {
		this.usuarioTOSelecionada = usuarioTOSelecionada;
	}

	/**
	 * [UC013] Inserir Usuario
	 * 
	 * Método responsável por exibir a tela de cadastro da usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	@SuppressWarnings("unchecked")
	public String exibirManterUsuario() {

		this.usuarioTOSelecionada = new UsuarioTO();

		@SuppressWarnings("unused")
		Fachada fachada = Fachada.getInstance();

		this.colecaoUsuarioTO = this.pesquisarColecaoUsuarioTO();

		return "manter_usuario";

	}

	/**
	 * [UC013] Inserir Usuario
	 * 
	 * Método responsável por cadastrar a usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public String atualizar() {

		if (validarDadosUsuarioSelecionada()) {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarUsuario(this.usuarioTOSelecionada);

			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
	        flash.put("mensagem", "Usuário atualizado com sucesso.");
			
			return "tela_sucesso";
		} else {
			return "";
		}

	}

	/**
	 * Método responsável por verificar se deve ser exibida mensagem para o
	 * campo validado
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	@SuppressWarnings("unused")
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

	@SuppressWarnings("rawtypes")
	private Collection pesquisarColecaoUsuarioTO() {

		Collection<UsuarioTO> colecaoUsuarioTO = null;
		Fachada fachada = Fachada.getInstance();
		@SuppressWarnings("unchecked")
		Collection<Usuario> colecaoUsuario = (Collection<Usuario>) fachada
				.pesquisar(Usuario.class);

		if (colecaoUsuario != null && !colecaoUsuario.isEmpty()) {
			colecaoUsuarioTO = new ArrayList<UsuarioTO>();
			Iterator<Usuario> iterUsuario = colecaoUsuario.iterator();

			while (iterUsuario.hasNext()) {
				Usuario usuario = (Usuario) iterUsuario.next();

				UsuarioTO usuarioTO = new UsuarioTO(usuario);

				colecaoUsuarioTO.add(usuarioTO);
			}
		}

		return colecaoUsuarioTO;
	}

	public String remover() {
		Map<String, String> parametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		Integer idUsuario = new Integer(parametros.get("idUsuario"));

		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametrosRemover = new HashMap<String, Object>();
		parametrosRemover.put("codigo", idUsuario);
		fachada.remover(Usuario.class, parametrosRemover);

		exibirManterUsuario();

		return "";
	}

	/**
	 * Método responsável por validar os dados da usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 26/05/2013
	 * */
	private boolean validarDadosUsuarioSelecionada() {
		boolean dadosValidos = true;

		if (this.usuarioTOSelecionada.getNome() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Nome: Erro de validação: o valor é necessário",
							null));
		}

		if (this.usuarioTOSelecionada.getLogin() == null
				|| this.usuarioTOSelecionada.getLogin().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Login: Erro de validação: o valor é necessário",
							null));
		}

		if (this.usuarioTOSelecionada.getNumeroCpf() == null
				|| this.usuarioTOSelecionada.getNumeroCpf().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"CPF: Erro de validação: o valor é necessário",
							null));
		}

		if (this.usuarioTOSelecionada.getNumeroCpf() == null
				|| this.usuarioTOSelecionada.getNumeroCpf().equals("")) {

			String mensagemCpf = Fachada.getInstance()
					.verificarCPFValidoExistenteUsuario(
							this.usuarioTOSelecionada.getNumeroCpf()
									.replace(".", "").replace("-", ""),
							this.usuarioTOSelecionada.getCodigo());

			if (mensagemCpf != null && !mensagemCpf.equals("")) {
				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								mensagemCpf, null));
			}
		}
		
		if (this.usuarioTOSelecionada.getEmail() == null
				|| this.usuarioTOSelecionada.getEmail().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"E-mail: Erro de validação: o valor é necessário",
							null));
		}

		return dadosValidos;
	}

}
