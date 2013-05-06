package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.cliente_pj")
public class ClientePessoaJuridica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	//TODO verificar tipo
	@Column(name="cdnire", nullable=true)
	private Integer codigoNire;

	@Column(name="dssite", nullable=true, length=40)
	private String site;
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdclientematriz", 
            insertable=true, updatable=true, 
            nullable=true)
	private ClientePessoaJuridica clientePessoaJuridica;
	
	//TODO adicionar Contador

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

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public ClientePessoaJuridica getClientePessoaJuridica() {
		return clientePessoaJuridica;
	}

	public void setClientePessoaJuridica(ClientePessoaJuridica clientePessoaJuridica) {
		this.clientePessoaJuridica = clientePessoaJuridica;
	}
	
}
