package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.util.Util;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
public class ClientePessoaJuridicaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	
	private String cnpj;
	
	private String inscricaoEstadual;
	
	private String dataInicioAtividade;
	
	private String dataFimAtividade;
	
	private String suframa;
	
	private String nirf;
	
	private String site;
	
	private Contador contador;
	
	private ClientePessoaJuridica clienteMatriz;
	
	public ClientePessoaJuridica getClientePessoaJuridica() {
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		
		clientePessoaJuridica.setRazaoSocial(this.razaoSocial);
		clientePessoaJuridica
			.setNumeroCnpj(this.cnpj
					.replace(".", "")
					.replace("/", "")
					.replace("-", ""));
		clientePessoaJuridica.setInscricaoEstadual(this.inscricaoEstadual);
		clientePessoaJuridica.setDataInicioAtividade(
				Util.converterStringParaDate(this.dataInicioAtividade));
		clientePessoaJuridica.setDataFimAtividade(
				Util.converterStringParaDate(this.dataFimAtividade));
		
		if (this.suframa != null
				&& !this.suframa.isEmpty()) {
			clientePessoaJuridica.setCodigoSuframa(this.suframa);
		}
		if (this.nirf != null 
				&& !this.nirf.isEmpty()) {
			clientePessoaJuridica.setCodigoNire(
					new Integer(this.nirf));
		}
		if (this.site != null 
				&& !this.site.isEmpty()) {
			clientePessoaJuridica.setSite(this.site);
		}
		
		clientePessoaJuridica.setContador(this.contador);
		clientePessoaJuridica.setClienteMatriz(this.clienteMatriz);
		
		return clientePessoaJuridica;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(String dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public String getDataFimAtividade() {
		return dataFimAtividade;
	}

	public void setDataFimAtividade(String dataFimAtividade) {
		this.dataFimAtividade = dataFimAtividade;
	}

	public String getSuframa() {
		return suframa;
	}

	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}

	public String getNirf() {
		return nirf;
	}

	public void setNirf(String nirf) {
		this.nirf = nirf;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public ClientePessoaJuridica getClienteMatriz() {
		return clienteMatriz;
	}

	public void setClienteMatriz(ClientePessoaJuridica clienteMatriz) {
		this.clienteMatriz = clienteMatriz;
	}

	public ClientePessoaJuridicaTO() {
		super();
	}

	public ClientePessoaJuridicaTO(ClientePessoaJuridica clientePessoaJuridica) {
		super();
		this.razaoSocial = clientePessoaJuridica.getRazaoSocial();
		this.cnpj = clientePessoaJuridica.getNumeroCnpj();
		this.inscricaoEstadual = clientePessoaJuridica.getInscricaoEstadual();
		if(clientePessoaJuridica.getDataInicioAtividade() != null){
			this.dataInicioAtividade = Util.formatarData(clientePessoaJuridica.getDataInicioAtividade());
		}
		if(clientePessoaJuridica.getDataFimAtividade() != null){
			this.dataFimAtividade = Util.formatarData(clientePessoaJuridica.getDataFimAtividade());
		}
		this.suframa = clientePessoaJuridica.getCodigoSuframa();
		if(clientePessoaJuridica.getCodigoNire() != null){
			this.nirf = clientePessoaJuridica.getCodigoNire().toString();
		}
		this.site = clientePessoaJuridica.getSite();
		this.contador = clientePessoaJuridica.getContador();
		this.clienteMatriz = clientePessoaJuridica.getClienteMatriz();
	}

	
}
