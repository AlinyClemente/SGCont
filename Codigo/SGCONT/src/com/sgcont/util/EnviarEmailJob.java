package com.sgcont.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

import com.sgcont.fachada.Fachada;

/**
 * [UC007] Enviar E-mail Lembrete Compromisso
 * 
 * @author Mariana Victor
 * @since 27/04/2013
 * */
@SuppressWarnings("deprecation")
public class EnviarEmailJob implements StatefulJob {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {

			System.out.println(Util.formatarDataComHora(new Date()) + " - VERIFICAÇÃO DE LEMBRETES ");
			
			Fachada fachada = Fachada.getInstance();
			
			Collection<Object[]> colecaoLembrete =  
					fachada.pesquisarLembretesPendentes();

			System.out.println(Util.formatarDataComHora(new Date()) + " - Quantidade de lembretes: " + colecaoLembrete.size());
			
			if (colecaoLembrete != null 
					&& !colecaoLembrete.isEmpty()) {
				Iterator<Object[]> iteratorLembrete = colecaoLembrete.iterator();
				
				while (iteratorLembrete.hasNext()) {
					Object[] dadosLembrete = (Object[]) iteratorLembrete.next();

					Integer codigoLembrete = (Integer) dadosLembrete[0];
					Integer codigoCompromisso = (Integer) dadosLembrete[1];
					Date dataCompromisso = (Date) dadosLembrete[2];
					String descricaoCompromisso = (String) dadosLembrete[3];
					String observacao = null;
					if (dadosLembrete[4] != null) {
						observacao = (String) dadosLembrete[4];
					}
					
					Collection<Object[]> colecaoResponsaveis = fachada
							.pesquisarCompromissoResponsaveis(codigoCompromisso);
					
					if (colecaoResponsaveis != null
							&& !colecaoResponsaveis.isEmpty()) {
						Iterator<Object[]> iteratorResponsaveis = colecaoResponsaveis.iterator();
						
						
						String assunto = "[SGCONT] Lembrete: " + descricaoCompromisso 
								+ " - " + Util.formatarDataComHora(dataCompromisso);
						
						String responsaveis = "";

						Collection<String[]> colecaoDestinatarios = new ArrayList<String[]>();
						while (iteratorResponsaveis.hasNext()) {
							Object[] dadosResponsavel = (Object[]) iteratorResponsaveis.next();

							String nome = (String) dadosResponsavel[0];
							String email = (String) dadosResponsavel[1];
							
							responsaveis = responsaveis 
									+ "<li>" + nome + " - " + email + "</li>";
							
							colecaoDestinatarios.add(
									new String[]{email, nome});
						}  
						
						String mensagem = "<h1>" + descricaoCompromisso + "</h1>"
								+ "<h2>Data: " + Util.formatarDataComHora(dataCompromisso) + "</h2>";
						
						if (observacao != null
								&& !observacao.isEmpty()) {
							mensagem += "<h2>Observação: " + observacao + "</h2>";
						}
						
						mensagem += "<h2>Envolvidos:<ul>" + responsaveis + "</ul></h2>";
						
						ServicosEmail.enviarEmail(assunto, mensagem, colecaoDestinatarios);
						
						fachada.atualizarLembretePendente(codigoLembrete);
					}
							
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}