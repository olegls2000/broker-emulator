package com.bta.brokeremulator.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bta.brokeremulator.dto.AlphaRequestDto;
import com.bta.brokeremulator.dto.AlphaResponseDto;
import com.bta.brokeremulator.dto.TradeItemDto;
import com.bta.brokeremulator.dto.json.AlphaResponseJson;
import com.bta.brokeremulator.service.AlphaService;

@Service
public class AlphaServiceImpl implements AlphaService {

	@Value("#{environment['alpha.url']}")
	private String alphaURL;

	@Value("#{environment['alpha.apikey']}")
	private String alphaApiKey;

	@Override
	public AlphaResponseDto getStatistics(AlphaRequestDto request) {
		final RestTemplate restTemplate = new RestTemplate();
		final String url = getAlphaUrl(request);
		final ResponseEntity<AlphaResponseJson> responseEntity
				= restTemplate.getForEntity(url, AlphaResponseJson.class);

		return convertToDto(responseEntity.getBody(), request.getEndDate());
	}

	private AlphaResponseDto convertToDto(AlphaResponseJson body, LocalDate endDate) {
		final List<TradeItemDto> items = body.getWeeklyTimeSeries()
												 .entrySet()
												 .stream()
												 .map(this::toTradeItem)
												 .filter(tradeItem -> tradeItem.getPeriod().isBefore(endDate))
												 .collect(toList());

		return AlphaResponseDto.builder()
					   .sticker(body.getMetaData().getInformation())
					   .lastRefreshed(toDate(body.getMetaData().getLastRefreshed()))
					   .items(items)
					   .build();
	}

	private TradeItemDto toTradeItem(Map.Entry<String, Map<String, String>> entry) {
		return TradeItemDto.builder()
					   .period(toDate(entry.getKey()))
					   .open(Double.parseDouble(entry.getValue().get("1. open")))
					   .high(Double.parseDouble(entry.getValue().get("2. high")))
					   .low(Double.parseDouble(entry.getValue().get("3. low")))
					   .close(Double.parseDouble(entry.getValue().get("4. close")))
					   .volume(Long.parseLong(entry.getValue().get("5. volume")))
					   .build();
	}

	private LocalDate toDate(String value) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(value, formatter);
	}

	private String getAlphaUrl(AlphaRequestDto request) {
		return alphaURL + "?function=" + request.getTimePeriod() +
					   "&symbol=" + request.getSticker() +
					   "&apikey=" + alphaApiKey;
	}
}
