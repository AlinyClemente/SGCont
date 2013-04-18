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
@Table(name = "cadastro.municipio")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cdmunicipio", nullable=false)
	private Integer codigo;
	
	//TODO alterar tamanho!!!
	@Column(name="dsmunicipio", nullable=false, length=50)
	private String descricao;
	
	@Column(name="tmultimaalteracao", nullable=false)
	private Date ultimaAlteracao;

	@ManyToOne
    @JoinColumn(name="cdestado", 
            insertable=true, updatable=true, 
            nullable=false)
	private Estado estado;


}
