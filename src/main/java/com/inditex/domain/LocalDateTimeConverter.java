package com.inditex.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeConverter {
	
	public LocalDateTime convert(Timestamp dateTime) {
		return dateTime.toLocalDateTime();
	}
	
	public LocalDateTime convert(String dateTime) {
		return Optional.of(LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.orElse(null);
	}

}
