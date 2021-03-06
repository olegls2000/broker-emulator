package com.bta.brokeremulator.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
public class AlphaResponseDto {
	private String sticker;
	private LocalDate lastRefreshed;
	private List<TradeItemDto> items;
}
