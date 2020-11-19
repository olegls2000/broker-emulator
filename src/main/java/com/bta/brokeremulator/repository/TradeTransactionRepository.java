package com.bta.brokeremulator.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bta.brokeremulator.model.TradeTransaction;

@Repository
public interface TradeTransactionRepository extends CrudRepository<TradeTransaction, Long> {

	List<TradeTransaction> findAllByUserAccountUsername(String username);
}
