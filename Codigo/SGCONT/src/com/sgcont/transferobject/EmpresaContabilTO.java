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
	
	private String numeroTelefone;
		
	private String email;
	
	private byte[] logomarca;

	public byte[] getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(byte[] logomarca) {
		this.logomarca = logomarca;
	}

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
		
        String cnpj = ((String) this.cnpj)
				.replace(".", "")
				.replace("/", "")
				.replace("-", "");
		
		empresaContabil.setCnpj(cnpj);
		empresaContabil.setNumeroTelefone(this.numeroTelefone);
		if(this.email != null && !this.email.equals("")){
			empresaContabil.setEmail(this.email);
		}
		empresaContabil.setLogomarca(this.logomarca);
		
		return empresaContabil;
		
	}
	
}
