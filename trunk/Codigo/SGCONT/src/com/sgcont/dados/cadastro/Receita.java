package com.sgcont.dados.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cadastro.receita")
public class Receita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo", nullable=false)
	private Integer codigo;
	
	
	@Column(name="descricao", nullable=false, length=50)
	private String descricao;

	@Column(name="observacao", nullable=true, length=300)
	private String observacao;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	
	@Column(name="dtreceita", nullable=false)
	private Date dataReceita;
	
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdcliente", 
            insertable=true, updatable=true, 
            nullable=true)
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name="cdempresacontabil", 
            insertable=true, updatable=true, 
            nullable=true)
	private EmpresaContabil empresaContabil;
	

	@ManyToOne
    @JoinColumn(name="cdtiporeceita", 
            insertable=true, updatable=true, 
            nullable=true)
	private TipoReceita tipoReceita;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Date dataReceita) {
		this.dataReceita = dataReceita;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EmpresaContabil getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(EmpresaContabil empresaContabil) {
		this.empresaContabil = empresaContabil;
	}
	
	
	
	
}
