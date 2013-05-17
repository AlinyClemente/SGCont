package com.sgcont.negocio;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.transferobject.DespesaTO;

/**
 * Interface do controlador responsável pelas regras de negócio do módulo operacional
 * */
public interface IControladorOperacional {

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável pesquisar um tipo de despesa a partir da descrição
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * 
	 * @param descrição
	 * @return TipoDespesa
	 * */
	public TipoDespesa pesquisarTipoDespesa(String descricao);
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável cadastrar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 14/05/2013
	 * */
	public void inserirDespesa(DespesaTO despesaTO);
}
