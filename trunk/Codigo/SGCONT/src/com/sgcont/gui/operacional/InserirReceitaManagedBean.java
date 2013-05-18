package com.sgcont.gui.operacional;

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

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ReceitaTO;

/**
 * [UC011] Inserir Receita
 * 
 * @author Rômulo Aurélio
 * @since 23/04/2013
 * */
@ManagedBean(name = "InserirReceitaBean")
@SessionScoped
public class InserirReceitaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ReceitaTO receitaTO;

	private Collection<TipoReceita> colecaoTipoReceita;
	private Collection<EmpresaContabil> colecaoEmpresaContabil;
	private Collection<ClienteTO> colecaoCliente;

	public InserirReceitaManagedBean() {
		this.receitaTO = new ReceitaTO();
	}

	public ReceitaTO getReceitaTO() {
		return receitaTO;
	}

	public void setReceitaTO(ReceitaTO receitaTO) {
		this.receitaTO = receitaTO;
	}

	public Collection<TipoReceita> getColecaoTipoReceita() {
		return colecaoTipoReceita;
	}

	public void setColecaoTipoReceita(Collection<TipoReceita> colecaoTipoReceita) {
		this.colecaoTipoReceita = colecaoTipoReceita;
	}

	public Collection<EmpresaContabil> getColecaoEmpresaContabil() {
		return colecaoEmpresaContabil;
	}

	public void setColecaoEmpresaContabil(
			Collection<EmpresaContabil> colecaoEmpresaContabil) {
		this.colecaoEmpresaContabil = colecaoEmpresaContabil;
	}

	public Collection<ClienteTO> getColecaoCliente() {
		return colecaoCliente;
	}

	public void setColecaoCliente(Collection<ClienteTO> colecaoCliente) {
		this.colecaoCliente = colecaoCliente;
	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public String exibirInserirReceita() {

		Fachada fachada = Fachada.getInstance();

		this.colecaoTipoReceita = (Collection<TipoReceita>) fachada
				.pesquisar(TipoReceita.class);

		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) fachada
				.pesquisar(EmpresaContabil.class);

		this.colecaoCliente = (Collection) fachada
				.pesquisarDadosClienteParaCombo();

		return "inserir_receita";

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();
		fachada.inserirReceita(this.receitaTO);
		return "tela_sucesso";

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public List<TipoReceita> completaTipoReceita(String query) {
		List<TipoReceita> sugestoes = new ArrayList<TipoReceita>();

		for (TipoReceita tipoReceita : this.colecaoTipoReceita) {

			if (tipoReceita.getDescricao().toLowerCase()
					.contains(query.toLowerCase())) {
				sugestoes.add(tipoReceita);
			}

		}
		return sugestoes;
	}
	
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public List<EmpresaContabil> completaEmpresaContabil(String query) {
		List<EmpresaContabil> sugestoes = new ArrayList<EmpresaContabil>();

		for (EmpresaContabil empresaContabil : this.colecaoEmpresaContabil) {

			if (empresaContabil.getNomeFantasia().toLowerCase()
					.contains(query.toLowerCase())) {
				sugestoes.add(empresaContabil);
			}

		}
		return sugestoes;
	}
	
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public List<ClienteTO> completaCliente(String query) {
		List<ClienteTO> sugestoes = new ArrayList<ClienteTO>();

		for (ClienteTO cliente : this.colecaoCliente) {

			if ((cliente.getDocumento() + " - " + cliente.getNome().toLowerCase())
					.contains(query.toLowerCase())) {
				sugestoes.add(cliente);
			}

		}
		return sugestoes;
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
	
	
}
