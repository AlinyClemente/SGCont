package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.Banco;
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
	
	private String numeroCei;
	
	private Profissao profissao;
	
	private ClientePessoaFisica clienteTitular;
	
	private Banco banco;
	
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

		if (this.tituloEleitor != null
				&& !this.tituloEleitor.isEmpty()) {
			clientePessoaFisica.setNumeroTituloEleitor(this.tituloEleitor);
		}
		
		if (this.numeroCei != null
				&& !this.numeroCei.isEmpty()) {
			clientePessoaFisica.setNumeroCei(this.numeroCei);
		}
		
		clientePessoaFisica.setProfissao(this.profissao);
		clientePessoaFisica.setClienteTitular(this.clienteTitular);
		clientePessoaFisica.setBanco(this.banco);
		clientePessoaFisica.setNumeroAgencia(this.numeroAgencia);
		clientePessoaFisica.setNumeroConta(this.numeroConta);

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

	public String getNumeroCei() {
		return numeroCei;
	}

	public void setNumeroCei(String numeroCei) {
		this.numeroCei = numeroCei;
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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
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

	public ClientePessoaFisicaTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientePessoaFisicaTO(ClientePessoaFisica clientePessoaFisica) {
		super();
		this.cpf = clientePessoaFisica.getNumeroCpf();
		this.rg = clientePessoaFisica.getNumeroRg();
		this.dataNascimento = Util.formatarData(clientePessoaFisica.getDataNascimento());
		this.sexo = clientePessoaFisica.getSexo().toString();
		this.indicadorDeclaracaoIR = clientePessoaFisica.getIndicadorDeclaracaoIr().toString();
		this.tituloEleitor = clientePessoaFisica.getNumeroTituloEleitor();
		this.numeroCei = clientePessoaFisica.getNumeroCei();
		this.profissao = clientePessoaFisica.getProfissao();
		this.clienteTitular = clientePessoaFisica.getClienteTitular();
		this.banco = clientePessoaFisica.getBanco();
		this.numeroAgencia = clientePessoaFisica.getNumeroAgencia();
		this.numeroConta = clientePessoaFisica.getNumeroConta();

	}

}
