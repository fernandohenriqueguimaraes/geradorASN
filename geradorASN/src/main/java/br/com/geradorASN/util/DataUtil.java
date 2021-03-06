package br.com.geradorASN.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;

public class DataUtil {
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	private static String FORMATO_ISSUING_DATE = "yyyy-MM-dd";
	private static String FORMATO_REGISTER_CREATION_HOUR = "HH:mm:ss";
	
	public DataUtil(@Value("${br.com.geradorASN.service.util.formatoDataEntrada}") String formatoDataEntrada,
			@Value("${br.com.geradorASN.service.util.formatoIssuingDate}") String formatoIssuingDate) {
				FORMATO_DATA_ENTRADA = formatoDataEntrada;
				FORMATO_ISSUING_DATE = formatoIssuingDate;
	}

	public static String getDataHoje() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_ENTRADA));
	}
	
	public static String formatarData(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(FORMATO_ISSUING_DATE));
	}
	
	public static String getRegisterCreationHour() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_REGISTER_CREATION_HOUR));
	}
	
	public static String getIssuingDateFormat() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_ISSUING_DATE)); 
	}
	
	public static LocalDate calcularProximosXdias(String dias) {
		return LocalDate.now().plusDays(Long.parseLong(dias));
	}
}
