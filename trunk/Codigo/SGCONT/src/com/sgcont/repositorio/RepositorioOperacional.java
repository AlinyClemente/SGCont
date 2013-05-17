package com.sgcont.repositorio;

import org.hibernate.Session;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.util.HibernateUtil;

/**
 * Repositório responsável pelas consultas do módulo operacional
 * */
public class RepositorioOperacional implements IRepositorioOperacional {

	private static IRepositorioOperacional instance;

	public static IRepositorioOperacional getInstancia() {
		if (instance == null) {
			instance = new RepositorioOperacional();
		}
		return instance;
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
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT tpDe "
				+ " FROM TipoDespesa tpDe "
				+ " WHERE tpDe.descricao = :descricao ";
		
		TipoDespesa tipoDespesa = 
				(TipoDespesa) session
					.createQuery(consulta)
	                .setParameter("descricao", descricao)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return tipoDespesa;
				
	}
}
