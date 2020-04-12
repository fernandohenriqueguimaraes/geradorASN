package br.com.geradorASN.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";

	public static String getDataHoje() {
		return (new SimpleDateFormat(FORMATO_DATA_ENTRADA)).format(new Date());
	}
}
