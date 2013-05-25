package com.sgcont.negocio;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.dados.operacional.CompromissoResponsavel;
import com.sgcont.dados.operacional.Lembrete;
import com.sgcont.repositorio.IRepositorioAgenda;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioAgenda;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.util.CompromissoEvent;
import com.sgcont.util.Util;

/**
 * Controlador responsável pelas regras de negócio do módulo da agenda
 * */
public class ControladorAgenda implements IControladorAgenda {

	private static ControladorAgenda instance;

	protected IRepositorioAgenda repositorioAgenda = null;
	protected IRepositorioUtil repositorioUtil = null;
	
	public static synchronized IControladorAgenda getInstance(){
		if (instance == null){
			instance = new ControladorAgenda();
		}
		return instance;
	}
	
	private ControladorAgenda() {

		repositorioAgenda = RepositorioAgenda.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();
		
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
	public Collection<Compromisso> pesquisarCompromisso(Integer codigoUsuario) {
		
		return this.repositorioAgenda.pesquisarCompromisso(codigoUsuario);
		
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
	public Collection<Usuario> pesquisarResponsaveis(Integer codigoCompromisso) {
		
		return this.repositorioAgenda.pesquisarResponsaveis(codigoCompromisso);
		
	}
	
	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável inserir ou atualizar o compromisso
	 * 
	 * @author Mariana Victor
	 * @since 22/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public Integer inserirOuAtualizarCompromisso(CompromissoEvent compromissoEvent, Usuario usuarioLogado) {

		Compromisso compromisso = compromissoEvent.getCompromisso();
		compromisso.setUltimaAlteracao(new Date());

		// remove os usuários já associados para o compromisso
		if (compromisso.getCodigo() != null) {

			this.removerDadosDoCompromisso(compromisso);
			
		}

		// insere/atualiza o compromisso
		this.repositorioUtil.inserirOuAtualizar(compromisso);

		this.inserirUsuariosCompromisso(compromisso, 
				compromissoEvent.getColecaoUsuariosSelecionados(), usuarioLogado);
		
		if (compromissoEvent.getIndicadorUsarLembrete() != null 
				&& compromissoEvent.getIndicadorUsarLembrete().trim().equals("1")) {
			
			this.inserirLembrete(compromissoEvent, compromisso);
			
		}
		
		return compromisso.getCodigo();
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável inserir um compromisso recorrente
	 * 
	 * @author Mariana Victor
	 * @since 23/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	public Compromisso inserirCompromissoRecorrente(Compromisso compromisso,
			CompromissoEvent compromissoEvent, Usuario usuarioLogado,
			Integer idCompromissoPrincipal) {
		
		Date dataInicioCompromisso = compromisso.getDataInicioCompromisso();
		Date dataFimCompromisso = compromisso.getDataFimCompromisso();
		
		Compromisso compromissoRecorrente = new Compromisso();
		compromissoRecorrente.setDescricaoCompromisso(compromisso.getDescricaoCompromisso());
		
		if (compromisso.getObservacao() != null 
				&& !compromisso.getObservacao().isEmpty()) {
			compromissoRecorrente.setObservacao(compromisso.getObservacao());
		}
		
		compromissoRecorrente.setIndicadorRecorrente(compromisso.getIndicadorRecorrente());
		compromissoRecorrente.setQuantidadeRepetir(compromisso.getQuantidadeRepetir());
		compromissoRecorrente.setIndicadorFrequencia(compromisso.getIndicadorFrequencia());
		
		switch (compromisso.getIndicadorFrequencia()) {
			case 1: //dia(s)
				dataInicioCompromisso = Util.adicionarNumeroDiasDeUmaData(
						dataInicioCompromisso, 1);
				dataFimCompromisso = Util.adicionarNumeroDiasDeUmaData(
						dataFimCompromisso, 1);
				break;
			case 2: //semana(s)
				dataInicioCompromisso = Util.adicionarNumeroSemanasDeUmaData(
						dataInicioCompromisso, 1);
				dataFimCompromisso = Util.adicionarNumeroSemanasDeUmaData(
						dataFimCompromisso, 1);
				break;
			case 3: //mês(es)
				dataInicioCompromisso = Util.adicionarNumeroMesesDeUmaData(
						dataInicioCompromisso, 1);
				dataFimCompromisso = Util.adicionarNumeroMesesDeUmaData(
						dataFimCompromisso, 1);
				break;
			case 4: //ano(s)
				dataInicioCompromisso = Util.adicionarNumeroAnosDeUmaData(
						dataInicioCompromisso, 1);
				dataFimCompromisso = Util.adicionarNumeroAnosDeUmaData(
						dataFimCompromisso, 1);
				break;
		}

		compromissoRecorrente.setDataInicioCompromisso(dataInicioCompromisso);
		compromissoRecorrente.setDataFimCompromisso(dataFimCompromisso);
		compromissoRecorrente.setUltimaAlteracao(new Date());
		compromissoRecorrente.setCompromissoPrincipal(new Compromisso(idCompromissoPrincipal));
		
		this.repositorioUtil.inserirOuAtualizar(compromissoRecorrente);
		
		this.inserirUsuariosCompromisso(compromissoRecorrente, 
				compromissoEvent.getColecaoUsuariosSelecionados(), usuarioLogado);
		
		if (compromissoEvent.getIndicadorUsarLembrete() != null 
				&& compromissoEvent.getIndicadorUsarLembrete().trim().equals("1")) {
			
			this.inserirLembrete(compromissoEvent, compromissoRecorrente);
			
		}
		
		return compromissoRecorrente;
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável inserir os usuários do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 23/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	private void inserirUsuariosCompromisso(Compromisso compromisso,
			Collection<Usuario> colecaoUsuarios, Usuario usuarioLogado) {
		
		if (colecaoUsuarios != null
				&& !colecaoUsuarios.isEmpty()) {

			Iterator<Usuario> iterator = colecaoUsuarios.iterator();
			
			while(iterator.hasNext()) {
				Usuario usuario = (Usuario) iterator.next();
				
				CompromissoResponsavel compromissoResponsavel = new CompromissoResponsavel();
				compromissoResponsavel.setCompromisso(compromisso);
				compromissoResponsavel.setUsuario(usuario);
				compromissoResponsavel.setUltimaAlteracao(new Date());
				
				this.repositorioUtil.inserirOuAtualizar(compromissoResponsavel);
			}
		}
		
		// insere o compromisso para o usuário que criou
		CompromissoResponsavel compromissoResponsavel = new CompromissoResponsavel();
		compromissoResponsavel.setCompromisso(compromisso);
		compromissoResponsavel.setUsuario(usuarioLogado);
		compromissoResponsavel.setUltimaAlteracao(new Date());
		this.repositorioUtil.inserirOuAtualizar(compromissoResponsavel);
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável por inserir o lembrete do compromisso
	 * 
	 * @author Mariana Victor
	 * @since 23/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	private void inserirLembrete(CompromissoEvent compromissoEvent,
			Compromisso compromisso) {
		Lembrete lembrete = new Lembrete();
		lembrete.setCompromisso(compromisso);
		lembrete.setUltimaAlteracao(new Date());
		
		Integer tempo = new Integer(compromissoEvent.getTempoLembrete());
		Date dataLembrete = compromisso.getDataInicioCompromisso();
		Short indicadorUnidadeLembrete = new Short(compromissoEvent.getOpcaoTempoLembrete());
		switch (indicadorUnidadeLembrete) {
			case 1: //minuto(s)
				dataLembrete = Util.subtrairNumeroMinutosDeUmaData(
						dataLembrete, tempo);
				break;
			case 2: //hora(s)
				dataLembrete = Util.subtrairNumeroHorasDeUmaData(
						dataLembrete, tempo);
				break;
			case 3: //dia(s)
				dataLembrete = Util.subtrairNumeroDiasDeUmaData(
						dataLembrete, tempo);
				break;
		}
		
		lembrete.setDataLembrete(dataLembrete);
		lembrete.setIndicadorUnidadeLembrete(indicadorUnidadeLembrete);
		lembrete.setValorLembrete(tempo);
		
		this.repositorioUtil.inserirOuAtualizar(lembrete);
	}

	/**
	 * [UC010] Informar Agenda
	 * 
	 * Método responsável remove os dados relacionados ao compromisso
	 * 
	 * @author Mariana Victor
	 * @since 25/05/2013
	 * 
	 * @param compromissoEvent
	 * */
	@SuppressWarnings("unchecked")
	public Collection<Compromisso> removerDadosDoCompromisso(Compromisso compromisso) {
		
		// remove os dados do compromisso principal
		Integer idCompromissoPrincipal = null;
		if (compromisso.getCompromissoPrincipal() != null) {
			idCompromissoPrincipal = compromisso.getCompromissoPrincipal().getCodigo();
		} else {
			idCompromissoPrincipal = compromisso.getCodigo();
		}
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("compromisso.codigo", idCompromissoPrincipal);
		this.repositorioUtil.remover(CompromissoResponsavel.class, parametros);
		this.repositorioUtil.remover(Lembrete.class, parametros);
		
		// seleciona e remove os dados dos compromissos recorrentes
		parametros = new HashMap<String, Object>();
		parametros.put("compromissoPrincipal.codigo", idCompromissoPrincipal);
		Collection<Compromisso> colecaoCompromissoRecorrente = (Collection<Compromisso>) 
				this.repositorioUtil.pesquisarColecao(Compromisso.class, parametros);
		
		if (colecaoCompromissoRecorrente != null 
				&& !colecaoCompromissoRecorrente.isEmpty()) {
			Iterator<Compromisso> iterator = colecaoCompromissoRecorrente.iterator();
			
			while(iterator.hasNext()) {
				Compromisso compromissoRecorrente = (Compromisso) iterator.next();

				parametros = new HashMap<String, Object>();
				parametros.put("compromisso.codigo", compromissoRecorrente.getCodigo());
				this.repositorioUtil.remover(CompromissoResponsavel.class, parametros);
				this.repositorioUtil.remover(Lembrete.class, parametros);

				parametros = new HashMap<String, Object>();
				parametros.put("codigo", compromissoRecorrente.getCodigo());
				this.repositorioUtil.remover(Compromisso.class, parametros);
			}
		}
		
		return colecaoCompromissoRecorrente;
	}
	
}
