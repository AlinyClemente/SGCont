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

import com.sgcont.dados.cadastro.Usuario;

@Entity
@Table(name = "operacional.compromisso_responsaveis")
public class CompromissoResponsavel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="operacional.seq_compromisso_responsaveis")
	@SequenceGenerator(name="operacional.seq_compromisso_responsaveis", sequenceName="operacional.seq_compromisso_responsaveis")
	@Column(name="cdcompresponsaveis", nullable=false)
	private Integer codigo;

	@Column(name="icResponsavel", nullable=true)
	private Short indicadorResponsavel;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
	@JoinColumn(name="cdcompromisso", 
            insertable=true, updatable=true, 
            nullable=false)
	private Compromisso compromisso;
	
	@ManyToOne
	@JoinColumn(name="cdusuario", 
            insertable=true, updatable=true, 
            nullable=false)
	private Usuario usuario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Short getIndicadorResponsavel() {
		return indicadorResponsavel;
	}

	public void setIndicadorResponsavel(Short indicadorResponsavel) {
		this.indicadorResponsavel = indicadorResponsavel;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
