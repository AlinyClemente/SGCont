package com.sgcont.repositorio;

import com.sgcont.dados.operacional.TipoDespesa;

/**
 * Interface do reposit�rio respons�vel pelas consultas do m�dulo operacional
 * */
public interface IRepositorioOperacional {

	
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
}
