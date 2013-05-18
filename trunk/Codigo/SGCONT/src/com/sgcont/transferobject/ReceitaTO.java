package com.sgcont.transferobject;

import java.io.Serializable;
import java.util.Date;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.operacional.Receita;
import com.sgcont.dados.operacional.TipoReceita;
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
	
	private TipoReceita tipoReceita;
	
	private String valor;
	
	private String dataGeracao;
	
	private EmpresaContabil empresaContabil;
	
	private ClienteTO clienteTO;
	
	private String observacao;

	private Receita receita = new Receita();
	
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

	public String getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	
	

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public EmpresaContabil getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(EmpresaContabil empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	
	public ClienteTO getClienteTO() {
		return clienteTO;
	}

	public void setClienteTO(ClienteTO clienteTO) {
		this.clienteTO = clienteTO;
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
		
		if(receitaTO.getClienteTO() != null 
				&& !receitaTO.getClienteTO().getCodigo().toString().equals("")){
			Cliente cliente = new Cliente();
			cliente.setCodigo(new Integer(receitaTO.getClienteTO().getCodigo()));
			this.receita.setCliente(cliente);
		}
		
		this.receita.setDataReceita(new Date());
		
		this.receita.setTipoReceita(tipoReceita);
		
		if(receitaTO.getEmpresaContabil() != null 
				&& !receitaTO.getEmpresaContabil().equals("")){
		
			this.receita.setEmpresaContabil(empresaContabil);
		
		}
		
		this.receita.setDescricao(receitaTO.getDescricao());
		
		this.receita.setObservacao(receitaTO.getObservacao());
		
		this.receita.setUltimaAlteracao(new Date());
		
		this.receita.setIndicadorUso((new Integer(1)).shortValue());
		
		this.receita.setValor(Util.formatarMoedaRealparaBigDecimal(receitaTO.getValor()));
		
		
		
	}
	
	
	

}
