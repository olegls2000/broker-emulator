package com.bta.brokeremulator.service;

import com.bta.brokeremulator.dto.AlphaRequestDto;
import com.bta.brokeremulator.dto.AlphaResponseDto;


public interface AlphaService {
	AlphaResponseDto getStatistics(AlphaRequestDto request);
}
