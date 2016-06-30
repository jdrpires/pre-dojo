package br.com.contadorgame.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static Date formatarData(String dataStr) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatarData(Date date) {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}

}