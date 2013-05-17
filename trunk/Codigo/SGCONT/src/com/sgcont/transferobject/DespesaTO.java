package com.sgcont.transferobject;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.operacional.Despesa;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.util.Util;

/**
 * [UC013] Inserir Despesa
 * 
 * @author Vivianne Sousa
 * @since 23/04/2013
 * */
public class DespesaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private String valor;
	
	private String datadespesa;
	
	private String observacao;
		
	private ClienteTO cliente;
	
	private TipoDespesa tipoDespesa;
	
	private EmpresaContabil empresaContabil;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDatadespesa() {
		return datadespesa;
	}

	public void setDatadespesa(String datadespesa) {
		this.datadespesa = datadespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ClienteTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTO cliente) {
		this.cliente = cliente;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public EmpresaContabil getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(EmpresaContabil empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public Despesa getDespesa() {
		Despesa despesa = new Despesa();
		
		despesa.setDescricao(this.descricao);
		despesa.setValor(new BigDecimal(this.valor));
		despesa.setDataDespesa(Util.converterStringParaDate(this.datadespesa));
		despesa.setObservacao(this.observacao);
		
//		TipoDespesa tipoDespesaSelecionado = new TipoDespesa();
//		tipoDespesaSelecionado.setCodigo(new Integer(this.tipoDespesa));
//		despesa.setTipoDespesa(tipoDespesaSelecionado);
		despesa.setTipoDespesa(this.tipoDespesa);
		
		if(this.cliente != null && !this.cliente.equals("")){
//			Cliente clienteSelecionado = new Cliente();
//			clienteSelecionado.setCodigo(new Integer(this.cliente));
//			despesa.setCliente(clienteSelecionado);
			despesa.setCliente(this.cliente.getCliente());
		}
		
		if(this.empresaContabil != null && !this.empresaContabil.equals("")){
//			EmpresaContabil empresaContabilSelecionada = new EmpresaContabil();
//			empresaContabilSelecionada.setCodigo(new Integer(this.empresaContabil));
//			despesa.setEmpresaContabil(empresaContabilSelecionada);
			despesa.setEmpresaContabil(this.empresaContabil);
		}
		
		return despesa;
	}
}
