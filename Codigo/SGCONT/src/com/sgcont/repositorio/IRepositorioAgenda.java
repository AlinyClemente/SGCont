package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Date;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;

/**
 * Interface do reposit�rio respons�vel pelas consultas do m�dulo da agenda
 * */
public interface IRepositorioAgenda {
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar os compromissos a partir do usu�rio
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoUsuario
	 * @return Collection<Compromisso>
	 * */
	public Collection<Compromisso> pesquisarCompromisso(Integer codigoUsuario);
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar os respons�veis a partir do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param codigoCompromisso
	 * @return Collection<Usuario>
	 * */
	public Collection<Usuario> pesquisarResponsaveis(Integer codigoCompromisso);

	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * M�todo respons�vel pesquisar os lembretes que ainda n�o foram enviados por email
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	public Collection<Object[]> pesquisarLembretesPendentes();
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * M�todo respons�vel pesquisar os dados do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	public Collection<Object[]> pesquisarCompromissoResponsaveis(Integer codigoCompromisso);
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 * 
	 * M�todo respons�vel por atualizar o lembrete
	 * 
	 * @author Mariana Victor
	 * @since 29/05/2013
	 * 
	 * @parm codigoLembrete
	 * */
	public void atualizarLembretePendente(Integer codigoLembrete);
	
	/**
	 * [UC010] Informar Agenda
	 * [FS0004] - Verificar respons�vel compromisso
	 * 
	 * M�todo respons�vel por verificar se o usu�rio � o respons�vel pelo compromisso
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @parm codigoCompromisso
	 * @parm codigoUsuario
	 * @return boolean
	 * */
	public boolean verificarUsuarioResponsavelCompromisso(Integer codigoCompromisso, Integer codigoUsuario);
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * M�todo respons�vel pesquisar compromissos associados a algum dos usu�rios 
	 * no mesmo hor�rio do compromisso a ser inserido.
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @return Collection<Object[]>
	 * */
	public Collection<Object[]> pesquisarCompromissosMesmoHorario(
			Integer idCompromisso, Date dataCompromisso, 
			Collection<Usuario> colecaoUsuarios, Usuario usuarioLogado);
	
	/**
	 * [UC007] Enviar E-mail Lembrete Compromisso
	 *  
	 * M�todo respons�vel por pesquisar os dados do usu�rio respons�vel pelo compromisso
	 * 
	 * @author Mariana Victor
	 * @since 31/05/2013
	 * 
	 * @parm codigoCompromisso
	 * @return Object[]
	 * */
	public Object[] pesquisarUsuarioResponsavelCompromisso(Integer codigoCompromisso);
	
}
