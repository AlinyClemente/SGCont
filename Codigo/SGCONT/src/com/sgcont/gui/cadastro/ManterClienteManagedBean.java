package com.sgcont.gui.cadastro;

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

import com.sgcont.dados.cadastro.Banco;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.dados.operacional.Despesa;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.DespesaTO;
import com.sgcont.util.CepWebService;

/**
 * [UC002] Manter Cliente 
 * 
 * @author Vivianne Sousa
 * @since 25/05/2013
 * */
@ManagedBean (name="ManterClienteBean")
@SessionScoped
public class ManterClienteManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<ClientePessoaFisica> colecaoClienteTitular;
	
	private Collection<Profissao> colecaoProfissoes;
	
	private Collection<Contador> colecaoContador;
	
	private Collection<ClientePessoaJuridica> colecaoClienteMatriz;
	
	private Collection<Banco> colecaoBanco;
	
	private Collection<ClienteTO> colecaoClienteTO;

	private Collection<ClienteTO> colecaoClienteTOFiltro;
	
	private ClienteTO clienteTOSelecionado;
	
	
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

	public Collection<ClienteTO> getColecaoClienteTO() {
		return colecaoClienteTO;
	}

	public void setColecaoClienteTO(Collection<ClienteTO> colecaoClienteTO) {
		this.colecaoClienteTO = colecaoClienteTO;
	}

	public Collection<ClienteTO> getColecaoClienteTOFiltro() {
		return colecaoClienteTOFiltro;
	}

	public void setColecaoClienteTOFiltro(
			Collection<ClienteTO> colecaoClienteTOFiltro) {
		this.colecaoClienteTOFiltro = colecaoClienteTOFiltro;
	}

	public ClienteTO getClienteTOSelecionado() {
		return clienteTOSelecionado;
	}

	public void setClienteTOSelecionado(ClienteTO clienteTOSelecionado) {
		this.clienteTOSelecionado = clienteTOSelecionado;
	}

	/**
	 * [UC002] Manter Cliente 
	 * 
	 * M�todo respons�vel por exibir a tela de manter cliente 
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public String exibirManterCliente() {

		this.clienteTOSelecionado = new ClienteTO();
	
		Fachada fachada = Fachada.getInstance();
		
		this.colecaoClienteTO = fachada.pesquisarColecaoClienteTO();
		
		this.colecaoProfissoes = (Collection<Profissao>) 
				fachada.pesquisar(Profissao.class);
		this.colecaoClienteTitular = (Collection<ClientePessoaFisica>) 
				fachada.pesquisar(ClientePessoaFisica.class);
		this.colecaoContador = (Collection<Contador>) 
				fachada.pesquisar(Contador.class);
		this.colecaoClienteMatriz = (Collection<ClientePessoaJuridica>) 
				fachada.pesquisar(ClientePessoaJuridica.class);
		this.colecaoBanco = (Collection<Banco>) 
				fachada.pesquisar(Banco.class);
		
		return "manter_cliente";
		
	}

	/**
	 * [UC014] Manter Despesa
	 * 
	 * M�todo respons�vel por atualziar a despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public String atualizar() {
		
		if(validarDadosClienteSelecionado()){
			Fachada fachada = Fachada.getInstance();
			if (this.clienteTOSelecionado.getIndicadorPessoaFisica().equals("1")) {
				fachada.atualizarClientePF(this.clienteTOSelecionado);
			} else {
				fachada.atualizarClientePJ(this.clienteTOSelecionado);
			}
			
			return "tela_sucesso";
		}else{
			return "";
		}
		
	}
	
	public String remover(){
		Map<String,String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println("c�digo do cliente: " + new Integer(parametros.get("idCliente")));

		Integer idCliente = new Integer(parametros.get("idCliente"));
		
		Fachada fachada = Fachada.getInstance();
		
		fachada.removerCliente(idCliente);

		exibirManterCliente();
		
		return "";
	}
	
	/** 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 */
	public void validaEndereco(FacesContext context, UIComponent toValidate, Object value) {  
        String endereco = (String) value;
        
        if (endereco == null
        		|| endereco.isEmpty()) {
        	verificarMensagemCampo(context, toValidate, "Endere�o: Erro de Valida��o: o valor � necess�rio.");
        }

    }
	
	/** 
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS004] - Verificar CPF inv�lido
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 */
	public void validaCPF(FacesContext context, UIComponent toValidate, Object value) {  
        String cpf = ((String) value)
        		.replace(".", "")
				.replace("-", "");
        
        String mensagem = Fachada.getInstance().verificarCPFValidoExistente(
        		cpf, this.clienteTOSelecionado.getCodigo());

		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
	/** 
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CNPJ inv�lido
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 */
	public void validaCNPJ(FacesContext context, UIComponent toValidate, Object value) {  
        String cnpj = ((String) value)
				.replace(".", "")
				.replace("/", "")
				.replace("-", "");
        
        String mensagem = Fachada.getInstance().verificarCNPJValidoExistente(
        		cnpj, this.clienteTOSelecionado.getCodigo());

		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
	/** 
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 */
	public void validaRG(FacesContext context, UIComponent toValidate, Object value) {  
        String rg = (String) value;
        
        String mensagem = Fachada.getInstance().verificarRGExistente(
        		rg, this.clienteTOSelecionado.getCodigo());

		verificarMensagemCampo(context, toValidate, mensagem);
    } 
	
	/** 
	 * [FS0002] - Verificar exist�ncia de dados
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 */
	public void validaTituloEleitor(FacesContext context, UIComponent toValidate, Object value) {  
        String tituloEleitor = (String) value;
        
        String mensagem = Fachada.getInstance().verificarTituloEleitorExistente(
        		tituloEleitor, this.clienteTOSelecionado.getCodigo());

		verificarMensagemCampo(context, toValidate, mensagem);
    }

	/** 
	 * M�todo respons�vel por verificar se deve ser exibida mensagem para o campo validado
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por filtrar os resultados da pesquisa do Cliente Titular
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por filtrar os resultados da pesquisa da Profiss�o
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por filtrar os resultados da pesquisa da Profiss�o
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por filtrar os resultados da pesquisa do Cliente Matriz
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por filtrar os resultados da pesquisa de Bancos
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
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
	 * M�todo respons�vel por pesquisar o CEP a partir de um WebService
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public String pesquisarCEP() {
		
		CepWebService cepWebService = new CepWebService(
				this.clienteTOSelecionado.getCep());
		
		if (cepWebService.getResultado() == 1) {
			this.clienteTOSelecionado.setEstado(cepWebService.getEstado());
			this.clienteTOSelecionado.setCidade(cepWebService.getCidade());
			this.clienteTOSelecionado.setBairro(cepWebService.getBairro());
			this.clienteTOSelecionado.setRua(cepWebService.getTipoLogradouro()
					+ " " + cepWebService.getLogradouro());
		} else {
			this.clienteTOSelecionado.setEstado("");
			this.clienteTOSelecionado.setCidade("");
			this.clienteTOSelecionado.setBairro("");
			this.clienteTOSelecionado.setRua("");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"CEP n�o encontrado", null));
		}
		
		return "";
		
	}

	/**
	 * M�todo respons�vel por validar os dados do endere�o e format�-los para adicionar o endere�o
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public String informarEndereco() {
        RequestContext context = RequestContext.getCurrentInstance();  

		boolean dadosValidos = validarDadosEndereco(); 
		
		if (dadosValidos) {
			
			this.clienteTOSelecionado.setEnderecoFormatado(
						this.clienteTOSelecionado.getRua()
						+ " - Num: " + this.clienteTOSelecionado.getNumeroEndereco()
						+ " - " + this.clienteTOSelecionado.getBairro()
						+ " - " + this.clienteTOSelecionado.getCidade()
						+ " - " + this.clienteTOSelecionado.getEstado()
						+ " - " + this.clienteTOSelecionado.getCep());
		}
		
		context.addCallbackParam("dadosValidos", dadosValidos);  
		
		return "";
	}

	/**
	 * M�todo respons�vel por validar os dados do endere�o
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	private boolean validarDadosEndereco() {
		boolean dadosValidos = true;
		
		if (this.clienteTOSelecionado.getRua() == null
				|| this.clienteTOSelecionado.getRua().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("messagesPopup", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Rua: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.clienteTOSelecionado.getNumeroEndereco() == null
				|| this.clienteTOSelecionado.getNumeroEndereco().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("messagesPopup", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"N�mero: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.clienteTOSelecionado.getBairro() == null
				|| this.clienteTOSelecionado.getBairro().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("messagesPopup", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Bairro: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.clienteTOSelecionado.getCidade() == null
				|| this.clienteTOSelecionado.getCidade().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("messagesPopup", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Cidade: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.clienteTOSelecionado.getEstado() == null
				|| this.clienteTOSelecionado.getEstado().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("messagesPopup", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"UF: Erro de valida��o: o valor � necess�rio", null));
		}
		
		return dadosValidos;
	}
	
	
	/**
	 * M�todo respons�vel por validar os dados do cliente
	 * 
	 * @author Vivianne Sousa
	 * @since 28/05/2013
	 * */
	private boolean validarDadosClienteSelecionado() {
		boolean dadosValidos = true;
		
		if (this.clienteTOSelecionado.getNome() == null
				|| this.clienteTOSelecionado.getNome().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Nome: Erro de valida��o: o valor � necess�rio", null));
		}
		
		if (this.clienteTOSelecionado.getNumeroTelefone() == null
				|| this.clienteTOSelecionado.getNumeroTelefone().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Telefone: Erro de valida��o: o valor � necess�rio", null));
		}
		
		if (this.clienteTOSelecionado.getInscricaoMunicipal() == null
				|| this.clienteTOSelecionado.getInscricaoMunicipal().equals("")) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Inscri��o Municipal: Erro de valida��o: o valor � necess�rio", null));
		}
		
		if (this.clienteTOSelecionado.getIndicadorPessoaFisica().equals("1")) {
			//PESSOA F�SICA
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getCpf() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getCpf().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"CPF: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getRg() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getRg().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"RG: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getDataNascimento() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getDataNascimento().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Data de Nascimento: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getSexo() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getSexo().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Sexo: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getIndicadorDeclaracaoIR() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getIndicadorDeclaracaoIR().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Declara��o de IR: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getBanco() == null) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Banco: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getNumeroAgencia() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getNumeroAgencia().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"N� da Ag�ncia: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaFisicaTO().getNumeroConta() == null
					|| this.clienteTOSelecionado.getClientePessoaFisicaTO().getNumeroConta().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"N� da Conta: Erro de valida��o: o valor � necess�rio", null));
			}
		} else {
			//PESSOA JUR�DICA
			
			if (this.clienteTOSelecionado.getClientePessoaJuridicaTO().getRazaoSocial() == null
					|| this.clienteTOSelecionado.getClientePessoaJuridicaTO().getRazaoSocial().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Raz�o Social: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaJuridicaTO().getCnpj() == null
					|| this.clienteTOSelecionado.getClientePessoaJuridicaTO().getCnpj().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"CNPJ: Erro de valida��o: o valor � necess�rio", null));
			}
		
			if (this.clienteTOSelecionado.getClientePessoaJuridicaTO().getInscricaoEstadual() == null
					|| this.clienteTOSelecionado.getClientePessoaJuridicaTO().getInscricaoEstadual().equals("")) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Inscri��o Estadual: Erro de valida��o: o valor � necess�rio", null));
			}
			
			if (this.clienteTOSelecionado.getClientePessoaJuridicaTO().getContador() == null) {

				dadosValidos = false;
				FacesContext.getCurrentInstance().addMessage("mensagemCliente", new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Contador: Erro de valida��o: o valor � necess�rio", null));
			}
		}
		
		return dadosValidos;
	}


}
