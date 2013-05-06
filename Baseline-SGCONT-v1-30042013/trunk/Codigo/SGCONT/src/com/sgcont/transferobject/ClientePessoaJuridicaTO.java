package com.sgcont.transferobject;

import java.io.Serializable;

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
	
	private String contadorResponsavel;
	
	private String dataInicioAtividade;
	
	private String dataFimAtividade;
	
	private String suframa;
	
	private String nirf;
	
	private String site;

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

	public String getContadorResponsavel() {
		return contadorResponsavel;
	}

	public void setContadorResponsavel(String contadorResponsavel) {
		this.contadorResponsavel = contadorResponsavel;
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

}
