package com.sgcont.util;

import org.apache.commons.mail.SimpleEmail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.slf4j.LoggerFactory;

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
	    	SimpleEmail email = new SimpleEmail();
	    	
			email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
			email.setSmtpPort(465);
	
			email.addTo("marianavictor.s@gmail.com", "Marii");
	
			email.setFrom("marianavictor.s@gmail.com", "Me"); // remetente
	
			email.setSubject("Mensagem de Teste"); // assunto do e-mail
	
			email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
	
			email.send(); //envia o e-mail
			
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    	LoggerFactory.getLogger(getClass()).error(ex.getMessage());
	    }
	  }
	}