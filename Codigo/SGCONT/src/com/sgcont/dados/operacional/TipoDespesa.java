package com.sgcont.dados.operacional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "operacional.tipo_despesa")
public class TipoDespesa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="operacional.seq_tipo_despesa")
	@SequenceGenerator(name="operacional.seq_tipo_despesa", sequenceName="operacional.seq_tipo_despesa")
	@Column(name="cdtipodespesa", nullable=false)
	private Integer codigo;
	
	@Column(name="descricao", nullable=false, length=50)
	private String descricao;
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
		
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

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

	
	
}
