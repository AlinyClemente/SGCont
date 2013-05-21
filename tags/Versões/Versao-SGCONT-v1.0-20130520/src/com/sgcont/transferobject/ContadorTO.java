package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.Contador;

public class ContadorTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	private String razaoSocial;

	private String codigoIdentificacao;
	
	private String numeroCRC;
	
	private String dataReceita;
	
	private String numeroTelefone;

	private String nnfax;
	
	private String email;
	
	private String indicadorUso;
	
	private String indicadorResponsavel;
	
	private String empresaContabil;
	
	private String endereco;
	
	private Contador contador;
	
	private String estado;
	
	private String cidade;
	
	private String bairro;
	
	private String numeroEndereco;
	
	private String rua;
	
	private String cep;

	private String enderecoFormatado;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCodigoIdentificacao() {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao(String codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}

	public String getNumeroCRC() {
		return numeroCRC;
	}

	public void setNumeroCRC(String numeroCRC) {
		this.numeroCRC = numeroCRC;
	}

	public String getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(String dataReceita) {
		this.dataReceita = dataReceita;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNnfax() {
		return nnfax;
	}

	public void setNnfax(String nnfax) {
		this.nnfax = nnfax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public String getIndicadorResponsavel() {
		return indicadorResponsavel;
	}

	public void setIndicadorResponsavel(String indicadorResponsavel) {
		this.indicadorResponsavel = indicadorResponsavel;
	}

	public String getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(String empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEnderecoFormatado() {
		return enderecoFormatado;
	}

	public void setEnderecoFormatado(String enderecoFormatado) {
		this.enderecoFormatado = enderecoFormatado;
	}
	
	

}
