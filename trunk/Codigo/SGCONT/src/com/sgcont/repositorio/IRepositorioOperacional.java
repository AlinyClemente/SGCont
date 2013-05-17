package com.sgcont.repositorio;

import com.sgcont.dados.operacional.TipoDespesa;

/**
 * Interface do repositório responsável pelas consultas do módulo operacional
 * */
public interface IRepositorioOperacional {

	
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
}
