package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.util.Util;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
public class ClientePessoaFisicaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	
	private String rg;
	
	private String dataNascimento;
	
	private String sexo;
	
	private String indicadorDeclaracaoIR;
	
	private String tituloEleitor;
	
	private Profissao profissao;
	
	private ClientePessoaFisica clienteTitular;
	
	private String banco;
	
	private String numeroAgencia;
	
	private String numeroConta;
	
	public ClientePessoaFisica getClientePessoaFisica() {
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		
		clientePessoaFisica.setNumeroCpf(this.cpf
				.replace(".", "")
				.replace("-", ""));
		clientePessoaFisica.setNumeroRg(this.rg);
		clientePessoaFisica.setDataNascimento(
				Util.converterStringParaDate(this.dataNascimento));
		clientePessoaFisica.setSexo(
				new Short(sexo));
		clientePessoaFisica.setIndicadorDeclaracaoIr(
				new Short(this.indicadorDeclaracaoIR));
		clientePessoaFisica.setNumeroTituloEleitor(this.tituloEleitor);
		clientePessoaFisica.setProfissao(this.profissao);
		clientePessoaFisica.setClienteTitular(this.clienteTitular);
		clientePessoaFisica.setCodigoBanco(
				new Integer(this.banco));
		clientePessoaFisica.setNumeroAgencia(this.numeroAgencia);
		clientePessoaFisica.setNumeroAgencia(this.numeroConta);

		return clientePessoaFisica;
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

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public ClientePessoaFisica getClienteTitular() {
		return clienteTitular;
	}

	public void setClienteTitular(ClientePessoaFisica clienteTitular) {
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
