package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.Cliente;

/**
 * [UC001] Inserir Cliente
 * 
 * @author Mariana Victor
 * @since 11/04/2013
 * */
public class ClienteTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String indicadorPessoaFisica;
	
	private String rua;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	private String numeroTelefone;
	
	private String email;
	
	private String inscricaoMunicipal;
	
	private String observacao;

	public Cliente getCliente(Cliente cliente) {

		cliente.setNome(this.nome);
		cliente.setIndicadorPessoaFisica(
				new Short(this.indicadorPessoaFisica));
		
//		Endereco endereco = new Endereco();
//		endereco.set
// 		TODO

		cliente.setNumeroTelefone(this.numeroTelefone);
		cliente.setEmail(this.email);
		cliente.setInscricaoMunicipal(this.inscricaoMunicipal);
		cliente.setObservacao(this.observacao);
		
		return cliente;
	}
	
	public Cliente getCliente() {
		
		Cliente cliente = new Cliente();
		
		return this.getCliente(cliente);
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndicadorPessoaFisica() {
		return indicadorPessoaFisica;
	}

	public void setIndicadorPessoaFisica(String indicadorPessoaFisica) {
		this.indicadorPessoaFisica = indicadorPessoaFisica;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
