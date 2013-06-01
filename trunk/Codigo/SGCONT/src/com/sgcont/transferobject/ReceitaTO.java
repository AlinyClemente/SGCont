package com.sgcont.transferobject;

import java.io.Serializable;

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

	private String codigo;

	private String descricao;

	private TipoReceita tipoReceita;

	private String valor;

	private String dataGeracao;

	private EmpresaContabil empresaContabil;

	private ClienteTO clienteTO;

	private String observacao;

	private String indicadorUso;

	@SuppressWarnings("unused")
	private Receita receita = new Receita();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso) {
		this.indicadorUso = indicadorUso;
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

		Receita receita = new Receita();

		if (this.getCodigo() != null) {
			receita.setCodigo(new Integer(this.getCodigo()));
		}

		if (this.getClienteTO() != null
				&& !this.getClienteTO().getCodigo().toString().equals("")) {
			Cliente cliente = new Cliente();
			cliente.setCodigo(new Integer(this.getClienteTO().getCodigo()));
			receita.setCliente(cliente);
		}

		receita.setDataReceita(Util.converterStringParaDate(this
				.getDataGeracao()));

		receita.setTipoReceita(this.tipoReceita);

		if (this.getEmpresaContabil() != null
				&& !this.getEmpresaContabil().equals("")) {

			receita.setEmpresaContabil(empresaContabil);

		}

		receita.setDescricao(this.descricao);

		if (this.observacao != null && !this.observacao.equals("")) {
			receita.setObservacao(this.observacao);
		}
		receita.setValor(Util.formatarMoedaRealparaBigDecimal(this.valor));

		if (this.indicadorUso != null) {
			receita.setIndicadorUso(new Short(this.indicadorUso));
		}

		return receita;
	}

	public ReceitaTO(Receita receita) {
		super();
		if (receita.getCodigo() != null) {
			this.codigo = receita.getCodigo().toString();
		}
		this.descricao = receita.getDescricao();
		this.valor = Util.formatarMoedaReal(receita.getValor());
		this.dataGeracao = (Util.formatarData(receita.getDataReceita()));
		this.observacao = receita.getObservacao();
		this.tipoReceita = receita.getTipoReceita();
		this.empresaContabil = receita.getEmpresaContabil();
		this.indicadorUso = receita.getIndicadorUso().toString();
	}

	public ReceitaTO() {
		super();
	}

}
