package com.bta.brokeremulator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bta.brokeremulator.model.TradeTransaction;
import com.bta.brokeremulator.model.UserAccount;
import com.bta.brokeremulator.repository.TradeTransactionRepository;
import com.bta.brokeremulator.repository.UserAccountRepository;
import com.bta.brokeremulator.service.TradeTransactionService;

@Service
public class TradeTransactionServiceImpl implements TradeTransactionService {

	@Autowired
	private TradeTransactionRepository tradeTransactionRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public void saveTradeTransactionByUsername(TradeTransaction transaction, String username) {
		UserAccount userAccount = userAccountRepository.findByUsername(username);
		transaction.setUserAccount(userAccount);
		tradeTransactionRepository.save(transaction);
	}

	@Override
	public List<TradeTransaction> getTransactionsByUsername(String username) {
		return tradeTransactionRepository.findAllByUserAccountUsername(username);
	}
}
