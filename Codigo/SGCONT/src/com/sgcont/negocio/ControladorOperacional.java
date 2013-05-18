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
 * Controlador respons�vel pelas regras de neg�cio do m�dulo operacional
 * */
public class ControladorOperacional implements IControladorOperacional {

	private static ControladorOperacional instance;

	protected IRepositorioOperacional repositorioOperacional = null;
	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorOperacional getInstance(){
		if (instance == null){
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
	 * M�todo respons�vel pesquisar um tipo de despesa a partir da descri��o
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * 
	 * @param descri��o
	 * @return TipoDespesa
	 * */
	public TipoDespesa pesquisarTipoDespesa(String descricao){
		
		return this.repositorioOperacional.pesquisarTipoDespesa(descricao);
		
	}
	
	/**
	 * [UC013] Inserir Despesa
	 * 
	 * M�todo respons�vel cadastrar uma despesa
	 * 
	 * @author Vivianne Sousa
	 * @since 14/05/2013
	 * */
	public void inserirDespesa(DespesaTO despesaTO) {
		
		Despesa despesa = despesaTO.getDespesa();
		
		despesa.setUltimaAlteracao(new Date());
		
		this.repositorioUtil.inserirOuAtualizar(despesa);
		
	}

	
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
	public TipoReceita pesquisarTipoReceita(String descricao) {
		
		return this.repositorioOperacional.pesquisarTipoReceita(descricao);
		
	}
	
	
	/**
	 * [UC011] Inserir Receita 
	 * 
	 * M�todo respons�vel cadastrar uma receita
	 * 
	 * @author R�mulo Aur�lio
	 * @since 23/04/2013
	 * */
	public void inserirReceita(ReceitaTO receitaTO) {
		
		if(receitaTO != null){
			
			receitaTO.setReceita(receitaTO);
			
			Receita receita = receitaTO.getReceita();

			repositorioUtil.inserirOuAtualizar(receita);
		}
		
		
	}
}
