package com.sgcont.transferobject;

import java.io.Serializable;
import java.util.Date;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Receita;
import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.util.Util;


/**
 * [UC011] Inserir Receita
 * 
 * @author Rômulo Aurélio
 * @since 23/04/2013
 * */
public class ReceitaTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private String tipoReceita;
	
	private String valor;
	
	private String dataGeracao;
	
	private String empresaContabil;
	
	private String cliente;
	
	private String observacao;

	private Receita receita = new Receita();
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	
	public String getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(String empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(ReceitaTO receitaTO) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(new Integer(receitaTO.getCliente()));
		
		this.receita.setCliente(cliente);
		
		this.receita.setDataReceita(new Date());
		
		TipoReceita tipoReceita = new TipoReceita();
		tipoReceita.setCodigo(new Integer(receitaTO.getTipoReceita()));
		this.receita.setTipoReceita(tipoReceita);
		
		EmpresaContabil empresa = new EmpresaContabil();
		empresa.setCodigo(new Integer(receitaTO.getEmpresaContabil()));
		this.receita.setEmpresaContabil(empresa);
		
		this.receita.setDescricao(receitaTO.getDescricao());
		
		this.receita.setObservacao(receitaTO.getObservacao());
		
		this.receita.setUltimaAlteracao(new Date());
		
		this.receita.setIndicadorUso((new Integer(1)).shortValue());
		
		//this.receita.setValor(Util.formatarMoedaRealparaBigDecimal(receitaTO.getValor()));
		
		
		
	}
	
	
	

}
