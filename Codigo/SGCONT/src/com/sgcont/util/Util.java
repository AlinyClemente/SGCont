package com.sgcont.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Util {

	/**
	 * Retorna a data e a hora no seguinte formato: "dd/MM/yyyy hh:mm:ss" 
	 * 
	 * @author Mariana Victor
	 * @since 17/04/2013
	 * */
	public static String formatarDataComHora(Date data) {
		StringBuffer dataBD = new StringBuffer();

		if (data != null) {
			Calendar dataCalendar = new GregorianCalendar();

			dataCalendar.setTime(data);

			if (dataCalendar.get(Calendar.DAY_OF_MONTH) > 9) {
				dataBD.append(dataCalendar.get(Calendar.DAY_OF_MONTH) + "/");
			} else {
				dataBD.append("0" + dataCalendar.get(Calendar.DAY_OF_MONTH)
						+ "/");
			}

			// Obs.: Janeiro no Calendar é mês zero
			if ((dataCalendar.get(Calendar.MONTH) + 1) > 9) {
				dataBD.append(dataCalendar.get(Calendar.MONTH) + 1 + "/");
			} else {
				dataBD.append("0" + (dataCalendar.get(Calendar.MONTH) + 1)
						+ "/");
			}

			dataBD.append(dataCalendar.get(Calendar.YEAR));

			dataBD.append(" ");

			if (dataCalendar.get(Calendar.HOUR_OF_DAY) > 9) {
				dataBD.append(dataCalendar.get(Calendar.HOUR_OF_DAY));
			} else {
				dataBD.append("0" + dataCalendar.get(Calendar.HOUR_OF_DAY));
			}

			dataBD.append(":");

			if (dataCalendar.get(Calendar.MINUTE) > 9) {
				dataBD.append(dataCalendar.get(Calendar.MINUTE));
			} else {
				dataBD.append("0" + dataCalendar.get(Calendar.MINUTE));
			}

			dataBD.append(":");

			if (dataCalendar.get(Calendar.SECOND) > 9) {
				dataBD.append(dataCalendar.get(Calendar.SECOND));
			} else {
				dataBD.append("0" + dataCalendar.get(Calendar.SECOND));
			}
		}

		return dataBD.toString();
	}

	/**
	 * Retorna a data recebida no seguinte formato: "dd/MM/yyyy hh:mm:ss" 
	 * 
	 * @author Mariana Victor
	 * @since 29/04/2013
	 * */
	public static Date converterStringParaDate(String data) {
		Date retorno = null;
		try {
			retorno = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).parse(data);
		} catch (Exception e) {
			new IllegalArgumentException(data + " não tem o formato dd/MM/yyyy.");
		}
		return retorno;
	}

	/**
	 * Valida o CPF passado como parâmetro 
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	public static boolean validacaoCPF(String s_aux){
		if (s_aux.length() == 11 ) {
			int     d1, d2, d3; 
			int     digito1, digito2, resto; 
			int     digitoCPF; 
			String  nDigResult; 
			String  nDigVerif = s_aux.substring(0,1);
			d1 = d2 = 0; 
			d3 = 1;
			digito1 = digito2 = resto = 0; 
			boolean digVerifIgual = true;

			for (int n_Count = 1; n_Count < s_aux.length() -1; n_Count++) { 
				digitoCPF = Integer.valueOf (s_aux.substring(n_Count -1, n_Count)).intValue(); 
				d1 = d1 + ( 11 - n_Count ) * digitoCPF; 
				d2 = d2 + ( 12 - n_Count ) * digitoCPF; 
			}

			resto = (d1 % 11);

			if (resto < 2) 
				digito1 = 0; 
			else 
				digito1 = 11 - resto;

			d2 += 2 * digito1; 
			resto = (d2 % 11);

			if (resto < 2) 
				digito2 = 0; 
			else 
				digito2 = 11 - resto;

			String nDigVerific = s_aux.substring (s_aux.length()-2, s_aux.length()); 
			nDigResult = String.valueOf(digito1) + String.valueOf(digito2); 

			while(d3 < s_aux.length()){

				if(!s_aux.substring(d3, d3+1).equals(nDigVerif)){
					digVerifIgual = false;
				}
				d3 += 1;
			}

			if(digVerifIgual){
				return false;
			}

			return nDigVerific.equals(nDigResult); 
		}
		
		return false;	        
	}


	/**
	 * Valida o CNPJ passado como parâmetro 
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 * */
	public static boolean validacaoCNPJ(String s_aux){
		
		if (s_aux.length() == 14) {
			
			int soma = 0, dig; 
			String cnpj_calc = s_aux.substring(0,12); 
			char[] chr_cnpj = s_aux.toCharArray();

			for( int i = 0; i < 4; i++ ) 
				if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 ) 
					soma += (chr_cnpj[i] - 48) * (6 - (i + 1)); 
			for( int i = 0; i < 8; i++ ) 
				if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 ) 
					soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1));
			
			dig = 11 - (soma % 11); 
			cnpj_calc += ( dig == 10 || dig == 11 ) ?
					"0" : Integer.toString(dig);
			
			soma = 0;
			
			for ( int i = 0; i < 5; i++ ) 
				if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 ) 
					soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
			
			for ( int i = 0; i < 8; i++ ) 
				if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 ) 
					soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1));
			
			dig = 11 - (soma % 11); 
			cnpj_calc += ( dig == 10 || dig == 11 ) ? 
					"0" : Integer.toString(dig);
			
			return s_aux.equals(cnpj_calc); 
		}
		
		return false;

	}
}
