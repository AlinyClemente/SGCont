package com.sgcont.negocio;

import java.util.Date;

import com.sgcont.dados.operacional.Despesa;
import com.sgcont.dados.operacional.Receita;
import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.repositorio.IRepositorioOperacional;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioOperacional;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.DespesaTO;
import com.sgcont.transferobject.ReceitaTO;

/**
 * Controlador responsável pelas regras de negócio do módulo operacional
 * */
public class ControladorOperacional implements IControladorOperacional {

	private static ControladorOperacional instance;

	protected IRepositorioOperacional repositorioOperacional = null;
	protected IRepositorioUtil repositorioUtil = null;

	public static synchronized IControladorOperacional getInstance() {
		if (instance == null) {
			instance = new ControladorOperacional();
		}
		return instance;
	}

	private ControladorOperacional() {

		repositorioOperacional = RepositorioOperacional.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();

	}

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
	public TipoDespesa pesquisarTipoDespesa(String descricao) {

		return this.repositorioOperacional.pesquisarTipoDespesa(descricao);

	}

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * Método responsável cadastrar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 14/05/2013
	 * */
	public void inserirDespesa(DespesaTO despesaTO) {

		Despesa despesa = despesaTO.getDespesa();

		despesa.setUltimaAlteracao(new Date());
		despesa.setIndicadorUso(new Short("1"));

		this.repositorioUtil.inserirOuAtualizar(despesa);

	}

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
	public TipoReceita pesquisarTipoReceita(String descricao) {

		return this.repositorioOperacional.pesquisarTipoReceita(descricao);

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável cadastrar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO) {

		if (receitaTO != null) {

			Receita receita = receitaTO.getReceita();
			receita.setUltimaAlteracao(new Date());

			receita.setIndicadorUso((new Integer(1)).shortValue());

			repositorioUtil.inserirOuAtualizar(receita);
		}

	}

	/**
	 * [UC012] Manter Receita
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarReceita(ReceitaTO receitaTO) {
		
		if(receitaTO != null){
			
			Receita receita = receitaTO.getReceita();
			receita.setUltimaAlteracao(new Date());
			
			repositorioUtil.inserirOuAtualizar(receita);
		}

	}

	
	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável atualizar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * */
	public void atualizarDespesa(DespesaTO despesaTO) {
		
		Despesa despesa = despesaTO.getDespesa();
		
		despesa.setUltimaAlteracao(new Date());
		
		this.repositorioUtil.inserirOuAtualizar(despesa);
		
	}

}
