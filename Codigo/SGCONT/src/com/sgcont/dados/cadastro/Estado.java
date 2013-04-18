package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdestado", nullable=false)
	private Integer codigo;
	
	@Column(name="dsestado", nullable=false, length=40)
	private String descricao;
	
	@Column(name="dssigla", nullable=false, length=2)
	private String descricaoSigla;
	
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

	public String getDescricaoSigla() {
		return descricaoSigla;
	}

	public void setDescricaoSigla(String descricaoSigla) {
		this.descricaoSigla = descricaoSigla;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

}
