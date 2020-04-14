package br.com.geradorASN.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	private static String FORMATO_ISSUING_DATE = "dd/MM/yyyy HH:mm:ss";
	private static String FORMATO_REGISTER_CREATION_HOUR = "HH:mm:ss";

	public static String getDataHoje() {
		return (new SimpleDateFormat(FORMATO_DATA_ENTRADA)).format(new Date());
	}
	
	public static String getRegisterCreationHour() {
		return (new SimpleDateFormat(FORMATO_REGISTER_CREATION_HOUR)).format(new Date());
	}
	
	public static String getIssuingDateFormat(String issuingDate) {
		return (new SimpleDateFormat(FORMATO_ISSUING_DATE)).format(new Date());
	}
}
