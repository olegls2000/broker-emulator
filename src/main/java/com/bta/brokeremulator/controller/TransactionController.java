package com.bta.brokeremulator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bta.brokeremulator.model.TradeTransaction;
import com.bta.brokeremulator.service.TradeTransactionService;

@RequestMapping("transaction")
@Controller
public class TransactionController {

	@Autowired
	private TradeTransactionService tradeTransactionService;

	@PostMapping("create")
	public ModelAndView createTransaction(@ModelAttribute TradeTransaction transaction) {

		tradeTransactionService.saveTradeTransactionByUsername(transaction, "a");

		List<TradeTransaction> tradeTransactions = tradeTransactionService.getTransactionsByUsername("a");

		final Map<String, Object> params = new HashMap<>();
		params.put("transactions", tradeTransactions);

		return new ModelAndView("transaction/table", params);
	}
}
