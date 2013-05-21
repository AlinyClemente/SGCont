package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdendereco", nullable=false)
	private Integer codigo;

	@Column(name="cdcep", nullable=false)
	private Integer codigoCep;
	
	@Column(name="dslogradouro", nullable=false, length=50)
	private String descricaoLogradouro;
	
	@Column(name="nnEndereco", nullable=false)
	private Integer numeroEndereco;
	
	@Column(name="dscomplemento", nullable=true, length=20)
	private String descricaoComplemento;
	
	@Column(name="nnbairro", nullable=true, length=30)
	private String bairro;
	
	@Column(name="dssiglauf", nullable=false, length=2)
	private String descricaoSiglaUf;
	
	@Column(name="nmcidade", nullable=false, length=50)
	private String nomeCidade;

	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoCep() {
		return codigoCep;
	}

	public void setCodigoCep(Integer codigoCep) {
		this.codigoCep = codigoCep;
	}

	public String getDescricaoLogradouro() {
		return descricaoLogradouro;
	}

	public void setDescricaoLogradouro(String descricaoLogradouro) {
		this.descricaoLogradouro = descricaoLogradouro;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getDescricaoComplemento() {
		return descricaoComplemento;
	}

	public void setDescricaoComplemento(String descricaoComplemento) {
		this.descricaoComplemento = descricaoComplemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDescricaoSiglaUf() {
		return descricaoSiglaUf;
	}

	public void setDescricaoSiglaUf(String descricaoSiglaUf) {
		this.descricaoSiglaUf = descricaoSiglaUf;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
	
}
