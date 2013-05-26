package com.sgcont.dados.operacional;

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

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.transferobject.ClienteTO;

@Entity
@Table(name = "operacional.despesa")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cddespesa", nullable=false)
	private Integer codigo;
	
	@Column(name="descricao", nullable=false, length=50)
	private String descricao;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	@Column(name="dtdespesa", nullable=false)
	private Date dataDespesa;
	
	@Column(name="observacao", nullable=true, length=300)
	private String observacao;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@ManyToOne
    @JoinColumn(name="cdcliente", insertable=true, updatable=true, nullable=true)
	private Cliente cliente;
	 
	@ManyToOne
    @JoinColumn(name="cdtipodespesa", insertable=true, updatable=true, nullable=false)
	private TipoDespesa tipoDespesa;
	
	@ManyToOne
    @JoinColumn(name="cdempresacontabil", insertable=true, updatable=true, nullable=true)
	private EmpresaContabil empresaContabil;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public EmpresaContabil getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(EmpresaContabil empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

}
