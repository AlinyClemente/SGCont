package com.sgcont.negocio;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.transferobject.DespesaTO;
import com.sgcont.transferobject.ReceitaTO;

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
	
	
	/**
	 * [UC011] Inserir Receita 
	 * 
	 * Método responsável cadastrar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO);
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar um tipo de receita a partir do nome
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return TipoReceita
	 * */
	public TipoReceita pesquisarTipoReceita(String descricao);

	/**
	 * [UC012] Manter Receita 
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarReceita(ReceitaTO receitaTO) ;
	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável atualizar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public void atualizarDespesa(DespesaTO despesaTO);
	
}
