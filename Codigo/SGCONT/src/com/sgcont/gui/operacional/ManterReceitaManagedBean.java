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
import com.sgcont.dados.operacional.Receita;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ReceitaTO;

/**
 * [UC012] Manter Receita
 * 
 * @author Rômulo Aurélio
 * @since 25/05/2013
 * */
@ManagedBean(name = "ManterReceitaBean")
@SessionScoped
public class ManterReceitaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ReceitaTO receitaTO;

	private Collection<EmpresaContabil> colecaoEmpresaContabil;

	private Collection<TipoReceita> colecaoTipoReceita;

	private Collection<ClienteTO> colecaoCliente;

	private Collection<ReceitaTO> colecaoReceitaTO;

	private Collection<ReceitaTO> colecaoReceitaTOFiltro;

	private ReceitaTO receitaTOSelecionada;

	public ManterReceitaManagedBean() {
		this.receitaTO = new ReceitaTO();
	}

	public ReceitaTO getReceitaTO() {
		return receitaTO;
	}

	public void setReceitaTO(ReceitaTO receitaTO) {
		this.receitaTO = receitaTO;
	}

	public Collection<ReceitaTO> getColecaoReceitaTO() {
		return colecaoReceitaTO;
	}

	public void setColecaoReceitaTO(Collection<ReceitaTO> colecaoReceitaTO) {
		this.colecaoReceitaTO = colecaoReceitaTO;
	}

	public Collection<ReceitaTO> getColecaoReceitaTOFiltro() {
		return colecaoReceitaTOFiltro;
	}

	public void setColecaoReceitaTOFiltro(
			Collection<ReceitaTO> colecaoReceitaTOFiltro) {
		this.colecaoReceitaTOFiltro = colecaoReceitaTOFiltro;
	}

	public ReceitaTO getReceitaTOSelecionada() {
		return receitaTOSelecionada;
	}

	public void setReceitaTOSelecionada(ReceitaTO receitaTOSelecionada) {
		this.receitaTOSelecionada = receitaTOSelecionada;
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
	 * [UC013] Inserir Receita
	 * 
	 * Método responsável por exibir a tela de cadastro da receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public String exibirManterReceita() {

		this.receitaTOSelecionada = new ReceitaTO();

		Fachada fachada = Fachada.getInstance();

		this.colecaoReceitaTO = this.pesquisarColecaoReceitaTO();

		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) fachada
				.pesquisar(EmpresaContabil.class);

		this.colecaoTipoReceita = (Collection<TipoReceita>) fachada
				.pesquisar(TipoReceita.class);

		this.colecaoCliente = (Collection) fachada
				.pesquisarDadosClienteParaCombo();

		return "manter_receita";

	}

	/**
	 * [UC013] Inserir Receita
	 * 
	 * Método responsável por cadastrar a receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public String atualizar() {

		if (validarDadosReceitaSelecionada()
				&& validarEmpresaContabilouCliente()) {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarReceita(this.receitaTOSelecionada);

			return "tela_sucesso";
		} else {
			return "";
		}

	}

	/**
	 * [UC013] Inserir Receita
	 * 
	 * Método responsável por filtrar os resultados da pesquisa do tipo de
	 * receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
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
	 * [UC013] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
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
	 * [UC013] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public List<ClienteTO> completaCliente(String query) {
		List<ClienteTO> sugestoes = new ArrayList<ClienteTO>();

		for (ClienteTO cliente : this.colecaoCliente) {

			if ((cliente.getDocumento() + " - " + cliente.getNome()
					.toLowerCase()).contains(query.toLowerCase())) {
				sugestoes.add(cliente);
			}

		}
		return sugestoes;
	}

	/**
	 * Método responsável por verificar se deve ser exibida mensagem para o
	 * campo validado
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

	private Collection pesquisarColecaoReceitaTO() {

		Collection<ReceitaTO> colecaoReceitaTO = null;
		Fachada fachada = Fachada.getInstance();
		Collection<Receita> colecaoReceita = (Collection<Receita>) fachada
				.pesquisar(Receita.class);

		if (colecaoReceita != null && !colecaoReceita.isEmpty()) {
			colecaoReceitaTO = new ArrayList<ReceitaTO>();
			Iterator<Receita> iterReceita = colecaoReceita.iterator();

			while (iterReceita.hasNext()) {
				Receita receita = (Receita) iterReceita.next();

				ReceitaTO receitaTO = new ReceitaTO(receita);

				if (receita.getCliente() != null) {
					ClienteTO clienteTO = new ClienteTO();
					clienteTO.setCodigo(receita.getCliente().getCodigo()
							.toString());
					clienteTO.setNome(receita.getCliente().getNome());
					clienteTO = fachada.pesquisarDocumentoCliente(clienteTO);
					receitaTO.setClienteTO(clienteTO);
				}
				colecaoReceitaTO.add(receitaTO);
			}
		}

		return colecaoReceitaTO;
	}

	public String remover() {
		Map<String, String> parametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		Integer idReceita = new Integer(parametros.get("idReceita"));

		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametrosRemover = new HashMap<String, Object>();
		parametrosRemover.put("codigo", idReceita);
		fachada.remover(Receita.class, parametrosRemover);

		exibirManterReceita();

		return "";
	}

	/**
	 * Método responsável por validar os dados da receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 26/05/2013
	 * */
	private boolean validarDadosReceitaSelecionada() {
		boolean dadosValidos = true;

		if (this.receitaTOSelecionada.getDescricao() == null
				|| this.receitaTOSelecionada.getDescricao().equals("")) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Descrição: Erro de validação: o valor é necessário",
									null));
		}

		if (this.receitaTOSelecionada.getTipoReceita() == null) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Tipo de Receita: Erro de validação: o valor é necessário",
									null));
		}

		if (this.receitaTOSelecionada.getValor() == null
				|| this.receitaTOSelecionada.getValor().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Valor: Erro de validação: o valor é necessário",
							null));
		}

		if (this.receitaTOSelecionada.getDataGeracao() == null
				|| this.receitaTOSelecionada.getDataGeracao().equals("")) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Data de Geração: Erro de validação: o valor é necessário",
									null));
		}

		return dadosValidos;
	}

	/**
	 * 
	 * @author Rômulo Aurélio
	 * @since 26/05/2013
	 */
	private boolean validarEmpresaContabilouCliente() {

		boolean dadosValidos = true;

		if (this.receitaTOSelecionada.getEmpresaContabil() == null
				&& this.receitaTOSelecionada.getClienteTO() == null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					"mensagemValidacao",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Informe Empresa Contábil ou Cliente", null));

		} else if (this.receitaTOSelecionada.getEmpresaContabil() != null
				&& this.receitaTOSelecionada.getClienteTO() != null) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					"mensagemValidacao",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Informe Empresa Contábil ou Cliente", null));

		}
		return dadosValidos;
	}

}
