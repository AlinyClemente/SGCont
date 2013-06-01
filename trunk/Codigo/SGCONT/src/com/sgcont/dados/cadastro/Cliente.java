package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.cliente")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente {

	public static final  Short INDICADOR_PESSOA_FISICA = new Short("1");
	public static final  Short INDICADOR_PESSOA_JURIDICA = new Short("2");
	
	public static final  Short INDICADOR_ATIVO = new Short("1");
	public static final  Short INDICADOR_INATIVO = new Short("2");
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cadastro.seq_cliente")
	@SequenceGenerator(name="cadastro.seq_cliente", sequenceName="cadastro.seq_cliente")
	@Column(name="cdcliente", nullable=false)
	private Integer codigo;
	
	@Column(name="nmcliente", nullable=false, length=100)
	private String nome;
	
	@Column(name="nntelefone", nullable=false, length=20)
	private String numeroTelefone;

	@Column(name="nnfax", nullable=true, length=20)
	private String numeroFax;

	@Column(name="email", nullable=true, length=30)
	private String email;
	
	@Column(name="icpessoafisica", nullable=false)
	private Short indicadorPessoaFisica;
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@Column(name="inscricaomunicipal", nullable=false, length=14)
	private String inscricaoMunicipal;
	
	@Column(name="observacao", nullable=true, length=500)
	private String observacao;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdendereco", 
            insertable=true, updatable=true, 
            nullable=false)
	private Endereco endereco;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getIndicadorPessoaFisica() {
		return indicadorPessoaFisica;
	}

	public void setIndicadorPessoaFisica(Short indicadorPessoaFisica) {
		this.indicadorPessoaFisica = indicadorPessoaFisica;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
