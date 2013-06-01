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
@Table(name = "operacional.compromisso")
public class Compromisso {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="operacional.seq_compromisso")
	@SequenceGenerator(name="operacional.seq_compromisso", sequenceName="operacional.seq_compromisso")
	@Column(name="cdcompromisso", nullable=false)
	private Integer codigo;
	
	@Column(name="tmInicioCompromisso", nullable=false)
	private Date dataInicioCompromisso;
	
	@Column(name="tmFimCompromisso", nullable=false)
	private Date dataFimCompromisso;
	
	@Column(name="dscompromisso", nullable=false, length=50)
	private String descricaoCompromisso;
	
	@Column(name="observacao", nullable=true, length=300)
	private String observacao;
	
	@Column(name="icrecorrente", nullable=false)
	private Short indicadorRecorrente;
	
	@Column(name="nnrepetir", nullable=true)
	private Integer quantidadeRepetir;
	
	@Column(name="icfrequencia", nullable=true)
	private Short indicadorFrequencia;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
	@JoinColumn(name="cdcompromissoprincipal", 
            insertable=true, updatable=true, 
            nullable=true)
	private Compromisso compromissoPrincipal;

	public Compromisso() {
		
	}
	
	public Compromisso(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Date getDataInicioCompromisso() {
		return dataInicioCompromisso;
	}

	public void setDataInicioCompromisso(Date dataInicioCompromisso) {
		this.dataInicioCompromisso = dataInicioCompromisso;
	}

	public Date getDataFimCompromisso() {
		return dataFimCompromisso;
	}

	public void setDataFimCompromisso(Date dataFimCompromisso) {
		this.dataFimCompromisso = dataFimCompromisso;
	}

	public String getDescricaoCompromisso() {
		return descricaoCompromisso;
	}

	public void setDescricaoCompromisso(String descricaoCompromisso) {
		this.descricaoCompromisso = descricaoCompromisso;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Short getIndicadorRecorrente() {
		return indicadorRecorrente;
	}

	public void setIndicadorRecorrente(Short indicadorRecorrente) {
		this.indicadorRecorrente = indicadorRecorrente;
	}

	public Integer getQuantidadeRepetir() {
		return quantidadeRepetir;
	}

	public void setQuantidadeRepetir(Integer quantidadeRepetir) {
		this.quantidadeRepetir = quantidadeRepetir;
	}

	public Short getIndicadorFrequencia() {
		return indicadorFrequencia;
	}

	public void setIndicadorFrequencia(Short indicadorFrequencia) {
		this.indicadorFrequencia = indicadorFrequencia;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Compromisso getCompromissoPrincipal() {
		return compromissoPrincipal;
	}

	public void setCompromissoPrincipal(Compromisso compromissoPrincipal) {
		this.compromissoPrincipal = compromissoPrincipal;
	}
	
}
