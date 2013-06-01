package com.sgcont.gui.agenda;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.dados.operacional.Lembrete;
import com.sgcont.fachada.Fachada;
import com.sgcont.util.CompromissoEvent;

/**
 * [UC010] Informar Agenda
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
@ManagedBean (name="InformarAgendaBean")
@SessionScoped
public class InformarAgendaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;  

	private ScheduleEvent event = new CompromissoEvent();
	
	private Collection<Usuario> colecaoUsuario;

	public InformarAgendaManagedBean() {
		eventModel = new DefaultScheduleModel();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public Collection<Usuario> getColecaoUsuario() {
		return colecaoUsuario;
	}

	public void setColecaoUsuario(Collection<Usuario> colecaoUsuario) {
		this.colecaoUsuario = colecaoUsuario;
	}

	/**
	 * Método responsável por exibir a tela de informar agenda 
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public String exibirInformarAgenda() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Fachada fachada = Fachada.getInstance();
		
		if (session.getAttribute("usuarioLogado") != null
				&& !session.getAttribute("usuarioLogado").toString().isEmpty()) {
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			
			this.colecaoUsuario = fachada.pesquisarUsuarios(usuario.getCodigo());
			this.carregarCompromissos(fachada, usuario);
		}
		
		return "informar_agenda";

	}	

	/**
	 * Método responsável por exibir a tela de informar agenda na tela inicial 
	 * 
	 * @author Mariana Victor
	 * @since 30/05/2013
	 * */
	public String exibirInformarAgendaLogin() {
		
		this.exibirInformarAgenda();
		
		return "/jsf/informar_agenda.xhtml";

	}

	/**
	 * Método responsável por adicionar um evento 
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public String addEvent(ActionEvent actionEvent) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		RequestContext context = RequestContext.getCurrentInstance();
		Fachada fachada = Fachada.getInstance();
		
		boolean dadosValidos = validarDadosCompromisso(); 

		if (dadosValidos) {
			CompromissoEvent compromissoEvent = (CompromissoEvent) event;
			
			Integer codigoCompromisso = fachada.inserirOuAtualizarCompromisso(
						compromissoEvent, (Usuario) session.getAttribute("usuarioLogado"));
			
			compromissoEvent.setCodigo(codigoCompromisso);
			
			if(compromissoEvent.getId() == null) {
				eventModel.addEvent(compromissoEvent);  
			} else {  
				eventModel.updateEvent(compromissoEvent);
			}
			event = new CompromissoEvent();
			
			if (compromissoEvent.getIndicadorCompromissoRecorrente() != null 
					&& compromissoEvent.getIndicadorCompromissoRecorrente().trim().equals("1")) {

				this.inserirCompromissosRecorrentes(session, fachada,
						compromissoEvent, codigoCompromisso);
				
			}
		}
		
		context.addCallbackParam("dadosValidos", dadosValidos);
		
		return "informar_agenda";
	}

	/**
	 * Método responsável por remover um evento
	 * 
	 * @author Mariana Victor
	 * @since 25/05/2013
	 * */
	public void removeEvent() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		RequestContext context = RequestContext.getCurrentInstance();
		Fachada fachada = Fachada.getInstance();
		
		fachada.removerCompromisso(
				((CompromissoEvent) event).getCompromisso(),
				(Usuario) session.getAttribute("usuarioLogado"));
		
		context.addCallbackParam("dadosValidos", true);
		
	}

	/**
	 * Método responsável por selecionar um evento
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public void onEventSelect(SelectEvent selectEvent) {  
		event = (ScheduleEvent) selectEvent.getObject();
	}  


	/**
	 * Método responsável por criar um evento 
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public void onDateSelect(SelectEvent selectEvent) {  
		event = new CompromissoEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}  

	/**
	 * Método responsável por mover um evento 
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public void onEventMove(ScheduleEntryMoveEvent event) {
		Fachada fachada = Fachada.getInstance();
		fachada.moverCompromisso((CompromissoEvent) event.getScheduleEvent());
		
		FacesMessage message;
		
		if (event.getDayDelta() < 0 || event.getMinuteDelta() < 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compromisso alterado", "Adiantado em: " + (event.getDayDelta()*(-1)) + " dias e " + (event.getMinuteDelta()*(-1)) + " minutos");  
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compromisso alterado", "Adiado em: " + event.getDayDelta() + " dias e " + event.getMinuteDelta() + " minutos");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
	}  

	/**
	 * Método responsável por redmensionar um evento 
	 * 
	 * @author Mariana Victor
	 * @since 14/04/2013
	 * */
	public void onEventResize(ScheduleEntryResizeEvent event) {  
		Fachada fachada = Fachada.getInstance();
		fachada.moverCompromisso((CompromissoEvent) event.getScheduleEvent());
		
		FacesMessage message;

		if (event.getDayDelta() < 0 || event.getMinuteDelta() < 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compromisso alterado", "Reduzido em: " + (event.getDayDelta()*(-1)) + " dias e " + (event.getMinuteDelta()*(-1)) + " minutos");  
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compromisso alterado", "Prolongado em: " + event.getDayDelta() + " dias e " + event.getMinuteDelta() + " minutos");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
	}  
	  
	/**
	 * Método responsável inserir os compromissos recorrentes 
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * */
	private void inserirCompromissosRecorrentes(HttpSession session,
			Fachada fachada, CompromissoEvent compromissoEvent,
			Integer codigoCompromisso) {
		Compromisso compromissoInserido = compromissoEvent.getCompromisso();
		for (int i = 0; i < new Integer(compromissoEvent.getQuantidade()) - 1; i++) {
			compromissoInserido = fachada.inserirCompromissoRecorrente(
					compromissoInserido, compromissoEvent, 
					(Usuario) session.getAttribute("usuarioLogado"), codigoCompromisso);
			
			Collection<Usuario> colecaoResponsaveis = 
					fachada.pesquisarResponsaveis(compromissoInserido.getCodigo());
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("compromisso.codigo", compromissoInserido.getCodigo());

			Lembrete lembrete = (Lembrete)
					fachada.pesquisar(Lembrete.class, parametros);
			
			ScheduleEvent compromissoRecorrente = new CompromissoEvent(
					compromissoInserido, colecaoResponsaveis, lembrete);
			
			eventModel.addEvent(compromissoRecorrente);
		}
	}  

	/**
	 * Método responsável por validar os dados do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * */
	private boolean validarDadosCompromisso() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		boolean dadosValidos = true;
		
		CompromissoEvent compromissoEvent = (CompromissoEvent) this.event;
		if (compromissoEvent.getTitle() == null
				|| compromissoEvent.getTitle().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Descrição: Erro de validação: o valor é necessário", null));
		}		
		if (compromissoEvent.getStartDate() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Data Início: Erro de validação: o valor é necessário", null));
		}		
		if (compromissoEvent.getEndDate() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Data Fim: Erro de validação: o valor é necessário", null));
		}	
		if (compromissoEvent.getIndicadorUsarLembrete() == null
				|| compromissoEvent.getIndicadorUsarLembrete().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Usar lembrete: Erro de validação: o valor é necessário", null));
			
		} else if (compromissoEvent.getIndicadorUsarLembrete().trim().equals("1")
				&& (compromissoEvent.getTempoLembrete() == null
					  || compromissoEvent.getTempoLembrete().isEmpty())) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Lembrete: Erro de validação: o valor é necessário", null));
		}
		if (compromissoEvent.getIndicadorCompromissoRecorrente() == null
				|| compromissoEvent.getIndicadorCompromissoRecorrente().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Compromisso Recorrente: Erro de validação: o valor é necessário", null));
			
		} else if (compromissoEvent.getIndicadorCompromissoRecorrente().trim().equals("1")
				&& (compromissoEvent.getQuantidade() == null
				  || compromissoEvent.getQuantidade().isEmpty())) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Repetição do Compromisso: Erro de validação: o valor é necessário", null));
		}
		
		if (compromissoEvent.getStartDate() != null
				&& compromissoEvent.getEndDate() != null
				&& compromissoEvent.getStartDate().compareTo(compromissoEvent.getEndDate()) > 0) {
			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Data Fim deve ser menor ou igual a Data Inicio do compromisso.", null));
		}
		
		Collection<Object[]> colecaoDados = Fachada.getInstance().pesquisarCompromissosMesmoHorario(
				compromissoEvent.getCodigo(), compromissoEvent.getStartDate(), 
				compromissoEvent.getColecaoUsuariosSelecionados(), 
				(Usuario) session.getAttribute("usuarioLogado"));
		if (colecaoDados != null
				&& !colecaoDados.isEmpty()) {
			Object[] dados = (Object[]) colecaoDados.iterator().next();
			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemDialog", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Usuário " + dados[0] + " já possui o compromisso " + dados[1] + " no mesmo horário.", null));
		}
		
		return dadosValidos;
	}

	/**
	 * Método responsável por carregar os dados dos compromissos
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * */
	private void carregarCompromissos(Fachada fachada, Usuario usuario) {

		this.eventModel = new DefaultScheduleModel();
		
		Collection<Compromisso> colecaoCompromisso =  
				fachada.pesquisarCompromisso(usuario.getCodigo());
		
		if (colecaoCompromisso != null
				&& !colecaoCompromisso.isEmpty()) {
			Iterator<Compromisso> iterator = colecaoCompromisso.iterator();
			
			while (iterator.hasNext()) {
				Compromisso compromisso = (Compromisso) iterator.next();
				
				Collection<Usuario> colecaoResponsaveis = 
						fachada.pesquisarResponsaveis(compromisso.getCodigo());
				
				Map<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("compromisso.codigo", compromisso.getCodigo());

				Lembrete lembrete = (Lembrete)
						fachada.pesquisar(Lembrete.class, parametros);
				
				ScheduleEvent event = new CompromissoEvent(
						compromisso, colecaoResponsaveis, lembrete);

				if (!fachada.verificarUsuarioResponsavelCompromisso(compromisso.getCodigo(), usuario.getCodigo())) {
					((CompromissoEvent)event).setEditable(false);
				}
				
				this.eventModel.addEvent(event);
			}
		}
	}
}
