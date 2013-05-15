package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.cliente_pf")
@PrimaryKeyJoinColumn(name="cdcliente")
public class ClientePessoaFisica {

	@Id
	@Column(name="cdcliente", nullable=false)
	private Integer codigo;
	
	@Column(name="nnrg", nullable=false, length=9)
	private String numeroRg;
	
	@Column(name="nncpf", nullable=false, length=20)
	private String numeroCpf;

	@Column(name="nncei", nullable=true, length=20)
	private String numeroCei;

	@Column(name="dtnascimento", nullable=false)
	private Date dataNascimento;
	
	@Column(name="sexo", nullable=false)
	private Short sexo;
	
	@Column(name="icdeclaracaoir", nullable=false)
	private Short indicadorDeclaracaoIr;

	@Column(name="nntituloeleitor", nullable=true, length=20)
	private String numeroTituloEleitor;
	
	@Column(name="cdbanco", nullable=true)
	private Integer codigoBanco;

	@Column(name="nnagencia", nullable=true, length=10)
	private String numeroAgencia;

	@Column(name="nnconta", nullable=true, length=10)
	private String numeroConta;

	@ManyToOne
    @JoinColumn(name="cdprofissao", 
            insertable=true, updatable=true, 
            nullable=false)
	private Profissao profissao;
	
	@ManyToOne
	@JoinColumn(name="cdclientetitular", 
            insertable=true, updatable=true, 
            nullable=true)
	private ClientePessoaFisica clienteTitular;
	
	@ManyToOne
	@JoinColumn(name="cdcliente", 
            insertable=false, updatable=false)
	private Cliente cliente;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumeroRg() {
		return numeroRg;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.setCodigo(cliente.getCodigo());
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public String getNumeroCei() {
		return numeroCei;
	}

	public void setNumeroCei(String numeroCei) {
		this.numeroCei = numeroCei;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Short getSexo() {
		return sexo;
	}

	public void setSexo(Short sexo) {
		this.sexo = sexo;
	}

	public Short getIndicadorDeclaracaoIr() {
		return indicadorDeclaracaoIr;
	}

	public void setIndicadorDeclaracaoIr(Short indicadorDeclaracaoIr) {
		this.indicadorDeclaracaoIr = indicadorDeclaracaoIr;
	}

	public String getNumeroTituloEleitor() {
		return numeroTituloEleitor;
	}

	public void setNumeroTituloEleitor(String numeroTituloEleitor) {
		this.numeroTituloEleitor = numeroTituloEleitor;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public ClientePessoaFisica getClienteTitular() {
		return clienteTitular;
	}

	public void setClienteTitular(ClientePessoaFisica clienteTitular) {
		this.clienteTitular = clienteTitular;
	}
	
	public String getNumeroCpfFormatado() {
		String cpfFormatado = this.numeroCpf;

		if (cpfFormatado != null && cpfFormatado.length() == 11) {

			cpfFormatado = cpfFormatado.substring(0, 3) + "."
					+ cpfFormatado.substring(3, 6) + "."
					+ cpfFormatado.substring(6, 9) + "-"
					+ cpfFormatado.substring(9, 11);
		}
		
		return cpfFormatado;
	}
	
}
