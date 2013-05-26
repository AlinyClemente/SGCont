package com.sgcont.negocio;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.transferobject.DespesaTO;
import com.sgcont.transferobject.ReceitaTO;

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
	
	
	/**
	 * [UC011] Inserir Receita 
	 * 
	 * M�todo respons�vel cadastrar uma receita
	 * 
	 * @author R�mulo Aur�lio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO);
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar um tipo de receita a partir do nome
	 * 
	 * @author R�mulo Aur�lio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return TipoReceita
	 * */
	public TipoReceita pesquisarTipoReceita(String descricao);

	/**
	 * [UC012] Manter Receita 
	 * 
	 * M�todo respons�vel atualizar uma receita
	 * 
	 * @author R�mulo Aur�lio
	 * @since 25/05/2013
	 * */
	public void atualizarReceita(ReceitaTO receitaTO) ;
	/**
	 * [UC014] Manter Despesa
	 * 
	 * M�todo respons�vel atualizar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public void atualizarDespesa(DespesaTO despesaTO);
	
}
