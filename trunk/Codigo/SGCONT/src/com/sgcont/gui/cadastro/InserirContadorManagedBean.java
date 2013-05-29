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
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.util.CepWebService;

/**
 * [UC003] Inserir Contador
 * 
 * @author Rômulo Aurélio
 * @since 11/05/2013
 * */
@ManagedBean(name = "InserirContadorBean")
@SessionScoped
public class InserirContadorManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContadorTO contadorTO;

	private Collection<EmpresaContabil> colecaoEmpresaContabil;

	public InserirContadorManagedBean() {
		this.contadorTO = new ContadorTO();
	}

	public Collection<EmpresaContabil> getColecaoEmpresaContabil() {
		return colecaoEmpresaContabil;
	}

	public void setColecaoEmpresaContabil(
			Collection<EmpresaContabil> colecaoEmpresaContabil) {
		this.colecaoEmpresaContabil = colecaoEmpresaContabil;
	}

	/**
	 * [UC003] Inserir Contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public String exibirInserirContador() {

		this.contadorTO = new ContadorTO();
		Fachada fachada = Fachada.getInstance();

		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) fachada
				.pesquisar(EmpresaContabil.class);

		return "inserir_contador";

	}

	/**
	 * [UC003] Inserir Contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();

		fachada.inserirContador(this.contadorTO);

		return "tela_sucesso";

	}

	/**
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaEndereco(FacesContext context, UIComponent toValidate,
			Object value) {
		String endereco = (String) value;

		if (endereco == null || endereco.isEmpty()) {
			verificarMensagemCampo(context, toValidate,
					"Endereço: Erro de Validação: o valor é necessário.");
		}

	}

	/**
	 * Método responsável por pesquisar o CEP a partir de um WebService
	 * 
	 * @author Mariana Victor
	 * @since 10/05/2013
	 * */
	public String pesquisarCEP() {

		CepWebService cepWebService = new CepWebService(
				this.contadorTO.getCep());

		if (cepWebService.getResultado() == 1) {
			this.contadorTO.setEstado(cepWebService.getEstado());
			this.contadorTO.setCidade(cepWebService.getCidade());
			this.contadorTO.setBairro(cepWebService.getBairro());
			this.contadorTO.setRua(cepWebService.getTipoLogradouro() + " "
					+ cepWebService.getLogradouro());
		} else {
			this.contadorTO.setEstado("");
			this.contadorTO.setCidade("");
			this.contadorTO.setBairro("");
			this.contadorTO.setRua("");

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

			this.contadorTO.setEnderecoFormatado(this.contadorTO.getRua()
					+ " - Num: " + this.contadorTO.getNumeroEndereco() + " - "
					+ this.contadorTO.getBairro() + " - "
					+ this.contadorTO.getCidade() + " - "
					+ this.contadorTO.getEstado() + " - "
					+ this.contadorTO.getCep());
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

		if (this.contadorTO.getRua() == null
				|| this.contadorTO.getRua().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Rua: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTO.getNumeroEndereco() == null
				|| this.contadorTO.getNumeroEndereco().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Número: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTO.getBairro() == null
				|| this.contadorTO.getBairro().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Bairro: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTO.getCidade() == null
				|| this.contadorTO.getCidade().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Cidade: Erro de validação: o valor é necessário",
							null));
		}

		if (this.contadorTO.getEstado() == null
				|| this.contadorTO.getEstado().isEmpty()) {

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

	public ContadorTO getContadorTO() {
		return contadorTO;
	}

	public void setContadorTO(ContadorTO contadorTO) {
		this.contadorTO = contadorTO;
	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public List<EmpresaContabil> completaEmpresaContabil(String query) {
		List<EmpresaContabil> sugestoes = new ArrayList<EmpresaContabil>();

		if (this.colecaoEmpresaContabil != null
				&& !this.colecaoEmpresaContabil.isEmpty()) {
			for (EmpresaContabil empresaContabil : this.colecaoEmpresaContabil) {

				if (empresaContabil.getNomeFantasia().toLowerCase()
						.contains(query.toLowerCase())) {
					sugestoes.add(empresaContabil);
				}

			}
		}
		return sugestoes;
	}

	/**
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public void validaCPF(FacesContext context, UIComponent toValidate,
			Object value) {
		String cpf = ((String) value).replace(".", "").replace("-", "");

		String mensagem = Fachada.getInstance()
				.verificarCPFValidoExistenteContador(cpf);

		verificarMensagemCampo(context, toValidate, mensagem);
	}

	/**
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public void validaIndicadorResponsavel(FacesContext context,
			UIComponent toValidate, Object value) {
		String indicadorResponsavel = ((String) value);

		String mensagem = Fachada.getInstance().validaIndicadorResponsavel(
				indicadorResponsavel, null);

		if (mensagem != null) {
			verificarMensagemCampo(context, toValidate, mensagem);
		}
	}

}
