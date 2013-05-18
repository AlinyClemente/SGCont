package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.Endereco;

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
	
	private String numeroEndereco;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	private String numeroTelefone;
	
	private String email;
	
	private String inscricaoMunicipal;
	
	private String observacao;
	
	private String enderecoFormatado;
	
	private String documento;

	private String cpf;

	private String cnpj;

	private String codigo;

	public Cliente getCliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(this.nome);
		cliente.setIndicadorPessoaFisica(
				new Short(this.indicadorPessoaFisica));
		
		Endereco endereco = new Endereco();
		//TODO endereco.setNome(nome) ???
		endereco.setCodigoCep(
				new Integer(this.cep.replace("-", "")));
		endereco.setDescricaoLogradouro(this.rua);
		endereco.setNumeroEndereco(
				new Integer(this.numeroEndereco));
		endereco.setDescricaoComplemento(this.complemento);
		endereco.setBairro(this.bairro);
		endereco.setNomeCidade(this.cidade);
		endereco.setDescricaoSiglaUf(this.estado);
		cliente.setEndereco(endereco);

		cliente.setNumeroTelefone(this.numeroTelefone);
		cliente.setEmail(this.email);
		cliente.setInscricaoMunicipal(this.inscricaoMunicipal);
		cliente.setObservacao(this.observacao);
		
		return cliente;
		
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

	public String getEnderecoFormatado() {
		return enderecoFormatado;
	}

	public void setEnderecoFormatado(String enderecoFormatado) {
		this.enderecoFormatado = enderecoFormatado;
	}

	

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String getNumeroCpfFormatado() {
		String cpfFormatado = this.cpf;

		if (cpfFormatado != null && cpfFormatado.length() == 11) {

			cpfFormatado = cpfFormatado.substring(0, 3) + "."
					+ cpfFormatado.substring(3, 6) + "."
					+ cpfFormatado.substring(6, 9) + "-"
					+ cpfFormatado.substring(9, 11);
		}
		
		return cpfFormatado;
	}
	
	public void setardocumento() {
		if (this.cpf != null && !this.cpf.equals("")) {
			this.documento = getNumeroCpfFormatado();
		} else if (this.cnpj != null && !this.cnpj.equals("")) {
			this.documento = this.getNumeroCnpjFormatado();
		}
	}
	
	public String getNumeroCnpjFormatado() {
		String cnpjFormatado = this.cnpj;
		String zeros = "";
		
		if (cnpjFormatado != null) {
			
			for (int a = 0; a < (14 - cnpjFormatado.length()); a++) {
				zeros = zeros.concat("0");
			}
			// concatena os zeros ao numero
			// caso o numero seja diferente de nulo
			cnpjFormatado = zeros.concat(cnpjFormatado);
			
			cnpjFormatado = cnpjFormatado.substring(0, 2) + "."
					+ cnpjFormatado.substring(2, 5) + "."
					+ cnpjFormatado.substring(5, 8) + "/"
					+ cnpjFormatado.substring(8, 12) + "-"
					+ cnpjFormatado.substring(12, 14);
		}
		
		return cnpjFormatado;
	}
	
	
	
}
