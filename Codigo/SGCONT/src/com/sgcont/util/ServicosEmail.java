package com.sgcont.util;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class ServicosEmail {

	private static  String servidorSMTP = "smtp.gmail.com";
	private static final Integer portaServidorSMTP = 587;
	private static final String nomeRemetente = "SGCONT";
	private static final String emailRemetente = "suporte.sgcont@gmail.com";
	private static final String senhaRemetente = "sgcont123456";
	
	@SuppressWarnings("deprecation")
	public static void enviarEmail(String assunto, String conteudo, 
			Collection<String[]> colecaoDestinatarios) 
			throws EmailException {

		if (colecaoDestinatarios != null && !colecaoDestinatarios.isEmpty()) {
			Email htmlEmail = new HtmlEmail();
			
			htmlEmail.setHostName(servidorSMTP);
			htmlEmail.setSmtpPort(portaServidorSMTP);
			htmlEmail.setTLS(true);
			htmlEmail.setFrom(emailRemetente, nomeRemetente);
			htmlEmail.setSubject(assunto);
			htmlEmail.setAuthentication(emailRemetente, senhaRemetente);    

			Iterator<String[]> iterator = colecaoDestinatarios.iterator();
			while(iterator.hasNext()) {
				String[] destinatario = (String[]) iterator.next();
				htmlEmail.addTo(destinatario[0], destinatario[1]);
			}
			
			htmlEmail.setMsg(conteudo);
			htmlEmail.send();
			
		}
		

	}
	
}
