package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.util.HibernateUtil;

/**
 * Repositório responsável pelas consultas do módulo da agenda
 * */
public class RepositorioAgenda implements IRepositorioAgenda {

	private static IRepositorioAgenda instance;

	public static IRepositorioAgenda getInstancia() {
		if (instance == null) {
			instance = new RepositorioAgenda();
		}
		return instance;
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável pesquisar os compromissos a partir do usuário
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoUsuario
	 * @return Collection<Compromisso>
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Compromisso> pesquisarCompromisso(Integer codigoUsuario) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT compr "
				+ " FROM CompromissoResponsavel compresp "
				+ "   INNER JOIN compresp.compromisso compr "
				+ " WHERE compresp.usuario.codigo = :codigoUsuario ";
		
		Collection<Compromisso> colecaoCompromisso = (Collection<Compromisso>) 
				session.createQuery(consulta)
	                .setParameter("codigoUsuario", codigoUsuario)
	                .list();

		HibernateUtil.closeSession(session);
				
		return colecaoCompromisso;
				
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável pesquisar os responsáveis a partir do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoCompromisso
	 * @return Collection<Usuario>
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Usuario> pesquisarResponsaveis(Integer codigoCompromisso) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT usur "
				+ " FROM CompromissoResponsavel compresp "
				+ "   INNER JOIN compresp.usuario usur "
				+ " WHERE compresp.compromisso.codigo = :codigoCompromisso "
				+ "   and usur.indicadorUso = 1 ";
		
		Collection<Usuario> colecaoUsuario = (Collection<Usuario>) 
				session.createQuery(consulta)
	                .setParameter("codigoCompromisso", codigoCompromisso)
	                .list();

		HibernateUtil.closeSession(session);
				
		return colecaoUsuario;
				
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável pesquisar os lembretes que ainda não foram enviados por email
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Object[]> pesquisarLembretesPendentes() {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT lembr.codigo, compr.codigo, compr.dataInicioCompromisso, compr.descricaoCompromisso "
				+ " FROM Lembrete lembr "
				+ "   JOIN lembr.compromisso compr "
				+ " WHERE lembr.indicadorFrequencia = 2 "
				+ "   and lembr.dataLembrete <= :dataAtual ";
		
		Collection<Object[]> colecaoDados = (Collection<Object[]>) session
				.createQuery(consulta)
                .setParameter("dataAtual", new Date())
                .list();

		HibernateUtil.closeSession(session);
				
		return colecaoDados;
				
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável pesquisar os dados do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Object[]> pesquisarCompromissoResponsaveis(Integer codigoCompromisso) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT usur.nome, usur.email "
				+ " FROM CompromissoResponsavel compresp "
				+ "   JOIN compresp.compromisso compr "
				+ "   JOIN compresp.usuario usur "
				+ " WHERE compr.codigo = :codigoCompromisso ";
		
		Collection<Object[]> colecaoDados = (Collection<Object[]>) session
				.createQuery(consulta)
                .setParameter("codigoCompromisso", codigoCompromisso)
                .list();

		HibernateUtil.closeSession(session);
				
		return colecaoDados;
				
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * Método responsável por atualizar o lembrete
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @parm codigoLembrete
	 * */
	public void atualizarLembretePendente(Integer codigoLembrete) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "UPDATE Lembrete "
				+ " SET indicadorFrequencia = 1 "
				+ " WHERE codigo = :codigoLembrete ";
		
		session.createQuery(consulta)
                .setParameter("codigoLembrete", codigoLembrete)
                .executeUpdate();

		HibernateUtil.closeSession(session);
				
	}

}
