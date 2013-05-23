package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "cadastro.empresa_contabil")
public class EmpresaContabil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdempresacontabil", nullable=false)
	private Integer codigo;
	
	@Column(name="razaosocial", nullable=false, length=120)
	private String razaoSocial;
	
	@Column(name="nomefantasia", nullable=true, length=120)
	private String nomeFantasia;
	
	@Column(name="cnpj", nullable=false, length=14)
	private String cnpj;

	@Column(name="nntelefone", nullable=false, length=20)
	private String numeroTelefone;

	@Column(name="email", nullable=true, length=30)
	private String email;
		
	
	@Lob
	@Column(name="logomarca", nullable=true, columnDefinition = "bytea") 
    @Type(type="org.hibernate.type.BinaryType")  
	private byte[] logomarca;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdendereco", insertable=true, updatable=true, nullable=false)
	private Endereco endereco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(byte[] logomarca) {
		this.logomarca = logomarca;
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
