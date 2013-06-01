package com.sgcont.gui.operacional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.operacional.Despesa;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.DespesaTO;

/**
 * [UC014] Manter Despesa
 * 
 * @author Vivianne Sousa
 * @since 18/05/2013
 * */
@ManagedBean (name="ManterDespesaBean")
@SessionScoped
public class ManterDespesaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<EmpresaContabil> colecaoEmpresaContabil;
	
	private Collection<TipoDespesa> colecaoTipoDespesa;
	
	private Collection<ClienteTO> colecaoCliente;
	
	private Collection<DespesaTO> colecaoDespesaTO;

	private Collection<DespesaTO> colecaoDespesaTOFiltro;
	
	private DespesaTO despesaTOSelecionada;
	
	public ManterDespesaManagedBean() {
		this.despesaTOSelecionada = new DespesaTO();
	}

	public Collection<DespesaTO> getColecaoDespesaTO() {
		return colecaoDespesaTO;
	}

	public void setColecaoDespesaTO(Collection<DespesaTO> colecaoDespesaTO) {
		this.colecaoDespesaTO = colecaoDespesaTO;
	}

	public Collection<DespesaTO> getColecaoDespesaTOFiltro() {
		return colecaoDespesaTOFiltro;
	}

	public void setColecaoDespesaTOFiltro(
			Collection<DespesaTO> colecaoDespesaTOFiltro) {
		this.colecaoDespesaTOFiltro = colecaoDespesaTOFiltro;
	}

	public DespesaTO getDespesaTOSelecionada() {
		return despesaTOSelecionada;
	}

	public void setDespesaTOSelecionada(DespesaTO despesaTOSelecionada) {
		this.despesaTOSelecionada = despesaTOSelecionada;
	}

	public Collection<TipoDespesa> getColecaoTipoDespesa() {
		return colecaoTipoDespesa;
	}

	public void setColecaoTipoDespesa(Collection<TipoDespesa> colecaoTipoDespesa) {
		this.colecaoTipoDespesa = colecaoTipoDespesa;
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
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável por exibir a tela de manter despesa 
	 * 
	 * @author Vivianne Sousa
	 * @since 23/05/2013
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String exibirManterDespesa() {
		
		this.despesaTOSelecionada = new DespesaTO();

		Fachada fachada = Fachada.getInstance();
		
		this.colecaoDespesaTO = this.pesquisarColecaoDespesaTO();
		
		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) 
				fachada.pesquisar(EmpresaContabil.class);
		
		this.colecaoTipoDespesa = (Collection<TipoDespesa>) 
				fachada.pesquisar(TipoDespesa.class);
		
		this.colecaoCliente = (Collection) fachada
				.pesquisarDadosClienteParaCombo(null);
		
		return "manter_despesa";
		
	}

	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável por atualizar a despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public String atualizar() {
		
		if(validarDadosDespesaSelecionada() && validarEmpresaContabilouCliente()){
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarDespesa(this.despesaTOSelecionada);
			return "tela_sucesso";
		}else{
			return "";
		}
		
	}
	
	public String remover(){
		Map<String,String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println("código da despesa: " + new Integer(parametros.get("idDespesa")));
		
		Integer idDespesa = new Integer(parametros.get("idDespesa"));
		
		Fachada fachada = Fachada.getInstance();
		
		Map<String, Object> parametrosRemover = new HashMap<String, Object>();
		parametrosRemover.put("codigo", idDespesa);
		fachada.remover(Despesa.class, parametrosRemover);

		exibirManterDespesa();
		
		return "";
	}
	
	/**
	 * [UC014] Manter Despesa
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
	 * [UC014] Manter Despesa
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
	 * [UC014] Manter Despesa
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
	private Collection pesquisarColecaoDespesaTO(){

		Collection<DespesaTO> colecaoDespesaTO = null;
		Fachada fachada = Fachada.getInstance();
		@SuppressWarnings("unchecked")
		Collection<Despesa> colecaoDespesa = (Collection<Despesa>)fachada.pesquisar(Despesa.class);

		if(colecaoDespesa != null && !colecaoDespesa.isEmpty()){
			colecaoDespesaTO = new ArrayList<DespesaTO>();
			Iterator<Despesa> iterDespesa = colecaoDespesa.iterator();
			
			while (iterDespesa.hasNext()) {
				Despesa despesa = (Despesa) iterDespesa.next();
				
				DespesaTO despesaTO = new DespesaTO(despesa);
				
				if(despesa.getCliente() != null){
					ClienteTO clienteTO = new ClienteTO();
					clienteTO.setCodigo(despesa.getCliente().getCodigo().toString());
					clienteTO.setNome(despesa.getCliente().getNome());
					clienteTO = fachada.pesquisarDocumentoCliente(clienteTO);
					despesaTO.setClienteTO(clienteTO);
				}
				colecaoDespesaTO.add(despesaTO);
			}
		}
		
		return colecaoDespesaTO;
	}
	
	
	/**
	 * Método responsável por validar os dados da despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 * */
	private boolean validarDadosDespesaSelecionada() {
		boolean dadosValidos = true;
		
		if (this.despesaTOSelecionada.getDescricao() == null
				|| this.despesaTOSelecionada.getDescricao().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Descrição: Erro de validação: o valor é necessário", null));
		}
		
		if (this.despesaTOSelecionada.getTipoDespesa() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Tipo de Despesa: Erro de validação: o valor é necessário", null));
		}
		
		if (this.despesaTOSelecionada.getValor() == null
				|| this.despesaTOSelecionada.getValor().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Valor: Erro de validação: o valor é necessário", null));
		}

		if (this.despesaTOSelecionada.getDatadespesa() == null
				|| this.despesaTOSelecionada.getDatadespesa().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Data de Geração: Erro de validação: o valor é necessário", null));
		}
		
		return dadosValidos;
	}

	/** 
	 * [UC014] Manter Despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 */
	private boolean validarEmpresaContabilouCliente() {
		
		boolean dadosValidos = true;
		
		if (this.despesaTOSelecionada.getEmpresaContabil() == null 
				&& this.despesaTOSelecionada.getClienteTO() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemValidacao", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Informe Empresa Contábil ou Cliente", null));
		

		}else if(this.despesaTOSelecionada.getEmpresaContabil() != null 
				&& this.despesaTOSelecionada.getClienteTO() != null) {
			
			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemValidacao", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Informe Empresa Contábil ou Cliente", null));
		
		}
		return dadosValidos;
	}
}
