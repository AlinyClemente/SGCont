package com.sgcont.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
}
