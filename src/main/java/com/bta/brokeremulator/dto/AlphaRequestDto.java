package com.bta.brokeremulator.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class AlphaRequestDto {
	private String sticker;
	private String timePeriod;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
}
