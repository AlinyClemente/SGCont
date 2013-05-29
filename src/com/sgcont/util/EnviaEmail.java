package com.sgcont.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * [UC007] Enviar E-mail Lembrete Compromisso
 * 
 * @author Mariana Victor
 * @since 27/04/2013
 * */
@SuppressWarnings("deprecation")
public class EnviaEmail implements StatefulJob {

	//	private JavaMailSenderImpl mailSender = null;
	//	public void setMailSender(JavaMailSenderImpl mailSender)
	//	{
	//	  this.mailSender = mailSender;
	//	}


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Email email = new SimpleEmail();
			
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setTLS(true);
			email.addTo("marianavictor.s@gmail.com");  
			email.setFrom("");   //TODO Alterar
			email.setSubject("teste");  
			email.setMsg("testee");  
			email.setAuthentication("", ""); //TODO Alterar    
			email.send();
		  
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}