package com.bta.brokeremulator.service;

import java.util.List;

import com.bta.brokeremulator.model.TradeTransaction;

public interface TradeTransactionService {
	void saveTradeTransactionByUsername(TradeTransaction transaction, String username);

	List<TradeTransaction> getTransactionsByUsername(String username);
}
