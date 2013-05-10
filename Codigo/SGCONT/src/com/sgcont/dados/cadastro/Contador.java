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
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.contador")
@Inheritance(strategy=InheritanceType.JOINED)
public class Contador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdcontador", nullable=false)
	private Integer codigo;
	
	@Column(name="cdidentificacao", nullable=false, length=20)
	private String codigoIdentificacao;
	
	@Column(name="nmrazaosocial", nullable=false, length=70)
	private String nomeRazaoSocial;

	@Column(name="nncrc", nullable=false)
	private Integer numeroCrc;

	@Column(name="nntelefone", nullable=false, length=20)
	private String numeroTelefone;

	@Column(name="nnfax", nullable=true, length=20)
	private String numeroFax;

	@Column(name="email", nullable=true, length=30)
	private String email;
	
	@Column(name="icresponsavel", nullable=false)
	private Short indicadorResponsavel;
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdendereco", 
            insertable=true, updatable=true, 
            nullable=true)
	private Endereco endereco;

	@ManyToOne
    @JoinColumn(name="cdempresacontabil", 
            insertable=true, updatable=true, 
            nullable=true)
	private EmpresaContabil empresaContabil;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoIdentificacao() {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao(String codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public Integer getNumeroCrc() {
		return numeroCrc;
	}

	public void setNumeroCrc(Integer numeroCrc) {
		this.numeroCrc = numeroCrc;
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

	public Short getIndicadorResponsavel() {
		return indicadorResponsavel;
	}

	public void setIndicadorResponsavel(Short indicadorResponsavel) {
		this.indicadorResponsavel = indicadorResponsavel;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EmpresaContabil getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(EmpresaContabil empresaContabil) {
		this.empresaContabil = empresaContabil;
	}
	
}
