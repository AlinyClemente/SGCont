package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.banco")
public class Banco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cadastro.seq_banco")
	@SequenceGenerator(name="cadastro.seq_banco", sequenceName="cadastro.seq_banco")
	@Column(name="cdBanco", nullable=false)
	private Integer codigo;

	@Column(name="dsBanco", nullable=false, length=50)
	private String descricaoBanco;
	
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

	public String getDescricaoBanco() {
		return descricaoBanco;
	}

	public void setDescricaoBanco(String descricaoBanco) {
		this.descricaoBanco = descricaoBanco;
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
