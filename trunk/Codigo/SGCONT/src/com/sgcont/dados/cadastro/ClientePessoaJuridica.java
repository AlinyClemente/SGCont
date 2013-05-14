package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.cliente_pj")
@PrimaryKeyJoinColumn(name="cdcliente")
public class ClientePessoaJuridica {

	@Id
	@Column(name="cdcliente", nullable=false)
	private Integer codigo;
	
	@Column(name="razaosocial", nullable=false, length=120)
	private String razaoSocial;
	
	@Column(name="cnpj", nullable=false, length=14)
	private String numeroCnpj;

	@Column(name="inscricaoestadual", nullable=false, length=20)
	private String inscricaoEstadual;

	@Column(name="dtinicioatividade", nullable=true)
	private Date dataInicioAtividade;

	@Column(name="dtfimatividade", nullable=true)
	private Date dataFimAtividade;

	@Column(name="cdsuframa", nullable=true, length=20)
	private String codigoSuframa;
	
	@Column(name="cdnire", nullable=true)
	private Integer codigoNire;

	@Column(name="dssite", nullable=true, length=40)
	private String site;
	
	@ManyToOne
    @JoinColumn(name="cdclientematriz", 
            insertable=true, updatable=true, 
            nullable=true)
	private ClientePessoaJuridica clienteMatriz;

	@ManyToOne
	@JoinColumn(name="cdcliente", 
            insertable=false, updatable=false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name="cdcontadorresponsavel", 
            insertable=true, updatable=true, 
            nullable=false)
	private Contador contador;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNumeroCnpj() {
		return numeroCnpj;
	}

	public void setNumeroCnpj(String numeroCnpj) {
		this.numeroCnpj = numeroCnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Date getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(Date dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public Date getDataFimAtividade() {
		return dataFimAtividade;
	}

	public void setDataFimAtividade(Date dataFimAtividade) {
		this.dataFimAtividade = dataFimAtividade;
	}

	public String getCodigoSuframa() {
		return codigoSuframa;
	}

	public void setCodigoSuframa(String codigoSuframa) {
		this.codigoSuframa = codigoSuframa;
	}

	public Integer getCodigoNire() {
		return codigoNire;
	}

	public void setCodigoNire(Integer codigoNire) {
		this.codigoNire = codigoNire;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public ClientePessoaJuridica getClienteMatriz() {
		return clienteMatriz;
	}

	public void setClienteMatriz(ClientePessoaJuridica clienteMatriz) {
		this.clienteMatriz = clienteMatriz;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.setCodigo(cliente.getCodigo());
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}
	
	public String getNumeroCnpjFormatado() {
		String cnpjFormatado = this.numeroCnpj;
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
