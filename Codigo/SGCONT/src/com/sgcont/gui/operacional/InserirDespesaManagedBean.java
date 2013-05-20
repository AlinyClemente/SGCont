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

import org.primefaces.context.RequestContext;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.DespesaTO;

/**
 * [UC013] Inserir Despesa
 * 
 * @author Vivianne Sousa
 * @since 23/04/2013
 * */
@ManagedBean (name="InserirDespesaBean")
@SessionScoped
public class InserirDespesaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DespesaTO despesaTO;

	private Collection<EmpresaContabil> colecaoEmpresaContabil;
	
	private Collection<TipoDespesa> colecaoTipoDespesa;
	
	private Collection<ClienteTO> colecaoCliente;
	
	public InserirDespesaManagedBean() {
		this.despesaTO = new DespesaTO();
	}

	public DespesaTO getDespesaTO() {
		return despesaTO;
	}

	public void setDespesaTO(DespesaTO despesaTO) {
		this.despesaTO = despesaTO;
	}

	public Collection<EmpresaContabil> getColecaoEmpresaContabil() {
		return colecaoEmpresaContabil;
	}

	public void setColecaoEmpresaContabil(
			Collection<EmpresaContabil> colecaoEmpresaContabil) {
		this.colecaoEmpresaContabil = colecaoEmpresaContabil;
	}

	public Collection<TipoDespesa> getColecaoTipoDespesa() {
		return colecaoTipoDespesa;
	}

	public void setColecaoTipoDespesa(Collection<TipoDespesa> colecaoTipoDespesa) {
		this.colecaoTipoDespesa = colecaoTipoDespesa;
	}

	public Collection<ClienteTO> getColecaoCliente() {
		return colecaoCliente;
	}

	public void setColecaoCliente(Collection<ClienteTO> colecaoCliente) {
		this.colecaoCliente = colecaoCliente;
	}

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável por exibir a tela de cadastro da despesa 
	 * 
	 * @author Vivianne Sousa
	 * @since 23/04/2013
	 * */
	public String exibirInserirDespesa() {

		this.despesaTO = new DespesaTO();
		
		Fachada fachada = Fachada.getInstance();
		
		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) 
				fachada.pesquisar(EmpresaContabil.class);
		
		this.colecaoTipoDespesa = (Collection<TipoDespesa>) 
				fachada.pesquisar(TipoDespesa.class);
		
		this.colecaoCliente = (Collection) fachada
				.pesquisarDadosClienteParaCombo();
		
		return "inserir_despesa";
		
	}

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável por cadastrar a despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 23/04/2013
	 * */
	public String cadastrar() {
		
//	    RequestContext context = RequestContext.getCurrentInstance();  
//		boolean dadosValidos = validarDadosClienteEmpresaContabil(); 
//		
//		if (dadosValidos) {
			Fachada fachada = Fachada.getInstance();
			fachada.inserirDespesa(this.despesaTO);
			
			return "tela_sucesso";
//		}else{
//			context.addCallbackParam("dadosValidos", dadosValidos);  
//			
//			return "";
//		}
				
	}
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável por filtrar os resultados da pesquisa do tipo de despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * */
	public List<TipoDespesa> completaTipoDespesa(String query) {
		List<TipoDespesa> sugestoes = new ArrayList<TipoDespesa>();
		
		for (TipoDespesa tipoDespesa : this.colecaoTipoDespesa) {
			
			if (tipoDespesa.getDescricao().toLowerCase()
					.contains(query.toLowerCase())) {
				sugestoes.add(tipoDespesa);
			}
			
		}
		return sugestoes;
	}
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 16/05/2013
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
	 * [UC013] Inserir Despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 16/05/2013
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

	/** 
	 * [UC013] Inserir Despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 20/05/2013
	 */
	public boolean validarDadosClienteEmpresaContabil() {  
		boolean dadosValidos = true;
		
		if (this.despesaTO.getClienteTO() == null
			&& (this.despesaTO.getEmpresaContabil() == null || 
				this.despesaTO.getEmpresaContabil().equals(""))) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Cliente ou Empresa Contabil: Erro de validação: o valor é necessário", null));
		}

		if (this.despesaTO.getClienteTO() != null
				&& (this.despesaTO.getEmpresaContabil() != null || 
					!this.despesaTO.getEmpresaContabil().equals(""))) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Cliente ou Empresa Contabil: Erro de validação: o valor é necessário", null));
			}
		
		return dadosValidos;
    }
	
}
