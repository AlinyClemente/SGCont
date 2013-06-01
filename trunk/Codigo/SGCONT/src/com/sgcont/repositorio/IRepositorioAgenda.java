package com.sgcont.repositorio;

import java.util.Collection;
import java.util.Date;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;

/**
 * Interface do repositório responsável pelas consultas do módulo da agenda
 * */
public interface IRepositorioAgenda {
	
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
	public Collection<Compromisso> pesquisarCompromisso(Integer codigoUsuario);
	
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
	public Collection<Usuario> pesquisarResponsaveis(Integer codigoCompromisso);

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
	public Collection<Object[]> pesquisarLembretesPendentes();
	
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
	public Collection<Object[]> pesquisarCompromissoResponsaveis(Integer codigoCompromisso);
	
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
	public void atualizarLembretePendente(Integer codigoLembrete);
	
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
	public boolean verificarUsuarioResponsavelCompromisso(Integer codigoCompromisso, Integer codigoUsuario);
	
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
	public Collection<Object[]> pesquisarCompromissosMesmoHorario(
			Integer idCompromisso, Date dataCompromisso, 
			Collection<Usuario> colecaoUsuarios, Usuario usuarioLogado);
	
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
	public Object[] pesquisarUsuarioResponsavelCompromisso(Integer codigoCompromisso);
	
}
