package com.sgcont.dados.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro.endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdendereco", nullable=false)
	private Integer codigo;
	
	@Column(name="descricaorua", nullable=false, length=50)
	private String descricaoRua;
	
	@Column(name="descricaocomplemento", nullable=true, length=20)
	private String descricaoComplemento;

	@Column(name="codigocep", nullable=false)
	private Integer codigoCep;

	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	//TODO adicionar Endereço!!!
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoRua() {
		return descricaoRua;
	}

	public void setDescricaoRua(String descricaoRua) {
		this.descricaoRua = descricaoRua;
	}

	public String getDescricaoComplemento() {
		return descricaoComplemento;
	}

	public void setDescricaoComplemento(String descricaoComplemento) {
		this.descricaoComplemento = descricaoComplemento;
	}

	public Integer getCodigoCep() {
		return codigoCep;
	}

	public void setCodigoCep(Integer codigoCep) {
		this.codigoCep = codigoCep;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
	
}
