package com.sgcont.transferobject;

import java.io.Serializable;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
public class ClientePessoaFisicaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String dataNascimento;
	
	private String sexo;
	
	private String indicadorDeclaracaoIR;
	
	private String tituloEleitor;
	
	private String profissao;
	
	private String clienteTitular;
	
	private String banco;
	
	private String numeroAgencia;
	
	private String numeroConta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIndicadorDeclaracaoIR() {
		return indicadorDeclaracaoIR;
	}

	public void setIndicadorDeclaracaoIR(String indicadorDeclaracaoIR) {
		this.indicadorDeclaracaoIR = indicadorDeclaracaoIR;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getClienteTitular() {
		return clienteTitular;
	}

	public void setClienteTitular(String clienteTitular) {
		this.clienteTitular = clienteTitular;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

}
