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

import org.primefaces.context.RequestContext;

import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.operacional.Receita;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.util.CepWebService;

/**
 * [UC004] ManterContador
 * 
 * @author Rômulo Aurélio
 * @since 25/05/2013
 * */
@ManagedBean(name = "ManterContadorBean")
@SessionScoped
public class ManterContadorManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContadorTO contadorTO;

	private Collection<EmpresaContabil> colecaoEmpresaContabil;

	private Collection<ContadorTO> colecaoContadorTO;

	private Collection<ContadorTO> colecaoContadorTOFiltro;

	private ContadorTO contadorTOSelecionada;

	public ManterContadorManagedBean() {
		this.contadorTO = new ContadorTO();
	}

	public ContadorTO getContadorTO() {
		return contadorTO;
	}

	public void setContadorTO(ContadorTO contadorTO) {
		this.contadorTO = contadorTO;
	}

	public Collection<ContadorTO> getColecaoContadorTO() {
		return colecaoContadorTO;
	}

	public void setColecaoContadorTO(Collection<ContadorTO> colecaoContadorTO) {
		this.colecaoContadorTO = colecaoContadorTO;
	}

	public Collection<ContadorTO> getColecaoContadorTOFiltro() {
		return colecaoContadorTOFiltro;
	}

	public void setColecaoContadorTOFiltro(
			Collection<ContadorTO> colecaoContadorTOFiltro) {
		this.colecaoContadorTOFiltro = colecaoContadorTOFiltro;
	}

	public ContadorTO getContadorTOSelecionada() {
		return contadorTOSelecionada;
	}

	public void setContadorTOSelecionada(ContadorTO contadorTOSelecionada) {
		this.contadorTOSelecionada = contadorTOSelecionada;
	}

	public Collection<EmpresaContabil> getColecaoEmpresaContabil() {
		return colecaoEmpresaContabil;
	}

	public void setColecaoEmpresaContabil(
			Collection<EmpresaContabil> colecaoEmpresaContabil) {
		this.colecaoEmpresaContabil = colecaoEmpresaContabil;
	}

	/**
	 * [UC004] ManterContador
	 * 
	 * Método responsável por exibir a tela de cadastro da contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public String exibirManterContador() {

		this.contadorTOSelecionada = new ContadorTO();

		Fachada fachada = Fachada.getInstance();

		this.colecaoContadorTO = this.pesquisarColecaoContadorTO();

		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) fachada
				.pesquisar(EmpresaContabil.class);

		return "manter_contador";

	}

	/**
	 * [UC004] ManterContador
	 * 
	 * Método responsável por cadastrar a contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public String atualizar() {
		if (validarDadosContadorSelecionada()
				&& validarDadosEndereco()) {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarContador(this.contadorTOSelecionada);

			return "tela_sucesso";
		} else {
			return "";
		}

	}

	/**
	 * [UC004] ManterContador
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

	private Collection pesquisarColecaoContadorTO() {

		Collection<ContadorTO> colecaoContadorTO = null;
		Fachada fachada = Fachada.getInstance();
		Collection<Contador> colecaoContador = (Collection<Contador>) fachada
				.pesquisar(Contador.class);

		if (colecaoContador != null && !colecaoContador.isEmpty()) {
			colecaoContadorTO = new ArrayList<ContadorTO>();
			Iterator<Contador> iterContador = colecaoContador.iterator();

			while (iterContador.hasNext()) {
				Contador contador = (Contador) iterContador.next();

				ContadorTO contadorTO = new ContadorTO(contador);
				colecaoContadorTO.add(contadorTO);
			}
		}

		return colecaoContadorTO;
	}

	/**
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	/*
	 * public void validaCPF(FacesContext context, UIComponent toValidate,
	 * Object value) { String cpf = ((String) value).replace(".",
	 * "").replace("-", "");
	 * 
	 * String mensagem = Fachada.getInstance()
	 * .verificarCPFValidoExistenteContador(cpf,
	 * this.contadorTOSelecionada.getCodigo());
	 * 
	 * verificarMensagemCampo(context, toValidate, mensagem); }
	 */
	/**
	 * [FS004] - Verificar CRC inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	/*
	 * public void validaCRC(FacesContext context, UIComponent toValidate,
	 * Object value) {
	 * 
	 * String mensagem = Fachada.getInstance().verificarCRCExistenteContador(
	 * value.toString(), this.contadorTOSelecionada.getCodigo());
	 * 
	 * verificarMensagemCampo(context, toValidate, mensagem); }
	 */
	/**
	 * Método responsável por pesquisar o CEP a partir de um WebService
	 * 
	 * @author Mariana Victor
	 * @since 10/05/2013
	 * */
	public String pesquisarCEP() {

		CepWebService cepWebService = new CepWebService(
				this.contadorTOSelecionada.getCep());

		if (cepWebService.getResultado() == 1) {
			this.contadorTOSelecionada.setEstado(cepWebService.getEstado());
			this.contadorTOSelecionada.setCidade(cepWebService.getCidade());
			this.contadorTOSelecionada.setBairro(cepWebService.getBairro());
			this.contadorTOSelecionada.setRua(cepWebService.getTipoLogradouro() + " "
					+ cepWebService.getLogradouro());
		} else {
			this.contadorTOSelecionada.setEstado("");
			this.contadorTOSelecionada.setCidade("");
			this.contadorTOSelecionada.setBairro("");
			this.contadorTOSelecionada.setRua("");

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"CEP não encontrado", null));
		}

		return "";

	}

	/**
	 * Método responsável por validar os dados do endereço e formatá-los para
	 * adicionar o endereço
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	public String informarEndereco() {
		RequestContext context = RequestContext.getCurrentInstance();

		boolean dadosValidos = validarDadosEndereco();

		if (dadosValidos) {

			this.contadorTOSelecionada.setEnderecoFormatado(this.contadorTOSelecionada.getRua()
					+ " - Num: " + this.contadorTOSelecionada.getNumeroEndereco() + " - "
					+ this.contadorTOSelecionada.getBairro() + " - "
					+ this.contadorTOSelecionada.getCidade() + " - "
					+ this.contadorTOSelecionada.getEstado() + " - "
					+ this.contadorTOSelecionada.getCep());
		}

		context.addCallbackParam("dadosValidos", dadosValidos);

		return "";
	}

	/**
	 * Método responsável por validar os dados do endereço
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	private boolean validarDadosEndereco() {
		boolean dadosValidos = true;

		if (this.contadorTOSelecionada.getRua() == null
				|| this.contadorTOSelecionada.getRua().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Rua: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTOSelecionada.getNumeroEndereco() == null
				|| this.contadorTOSelecionada.getNumeroEndereco().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Número: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTOSelecionada.getBairro() == null
				|| this.contadorTOSelecionada.getBairro().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Bairro: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTOSelecionada.getCidade() == null
				|| this.contadorTOSelecionada.getCidade().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Cidade: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTOSelecionada.getEstado() == null
				|| this.contadorTOSelecionada.getEstado().isEmpty()) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"UF: Erro de validação: o valor é necessário",
									null));
		}

		return dadosValidos;
	}

	public String remover() {
		Map<String, String> parametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		Integer idContador = new Integer(parametros.get("idContador"));

		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametrosRemover = new HashMap<String, Object>();
		parametrosRemover.put("codigo", idContador);
		fachada.remover(Contador.class, parametrosRemover);

		exibirManterContador();

		return "";
	}

	/**
	 * Método responsável por validar os dados da receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 26/05/2013
	 * */
	private boolean validarDadosContadorSelecionada() {
		boolean dadosValidos = true;

		if (this.contadorTOSelecionada.getNumeroCpf() == null
				|| this.contadorTOSelecionada.getNumeroCpf().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"CPF: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTOSelecionada.getRazaoSocial() == null
				|| this.contadorTOSelecionada.getRazaoSocial().equals("")) {

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

		if (this.contadorTOSelecionada.getNumeroCRC() == null
				|| this.contadorTOSelecionada.getNumeroCRC().equals("")) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Número do CRC: Erro de validação: o valor é necessário",
									null));
		}

		if (this.contadorTOSelecionada.getNumeroTelefone() == null
				|| this.contadorTOSelecionada.getNumeroTelefone().equals("")) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Telefone: Erro de validação: o valor é necessário",
									null));
		}

		if (this.contadorTOSelecionada.getEmpresaContabil() == null) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Empresa Contabil: Erro de validação: o valor é necessário",
									null));
		}

		if (this.contadorTOSelecionada.getIndicadorResponsavel() == null
				|| this.contadorTOSelecionada.getIndicadorResponsavel().equals(
						"")) {

			dadosValidos = false;
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Indicador de Responsável: Erro de validação: o valor é necessário",
									null));
		}

		String mensagemCpf = Fachada.getInstance()
				.verificarCPFValidoExistenteContador(
						this.contadorTOSelecionada.getNumeroCpf().replace(".", "").replace("-", ""),
						this.contadorTOSelecionada.getCodigo());

		if (mensagemCpf != null && !mensagemCpf.equals("")) {
			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemCpf,
							null));
		}

		String mensagemCRC = Fachada.getInstance()
				.verificarCRCExistenteContador(
						this.contadorTOSelecionada.getNumeroCRC(),
						this.contadorTOSelecionada.getCodigo());

		if (mensagemCRC != null && !mensagemCRC.equals("")) {
			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemCRC,
							null));
		}

		return dadosValidos;
	}

}
