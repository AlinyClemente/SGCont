package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.sgcont.dados.cadastro.Banco;
import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.util.CepWebService;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
@ManagedBean (name="InserirClienteBean")
@SessionScoped
public class InserirClienteManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteTO clienteTO;
	
	private ClientePessoaFisicaTO clientePfTO;
	
	private ClientePessoaJuridicaTO clientePjTO;
	
	private Collection<ClientePessoaFisica> colecaoClienteTitular;
	
	private Collection<Profissao> colecaoProfissoes;
	
	private Collection<Contador> colecaoContador;
	
	private Collection<ClientePessoaJuridica> colecaoClienteMatriz;
	
	private Collection<Banco> colecaoBanco;
	
	public InserirClienteManagedBean() {
		this.clienteTO = new ClienteTO();
		this.clientePfTO = new ClientePessoaFisicaTO();
		this.clientePjTO = new ClientePessoaJuridicaTO();
	}

	public ClienteTO getClienteTO() {
		return clienteTO;
	}

	public void setClienteTO(ClienteTO clienteTO) {
		this.clienteTO = clienteTO;
	}
	
	public ClientePessoaFisicaTO getClientePfTO() {
		return clientePfTO;
	}

	public void setClientePfTO(ClientePessoaFisicaTO clientePfTO) {
		this.clientePfTO = clientePfTO;
	}

	public ClientePessoaJuridicaTO getClientePjTO() {
		return clientePjTO;
	}

	public void setClientePjTO(ClientePessoaJuridicaTO clientePjTO) {
		this.clientePjTO = clientePjTO;
	}

	public Collection<ClientePessoaFisica> getColecaoClienteTitular() {
		return colecaoClienteTitular;
	}

	public void setColecaoClienteTitular(
			Collection<ClientePessoaFisica> colecaoClienteTitular) {
		this.colecaoClienteTitular = colecaoClienteTitular;
	}

	public Collection<Profissao> getColecaoProfissoes() {
		return colecaoProfissoes;
	}

	public void setColecaoProfissoes(Collection<Profissao> colecaoProfissoes) {
		this.colecaoProfissoes = colecaoProfissoes;
	}
	
	public Collection<Contador> getColecaoContador() {
		return colecaoContador;
	}

	public void setColecaoContador(Collection<Contador> colecaoContador) {
		this.colecaoContador = colecaoContador;
	}

	public Collection<ClientePessoaJuridica> getColecaoClienteMatriz() {
		return colecaoClienteMatriz;
	}

	public void setColecaoClienteMatriz(
			Collection<ClientePessoaJuridica> colecaoClienteMatriz) {
		this.colecaoClienteMatriz = colecaoClienteMatriz;
	}

	public Collection<Banco> getColecaoBanco() {
		return colecaoBanco;
	}

	public void setColecaoBanco(Collection<Banco> colecaoBanco) {
		this.colecaoBanco = colecaoBanco;
	}

	/**
	 * Método responsável por exibir a tela de cadastro do cliente 
	 * 
	 * @author Mariana Victor
	 * @since 11/04/2013
	 * */
	@SuppressWarnings("unchecked")
	public String exibirInserirCliente() {

		Fachada fachada = Fachada.getInstance();

		this.clienteTO = new ClienteTO();
		this.clientePfTO = new ClientePessoaFisicaTO();
		this.clientePjTO = new ClientePessoaJuridicaTO();
		
		this.colecaoProfissoes = (Collection<Profissao>) 
				fachada.pesquisar(Profissao.class);
//		this.colecaoClienteTitular = (Collection<ClientePessoaFisica>) 
//				fachada.pesquisar(ClientePessoaFisica.class);
		this.colecaoContador = (Collection<Contador>) 
				fachada.pesquisar(Contador.class);
//		this.colecaoClienteMatriz = (Collection<ClientePessoaJuridica>) 
//				fachada.pesquisar(ClientePessoaJuridica.class);
		this.colecaoBanco = (Collection<Banco>) 
				fachada.pesquisar(Banco.class);
		
		Map<String, Object> parametrosPesquisarClientePessoaFisica = new HashMap<String, Object>();
		parametrosPesquisarClientePessoaFisica.put("cliente.indicadorUso", Cliente.INDICADOR_ATIVO);
		this.colecaoClienteTitular = (Collection<ClientePessoaFisica>) 
				fachada.pesquisarColecao(ClientePessoaFisica.class,parametrosPesquisarClientePessoaFisica);
		
		Map<String, Object> parametrosPesquisarClientePessoaJuridica = new HashMap<String, Object>();
		parametrosPesquisarClientePessoaJuridica.put("cliente.indicadorUso", Cliente.INDICADOR_ATIVO);
		this.colecaoClienteMatriz = (Collection<ClientePessoaJuridica>) 
				fachada.pesquisarColecao(ClientePessoaJuridica.class,parametrosPesquisarClientePessoaJuridica);
		
		return "inserir_cliente";
		
	}

	/**
	 * Método responsável por cadastrar o cliente
	 * 
	 * @author Mariana Victor
	 * @since 11/04/2013
	 * */
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();
				
		if (this.clienteTO.getIndicadorPessoaFisica().equals("1")) {
			fachada.inserirClientePF(this.clienteTO, this.clientePfTO);
		} else {
			fachada.inserirClientePJ(this.clienteTO, this.clientePjTO);
		}
		
		return "tela_sucesso";
		
	}
	
	/** 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaEndereco(FacesContext context, UIComponent toValidate, Object value) {  
        String endereco = (String) value;
        
        if (endereco == null
        		|| endereco.isEmpty()) {
        	verificarMensagemCampo(context, toValidate, "Endereço: Erro de Validação: o valor é necessário.");
        }

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
        
        String mensagem = Fachada.getInstance().verificarCPFValidoExistente(cpf, null);

		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
	/** 
	 * [FS0002] - Verificar existência de dados
	 * [FS003] - Verificar CNPJ inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaCNPJ(FacesContext context, UIComponent toValidate, Object value) {  
        String cnpj = ((String) value)
				.replace(".", "")
				.replace("/", "")
				.replace("-", "");
        
        String mensagem = Fachada.getInstance().verificarCNPJValidoExistente(cnpj, null);

		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
	/** 
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaRG(FacesContext context, UIComponent toValidate, Object value) {  
        String rg = (String) value;
        
        String mensagem = Fachada.getInstance().verificarRGExistente(rg, null);

		verificarMensagemCampo(context, toValidate, mensagem);
    } 
	
	/** 
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public void validaTituloEleitor(FacesContext context, UIComponent toValidate, Object value) {  
        String tituloEleitor = (String) value;
        
        String mensagem = Fachada.getInstance().verificarTituloEleitorExistente(tituloEleitor, null);

		verificarMensagemCampo(context, toValidate, mensagem);
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
	 * Método responsável por filtrar os resultados da pesquisa do Cliente Titular
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<ClientePessoaFisica> completaClienteTitular(String query) {
		List<ClientePessoaFisica> sugestoes = new ArrayList<ClientePessoaFisica>();
		
		if (this.colecaoClienteTitular != null 
				&& !this.colecaoClienteTitular.isEmpty()) {
			for (ClientePessoaFisica cliente : this.colecaoClienteTitular) {
				
				if (cliente.getCliente().getNome().toLowerCase().contains(query.toLowerCase())
						|| cliente.getNumeroCpf().toLowerCase().contains(query.toLowerCase())) {
					
					sugestoes.add(cliente);
				}
				
			}
		}
		return sugestoes;
	}

	/**
	 * Método responsável por filtrar os resultados da pesquisa da Profissão
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<Profissao> completaProfissao(String query) {
		List<Profissao> sugestoes = new ArrayList<Profissao>();
		
		if (this.colecaoProfissoes != null 
				&& !this.colecaoProfissoes.isEmpty()) {
			for (Profissao profissao : this.colecaoProfissoes) {
				
				if (profissao.getNomeProfissao().toLowerCase()
						.contains(query.toLowerCase())) {
					sugestoes.add(profissao);
				}
			}
		}
		
		return sugestoes;
	}

	/**
	 * Método responsável por filtrar os resultados da pesquisa da Profissão
	 * 
	 * @author Mariana Victor
	 * @since 09/05/2013
	 * */
	public List<Contador> completaContador(String query) {
		List<Contador> sugestoes = new ArrayList<Contador>();

		if (this.colecaoContador != null 
				&& !this.colecaoContador.isEmpty()) {		
			for (Contador contador : this.colecaoContador) {
				
				if (contador.getNomeRazaoSocial().toLowerCase()
						.contains(query.toLowerCase())) {
					sugestoes.add(contador);
				}
			}
		}
		
		return sugestoes;
	}
	
	/**
	 * Método responsável por filtrar os resultados da pesquisa do Cliente Matriz
	 * 
	 * @author Mariana Victor
	 * @since 11/05/2013
	 * */
	public List<ClientePessoaJuridica> completaClienteMatriz(String query) {
		List<ClientePessoaJuridica> sugestoes = new ArrayList<ClientePessoaJuridica>();

		if (this.colecaoClienteMatriz!= null 
				&& !this.colecaoClienteMatriz.isEmpty()) {
			for (ClientePessoaJuridica cliente : this.colecaoClienteMatriz) {
				
				if (cliente.getCliente().getNome().toLowerCase().contains(query.toLowerCase())
						|| cliente.getNumeroCnpj().toLowerCase().contains(query.toLowerCase())) {
					sugestoes.add(cliente);
				}
			}
		}
		
		return sugestoes;
	}
	
	/**
	 * Método responsável por filtrar os resultados da pesquisa de Bancos
	 * 
	 * @author Mariana Victor
	 * @since 18/05/2013
	 * */
	public List<Banco> completaBanco(String query) {
		List<Banco> sugestoes = new ArrayList<Banco>();

		if (this.colecaoBanco!= null 
				&& !this.colecaoBanco.isEmpty()) {
			for (Banco banco : this.colecaoBanco) {
				
				if (banco.getDescricaoBanco().toLowerCase().contains(query.toLowerCase())) {
					sugestoes.add(banco);
				}
			}
		}
		
		return sugestoes;
	}
	
	/**
	 * Método responsável por pesquisar o CEP a partir de um WebService
	 * 
	 * @author Mariana Victor
	 * @since 10/05/2013
	 * */
	public String pesquisarCEP() {
		
		CepWebService cepWebService = new CepWebService(
				this.clienteTO.getCep());
		
		if (cepWebService.getResultado() == 1) {
			this.clienteTO.setEstado(cepWebService.getEstado());
			this.clienteTO.setCidade(cepWebService.getCidade());
			this.clienteTO.setBairro(cepWebService.getBairro());
			this.clienteTO.setRua(cepWebService.getTipoLogradouro()
					+ " " + cepWebService.getLogradouro());
		} else {
			this.clienteTO.setEstado("");
			this.clienteTO.setCidade("");
			this.clienteTO.setBairro("");
			this.clienteTO.setRua("");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"CEP não encontrado", null));
		}
		
		return "";
		
	}

	/**
	 * Método responsável por validar os dados do endereço e formatá-los para adicionar o endereço
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	public String informarEndereco() {
        RequestContext context = RequestContext.getCurrentInstance();  

		boolean dadosValidos = validarDadosEndereco(); 
		
		if (dadosValidos) {
			
			this.clienteTO.setEnderecoFormatado(
						this.clienteTO.getRua()
						+ " - Num: " + this.clienteTO.getNumeroEndereco()
						+ " - " + this.clienteTO.getBairro()
						+ " - " + this.clienteTO.getCidade()
						+ " - " + this.clienteTO.getEstado()
						+ " - " + this.clienteTO.getCep());
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
		
		if (this.clienteTO.getRua() == null
				|| this.clienteTO.getRua().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Rua: Erro de validação: o valor é necessário", null));
		}

		if (this.clienteTO.getNumeroEndereco() == null
				|| this.clienteTO.getNumeroEndereco().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Número: Erro de validação: o valor é necessário", null));
		}

		if (this.clienteTO.getBairro() == null
				|| this.clienteTO.getBairro().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Bairro: Erro de validação: o valor é necessário", null));
		}

		if (this.clienteTO.getCidade() == null
				|| this.clienteTO.getCidade().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Cidade: Erro de validação: o valor é necessário", null));
		}

		if (this.clienteTO.getEstado() == null
				|| this.clienteTO.getEstado().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Estado: Erro de validação: o valor é necessário", null));
		}
		
		return dadosValidos;
	}
	
	
}
