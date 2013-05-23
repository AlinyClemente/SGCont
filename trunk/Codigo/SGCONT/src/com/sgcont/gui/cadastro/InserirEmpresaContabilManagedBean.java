package com.sgcont.gui.cadastro;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.EmpresaContabilTO;
import com.sgcont.util.CepWebService;
import com.sgcont.util.Util;

/**
 * [UC015] Inserir Empresa Cont�bil
 * 
 * @author Vivianne Sousa
 * @since 07/05/2013
 * */
@ManagedBean (name="InserirEmpresaContabilBean")
@SessionScoped
public class InserirEmpresaContabilManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private StreamedContent file = null;
	private EmpresaContabilTO empresaContabilTO;
	
   
    public void upload(FileUploadEvent event) throws IOException { 
    	getEmpresaContabilTO().setLogomarca(Util.upload(event));
    	System.out.println(Util.upload(event).toString());
	} 

	public InserirEmpresaContabilManagedBean() {
		this.empresaContabilTO = new EmpresaContabilTO();
	}
	
	public EmpresaContabilTO getEmpresaContabilTO() {
		return empresaContabilTO;
	}

	public void setEmpresaContabilTO(EmpresaContabilTO empresaContabilTO) {
		this.empresaContabilTO = empresaContabilTO;
	}

	/**
	 * [UC015] Inserir Empresa Cont�bil
	 * 
	 * M�todo respons�vel por exibir a tela de cadastro da empresa contabil 
	 * 
	 * @author Vivianne Sousa
	 * @since 07/05/2013
	 * */
	public String exibirInserirEmpresaContabil() {

		this.empresaContabilTO = new EmpresaContabilTO();
		
		return "inserir_empresa_contabil";
		
	}

	/**
	 * [UC015] Inserir Empresa Cont�bil
	 * 
	 * M�todo respons�vel por cadastrar a empresa contabil
	 * 
	 * @author Vivianne Sousa
	 * @since 07/05/2013
	 * */
	public String cadastrar() {
     
		Fachada fachada = Fachada.getInstance();
		
		fachada.inserirEmpresaContabil(this.empresaContabilTO);
		
		return "tela_sucesso";
		
	}
	
	/**
	 * M�todo respons�vel por pesquisar o CEP a partir de um WebService
	 * 
	 * @author Mariana Victor
	 * @since 10/05/2013
	 * */
	public String pesquisarCEP() {
		
		CepWebService cepWebService = new CepWebService(
				this.empresaContabilTO.getCep());
		
		if (cepWebService.getResultado() == 1) {
			this.empresaContabilTO.setEstado(cepWebService.getEstado());
			this.empresaContabilTO.setCidade(cepWebService.getCidade());
			this.empresaContabilTO.setBairro(cepWebService.getBairro());
			this.empresaContabilTO.setRua(cepWebService.getTipoLogradouro()
					+ " " + cepWebService.getLogradouro());
		} else {
			this.empresaContabilTO.setEstado("");
			this.empresaContabilTO.setCidade("");
			this.empresaContabilTO.setBairro("");
			this.empresaContabilTO.setRua("");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"CEP n�o encontrado", null));
		}
		
		return "";
		
	}

	/**
	 * M�todo respons�vel por validar os dados do endere�o e format�-los para adicionar o endere�o
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	public String informarEndereco() {
        RequestContext context = RequestContext.getCurrentInstance();  

		boolean dadosValidos = validarDadosEndereco(); 
		
		if (dadosValidos) {
			
			this.empresaContabilTO.setEnderecoFormatado(
						this.empresaContabilTO.getRua()
						+ " - Num: " + this.empresaContabilTO.getNumeroEndereco()
						+ " - " + this.empresaContabilTO.getBairro()
						+ " - " + this.empresaContabilTO.getCidade()
						+ " - " + this.empresaContabilTO.getEstado()
						+ " - " + this.empresaContabilTO.getCep());
		}
		
		context.addCallbackParam("dadosValidos", dadosValidos);  
		
		return "";
	}

	/**
	 * M�todo respons�vel por validar os dados do endere�o
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	private boolean validarDadosEndereco() {
		boolean dadosValidos = true;
		
		if (this.empresaContabilTO.getRua() == null
				|| this.empresaContabilTO.getRua().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Rua: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.empresaContabilTO.getNumeroEndereco() == null
				|| this.empresaContabilTO.getNumeroEndereco().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"N�mero: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.empresaContabilTO.getBairro() == null
				|| this.empresaContabilTO.getBairro().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Bairro: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.empresaContabilTO.getCidade() == null
				|| this.empresaContabilTO.getCidade().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Cidade: Erro de valida��o: o valor � necess�rio", null));
		}

		if (this.empresaContabilTO.getEstado() == null
				|| this.empresaContabilTO.getEstado().isEmpty()) {

			dadosValidos = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"Estado: Erro de valida��o: o valor � necess�rio", null));
		}
		
		return dadosValidos;
	}
	
	/** 
	 * [FS0002] - Verificar exist�ncia de dados
	 * [FS003] - Verificar CNPJ inv�lido
	 * 
	 * @author Vivianne Sousa
	 * @since 21/05/2013
	 */
	public void validaCNPJ(FacesContext context, UIComponent toValidate, Object value) {  
        String cnpj = ((String) value)
				.replace(".", "")
				.replace("/", "")
				.replace("-", "");
        
        String mensagem = Fachada.getInstance().verificarCNPJValidoExistente(cnpj);
        
		if (!Util.validacaoCNPJ(cnpj)) {
        	mensagem = "D�gito verificador do CNPJ n�o confere.";
        } else {
    		Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("cnpj", cnpj);
			EmpresaContabil empresaContabil = (EmpresaContabil) 
					Fachada.getInstance().pesquisar(EmpresaContabil.class, parametros);
			
			if (empresaContabil != null) {
				mensagem = "CNPJ j� cadastrado para a Empresa " + empresaContabil.getNomeFantasia() + ".";
			}
	    }
		
		verificarMensagemCampo(context, toValidate, mensagem);
    }
	
	/** 
	 * M�todo respons�vel por verificar se deve ser exibida mensagem para o campo validado
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
	
	
	
	public StreamedContent obterImagem(EmpresaContabilTO empresa) {

		if (empresa!=null && empresa.getLogomarca() != null) {
	     
	    	byte[] imagem = new byte[(int)empresa.getLogomarca().length];

	    	for (int i = 0; i < imagem.length; i++) {
	    		imagem[i] = empresa.getLogomarca()[i];
	    	}
	    	
	    	InputStream is = new ByteArrayInputStream(imagem);
	        file = new DefaultStreamedContent(is, "",empresa.getCnpj()+"");
	        return file;
	    }

	    return file;
	}

	public StreamedContent getFile() {
		file = obterImagem(empresaContabilTO);
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
}
