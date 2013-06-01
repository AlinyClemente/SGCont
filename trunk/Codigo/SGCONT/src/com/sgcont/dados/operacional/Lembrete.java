package com.sgcont.dados.operacional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "operacional.lembrete")
public class Lembrete {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="operacional.seq_lembrete")
	@SequenceGenerator(name="operacional.seq_lembrete", sequenceName="operacional.seq_lembrete")
	@Column(name="cdlembrete", nullable=false)
	private Integer codigo;
	
	@Column(name="dslembrete", nullable=true, length=255)
	private String descricaoLembrete;
	
	@Column(name="tmlembrete", nullable=false)
	private Date dataLembrete;
	
	@Column(name="icEnvioEmail", nullable=true)
	private Short indicadorEnvioEmail;
	
	@Column(name="icunidadelembrete", nullable=true)
	private Short indicadorUnidadeLembrete;
	
	@Column(name="nnvalorlembrete", nullable=true)
	private Integer valorLembrete;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
	@JoinColumn(name="cdcompromisso", 
            insertable=true, updatable=true, 
            nullable=false)
	private Compromisso compromisso;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoLembrete() {
		return descricaoLembrete;
	}

	public void setDescricaoLembrete(String descricaoLembrete) {
		this.descricaoLembrete = descricaoLembrete;
	}

	public Date getDataLembrete() {
		return dataLembrete;
	}

	public void setDataLembrete(Date dataLembrete) {
		this.dataLembrete = dataLembrete;
	}

	public Short getIndicadorEnvioEmail() {
		return indicadorEnvioEmail;
	}

	public void setIndicadorEnvioEmail(Short indicadorEnvioEmail) {
		this.indicadorEnvioEmail = indicadorEnvioEmail;
	}

	public Short getIndicadorUnidadeLembrete() {
		return indicadorUnidadeLembrete;
	}

	public void setIndicadorUnidadeLembrete(Short indicadorUnidadeLembrete) {
		this.indicadorUnidadeLembrete = indicadorUnidadeLembrete;
	}

	public Integer getValorLembrete() {
		return valorLembrete;
	}

	public void setValorLembrete(Integer valorLembrete) {
		this.valorLembrete = valorLembrete;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}
	
}
