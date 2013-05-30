package com.sgcont.util;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
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
public class EnviaEmail implements StatefulJob {

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
					
					Collection<Object[]> colecaoResponsaveis = fachada
							.pesquisarCompromissoResponsaveis(codigoCompromisso);
					
					if (colecaoResponsaveis != null
							&& !colecaoResponsaveis.isEmpty()) {
						Iterator<Object[]> iteratorResponsaveis = colecaoResponsaveis.iterator();
						
						Email htmlEmail = new HtmlEmail();
						
						htmlEmail.setHostName("smtp.gmail.com");
						htmlEmail.setSmtpPort(587);
						htmlEmail.setTLS(true);
						htmlEmail.setFrom("suporte.sgcont@gmail.com", "SGCONT");
						htmlEmail.setSubject("[SGCONT] Lembrete: " + descricaoCompromisso 
									+ " - " + Util.formatarDataComHora(dataCompromisso));  
						htmlEmail.setAuthentication("suporte.sgcont@gmail.com", "sgcont123456");    
						
						String responsaveis = "";
						
						while (iteratorResponsaveis.hasNext()) {
							Object[] dadosResponsavel = (Object[]) iteratorResponsaveis.next();

							String nome = (String) dadosResponsavel[0];
							String email = (String) dadosResponsavel[1];
							
							responsaveis = responsaveis 
									+ "<li>" + nome + " - " + email + "</li>";
							
							htmlEmail.addTo(email, nome);  
							
						}  
						
						htmlEmail.setMsg("<h1>" + descricaoCompromisso + "</h1>"
								+ "<h2><b>Data:</b> " + Util.formatarDataComHora(dataCompromisso) + "</h2>"
								+ "<h2>Participantes:<ul>" + responsaveis + "</ul></h2>");
						
						htmlEmail.send();
						
						fachada.atualizarLembretePendente(codigoLembrete);
					}
							
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}