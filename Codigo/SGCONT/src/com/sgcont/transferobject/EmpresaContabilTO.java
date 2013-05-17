package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Endereco;

/**
 * [UC015] Inserir Empresa Contábil
 * 
 * @author Vivianne Sousa
 * @since 07/05/2013
 * */
public class EmpresaContabilTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String numeroFax;
		
	private String email;
	
	//private byte[] logomarca;

	private String rua;
	
	private String numeroEndereco;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	private String enderecoFormatado;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
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

	public String getEnderecoFormatado() {
		return enderecoFormatado;
	}

	public void setEnderecoFormatado(String enderecoFormatado) {
		this.enderecoFormatado = enderecoFormatado;
	}

	public EmpresaContabil getEmpresaContabil() {
		
		EmpresaContabil empresaContabil = new EmpresaContabil();
		
		Endereco endereco = new Endereco();
		//TODO endereco.setNome(nome) ???
		endereco.setCodigoCep(new Integer(this.cep.replace("-", "")));
		endereco.setDescricaoLogradouro(this.rua);
		endereco.setNumeroEndereco(new Integer(this.numeroEndereco));
		endereco.setDescricaoComplemento(this.complemento);
		endereco.setBairro(this.bairro);
		endereco.setNomeCidade(this.cidade);
		endereco.setDescricaoSiglaUf(this.estado);
		empresaContabil.setEndereco(endereco);

		empresaContabil.setRazaoSocial(this.razaoSocial);
		empresaContabil.setNomeFantasia(this.nomeFantasia);
		empresaContabil.setCnpj(this.cnpj);
		empresaContabil.setNumeroFax(this.numeroFax);
		empresaContabil.setEmail(this.email);
		
//		empresaContabil.setLogomarca(logomarca);
		
		return empresaContabil;
		
	}
	
}
