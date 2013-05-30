package com.sgcont.util;

import java.util.Collection;
import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.dados.operacional.Compromisso;
import com.sgcont.dados.operacional.Lembrete;

public class CompromissoEvent extends DefaultScheduleEvent implements ScheduleEvent {
	
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	
	private String observacao;
	
	private Collection<Usuario> colecaoUsuariosSelecionados;
	
	private String indicadorUsarLembrete;
	
	private String tempoLembrete;
	
	private String opcaoTempoLembrete;
	
	private String indicadorCompromissoRecorrente;
	
	private String quantidade;
	
	private String frequencia;
	
	private Compromisso compromissoPrincipal;

	public CompromissoEvent() {
		this.setIndicadorUsarLembrete("2");
		this.setTempoLembrete("10");
		this.setIndicadorCompromissoRecorrente("2");
		this.setQuantidade("1");
	}

	public CompromissoEvent(String titulo, Date dataInicial, Date dataFinal) {
		super.setTitle(titulo);
		super.setStartDate(dataInicial);
		super.setEndDate(dataFinal);
		
		this.setIndicadorUsarLembrete("2");
		this.setTempoLembrete("10");
		this.setIndicadorCompromissoRecorrente("2");
		this.setQuantidade("1");
	}

	public CompromissoEvent(Compromisso compromisso, Collection<Usuario> colecaoResponsaveis, Lembrete lembrete) {
		
		super.setStartDate(compromisso.getDataInicioCompromisso());
		super.setEndDate(compromisso.getDataFimCompromisso());
		super.setTitle(compromisso.getDescricaoCompromisso());

		this.setCodigo(compromisso.getCodigo());
		this.setObservacao(compromisso.getObservacao());
		this.setColecaoUsuariosSelecionados(colecaoResponsaveis);
		this.setIndicadorCompromissoRecorrente(compromisso.getIndicadorRecorrente().toString());
		if (compromisso.getQuantidadeRepetir() != null) {
			this.setQuantidade(compromisso.getQuantidadeRepetir().toString());
		}
		if (compromisso.getIndicadorFrequencia() != null) {
			this.setFrequencia(compromisso.getIndicadorFrequencia().toString());
		}
		
		if (lembrete != null) {
			this.setIndicadorUsarLembrete("1");
			this.setTempoLembrete(lembrete.getValorLembrete().toString());
			this.setOpcaoTempoLembrete(lembrete.getIndicadorUnidadeLembrete().toString());
		} else {
			this.setIndicadorUsarLembrete("2");
		}
		
		if (compromisso.getCompromissoPrincipal() != null) {
			this.setCompromissoPrincipal(compromisso.getCompromissoPrincipal());
		}
			
	}
	
	public Compromisso getCompromisso() {
		Compromisso compromisso = new Compromisso();

		compromisso.setCodigo(this.getCodigo());
		compromisso.setDataInicioCompromisso(super.getStartDate());
		compromisso.setDataFimCompromisso(super.getEndDate());
		compromisso.setDescricaoCompromisso(super.getTitle());
		if (this.getObservacao() != null 
				&& !this.getObservacao().isEmpty()) {
			compromisso.setObservacao(this.getObservacao());
		}
		
		compromisso.setIndicadorRecorrente(
				new Short(this.getIndicadorCompromissoRecorrente()));
		if (this.getIndicadorCompromissoRecorrente().equals("1")) {
			if (this.getQuantidade() != null 
					&& !this.getQuantidade().isEmpty()) {
				compromisso.setQuantidadeRepetir(new Integer(this.getQuantidade()));
			}
			if (this.getFrequencia() != null 
					&& !this.getFrequencia().isEmpty()) {
				compromisso.setIndicadorFrequencia(new Short(this.getFrequencia()));
			}
		}
		
		if (this.getCompromissoPrincipal() != null) {
			compromisso.setCompromissoPrincipal(this.getCompromissoPrincipal());
		}
		
		return compromisso;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Collection<Usuario> getColecaoUsuariosSelecionados() {
		return colecaoUsuariosSelecionados;
	}

	public void setColecaoUsuariosSelecionados(
			Collection<Usuario> colecaoUsuariosSelecionados) {
		this.colecaoUsuariosSelecionados = colecaoUsuariosSelecionados;
	}

	public String getIndicadorUsarLembrete() {
		return indicadorUsarLembrete;
	}

	public void setIndicadorUsarLembrete(String indicadorUsarLembrete) {
		this.indicadorUsarLembrete = indicadorUsarLembrete;
	}

	public String getTempoLembrete() {
		return tempoLembrete;
	}

	public void setTempoLembrete(String tempoLembrete) {
		this.tempoLembrete = tempoLembrete;
	}

	public String getOpcaoTempoLembrete() {
		return opcaoTempoLembrete;
	}

	public void setOpcaoTempoLembrete(String opcaoTempoLembrete) {
		this.opcaoTempoLembrete = opcaoTempoLembrete;
	}

	public String getIndicadorCompromissoRecorrente() {
		return indicadorCompromissoRecorrente;
	}

	public void setIndicadorCompromissoRecorrente(
			String indicadorCompromissoRecorrente) {
		this.indicadorCompromissoRecorrente = indicadorCompromissoRecorrente;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public Compromisso getCompromissoPrincipal() {
		return compromissoPrincipal;
	}

	public void setCompromissoPrincipal(Compromisso compromissoPrincipal) {
		this.compromissoPrincipal = compromissoPrincipal;
	}

}
