package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Query;
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
		
		String consulta = "SELECT lembr.codigo, compr.codigo, compr.dataInicioCompromisso, "
				+ "   compr.descricaoCompromisso, compr.observacao "
				+ " FROM Lembrete lembr "
				+ "   JOIN lembr.compromisso compr "
				+ " WHERE lembr.indicadorEnvioEmail = 2 "
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
				+ " SET indicadorEnvioEmail = 1 "
				+ " WHERE codigo = :codigoLembrete ";
		
		session.createQuery(consulta)
                .setParameter("codigoLembrete", codigoLembrete)
                .executeUpdate();

		HibernateUtil.closeSession(session);
				
	}
	
	/**
	 * [UC010] Informar Agenda
	 * [FS0004] - Verificar responsável compromisso
	 *  
	 * Método responsável por verificar se o usuário é o responsável pelo compromisso
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @parm codigoCompromisso
	 * @parm codigoUsuario
	 * @return boolean
	 * */
	public boolean verificarUsuarioResponsavelCompromisso(Integer codigoCompromisso, Integer codigoUsuario) {
		
		Session session = HibernateUtil.getSession();
		
		boolean retorno = false;
		
		String consulta = "SELECT count(*) "
				+ " FROM CompromissoResponsavel compresp "
				+ " WHERE compresp.compromisso.codigo = :codigoCompromisso "
				+ "   and compresp.usuario.codigo = :codigoUsuario "
				+ "   and compresp.indicadorResponsavel = 1 ";
		
		Long quantidade = (Long) 
				session.createQuery(consulta)
			        .setParameter("codigoCompromisso", codigoCompromisso)
			        .setParameter("codigoUsuario", codigoUsuario)
	                .setMaxResults(1).uniqueResult();

		if (quantidade != null
				&& quantidade.compareTo(new Long("0")) > 0) {
			retorno = true;
		}
		
		HibernateUtil.closeSession(session);
		
		return retorno;
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável pesquisar compromissos associados a algum dos usuários 
	 * no mesmo horário do compromisso a ser inserido.
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Object[]> pesquisarCompromissosMesmoHorario(
			Integer idCompromisso, Date dataCompromisso, 
			Collection<Usuario> colecaoUsuarios, Usuario usuarioLogado) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT usur.nome, compr.descricaoCompromisso "
				+ " FROM CompromissoResponsavel compresp "
				+ "   JOIN compresp.compromisso compr "
				+ "   JOIN compresp.usuario usur "
				+ " WHERE compr.dataInicioCompromisso = :dataCompromisso "
				+ "   and usur.codigo in (";
		
		if (colecaoUsuarios != null
				&& !colecaoUsuarios.isEmpty()) {
			Iterator<Usuario> iterator = colecaoUsuarios.iterator();
			
			while(iterator.hasNext()) {
				Usuario usuario = (Usuario) iterator.next();
				consulta += usuario.getCodigo() + ", ";
			}
		}
		
		consulta += usuarioLogado.getCodigo() + ")";
		
		if (idCompromisso != null) {
			consulta += "   and compr.codigo <> :idCompromisso ";
		}
		
		Query query = session
				.createQuery(consulta)
                .setParameter("dataCompromisso", dataCompromisso);
		
        if (idCompromisso != null) {
			query.setParameter("idCompromisso", idCompromisso);
		}
		
		Collection<Object[]> colecaoDados = 
				(Collection<Object[]>) 
				query.list();

		HibernateUtil.closeSession(session);
				
		return colecaoDados;
				
	}
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 *  
	 * Método responsável por pesquisar os dados do usuário responsável pelo compromisso
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @parm codigoCompromisso
	 * @return Object[]
	 * */
	public Object[] pesquisarUsuarioResponsavelCompromisso(Integer codigoCompromisso) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta  = "SELECT compresp.usuario.email, compresp.usuario.nome "
				+ " FROM CompromissoResponsavel compresp "
				+ " WHERE compresp.compromisso.codigo = :codigoCompromisso "
				+ "   and compresp.indicadorResponsavel = 1 ";
		
		Object[] dados = (Object[]) 
				session.createQuery(consulta)
			        .setParameter("codigoCompromisso", codigoCompromisso)
	                .setMaxResults(1).uniqueResult();
		
		HibernateUtil.closeSession(session);
		
		return dados;
	}

}
