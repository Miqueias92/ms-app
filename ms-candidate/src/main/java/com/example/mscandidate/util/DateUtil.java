package com.example.mscandidate.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateUtil {
		
	public static LocalDate toLocalDate(String dateString) {
		if (dateString == null)
			return null;
		return LocalDate.parse(dateString, formatterPattern());
	}
	
	private static DateTimeFormatter formatterPattern() {	
		return new DateTimeFormatterBuilder()
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-M-d"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-M-dd"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-d"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				.toFormatter();
	}
}
