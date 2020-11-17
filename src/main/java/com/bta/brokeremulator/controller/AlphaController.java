package com.bta.brokeremulator.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bta.brokeremulator.dto.AlphaRequestDto;
import com.bta.brokeremulator.dto.AlphaResponseDto;
import com.bta.brokeremulator.service.AlphaService;

@Controller
@RequestMapping("alpha")
public class AlphaController {

	@Autowired
	private AlphaService alphaService;

	@GetMapping("statistics")
	public String getStatisticsRequestView() {
		return "alpha/alpha-request";
	}

	@PostMapping("statistics")
	public ModelAndView showStatistics(@ModelAttribute AlphaRequestDto request) {
		final AlphaResponseDto responseDto = alphaService.getStatistics(request);
		final Map<String, Object> params = new HashMap<>();
		params.put("tradeItems", responseDto.getItems());
		//TODO: Add sticker and other Info to the map, show it on UI

		return new ModelAndView("alpha/statistics", params);
	}

}
