package com.sgcont.negocio;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.transferobject.DespesaTO;

/**
 * Interface do controlador respons�vel pelas regras de neg�cio do m�dulo operacional
 * */
public interface IControladorOperacional {

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * M�todo respons�vel pesquisar um tipo de despesa a partir da descri��o
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * 
	 * @param descri��o
	 * @return TipoDespesa
	 * */
	public TipoDespesa pesquisarTipoDespesa(String descricao);
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * M�todo respons�vel cadastrar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 14/05/2013
	 * */
	public void inserirDespesa(DespesaTO despesaTO);
}
