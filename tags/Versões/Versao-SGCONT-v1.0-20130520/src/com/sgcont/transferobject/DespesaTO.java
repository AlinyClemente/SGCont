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
		
	private ClienteTO clienteTO;
	
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

	public ClienteTO getClienteTO() {
		return clienteTO;
	}

	public void setClienteTO(ClienteTO clienteTO) {
		this.clienteTO = clienteTO;
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
		
		despesa.setValor(Util.formatarMoedaRealparaBigDecimal(this.valor));
		
		despesa.setDataDespesa(Util.converterStringParaDate(this.datadespesa));
		if(this.observacao != null && !this.observacao.equals("")){
			despesa.setObservacao(this.observacao);
		}

		despesa.setTipoDespesa(this.tipoDespesa);
		
		if(this.clienteTO != null && !this.clienteTO.equals("")){
			Cliente cliente = new Cliente();
			cliente.setCodigo(new Integer(this.clienteTO.getCodigo()));
			despesa.setCliente(cliente);
		}
		
		if(this.empresaContabil != null && !this.empresaContabil.equals("")){
			despesa.setEmpresaContabil(this.empresaContabil);
		}
		
		return despesa;
	}
}
