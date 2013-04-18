package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.cliente_pf")
public class ClientePessoaFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	//TODO verificar tipo
	@Column(name="sexo", nullable=false)
	private Short sexo;
	
	@Column(name="icdeclaracaoir", nullable=false)
	private Short indicadorDeclaracaoIr;

	@Column(name="nntituloeleitor", nullable=false, length=20)
	private String numeroTituloEleitor;
	
	@Column(name="cdbanco", nullable=true)
	private Integer codigoBanco;

	@Column(name="nnagencia", nullable=true, length=10)
	private String numeroAgencia;

	@Column(name="nnconta", nullable=true, length=10)
	private String numeroConta;
	
	@Column(name="icuso", nullable=false)
	private Short indicadorUso;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdprofissao", 
            insertable=true, updatable=true, 
            nullable=false)
	private Profissao profissao;
	
}
