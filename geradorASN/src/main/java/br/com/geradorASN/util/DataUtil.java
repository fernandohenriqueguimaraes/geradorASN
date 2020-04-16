package br.com.geradorASN.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;

public class DataUtil {
	
	private static String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
	private static String FORMATO_ISSUING_DATE = "dd/MM/yyyy HH:mm:ss";
	
	public DataUtil(@Value("${br.com.geradorASN.service.util.formatoDataEntrada}") String formatoDataEntrada,
			@Value("${br.com.geradorASN.service.util.formatoIssuingDate}") String formatoIssuingDate) {
				FORMATO_DATA_ENTRADA = formatoDataEntrada;
				FORMATO_ISSUING_DATE = formatoIssuingDate;
	}

	public static String getDataHoje() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_ENTRADA));
	}
	
	public static String formatarData(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(FORMATO_DATA_ENTRADA));
	}
	
	public static String getRegisterCreationHour() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
	
	public static String getIssuingDateFormat(String issuingDate) {
		return LocalDateTime.parse(issuingDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME).format(DateTimeFormatter.ofPattern(FORMATO_ISSUING_DATE));	
	}
	
	public static LocalDate calcularProximosXdias(String dias) {
		return LocalDate.now().plusDays(Long.parseLong(dias));
	}
}
