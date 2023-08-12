package com.abt.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.abt.models.Transaction;
import com.abt.models.TransactionFilter;
import com.abt.utils.JsonTransactionsLoader;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Autowired
	private JsonTransactionsLoader transactionsLoader;

	@Override
	public List<Transaction> findAll() {
		return transactionsLoader.getTransactions();
	}
	

	@Override
	public List<Transaction> findWithFilter(TransactionFilter filter) {
		
		return this.findAll().stream().filter(transaction -> filter(transaction, filter))
				.collect(Collectors.toList());
	}
	
	private Boolean filter(Transaction transaction, TransactionFilter filter) {

		return (filter.getAmount() == null || transaction.getAmount().compareTo(filter.getAmount()) == 0)
				&& (filter.getMerchant() == null
						|| transaction.getMerchant().toLowerCase().contains(filter.getMerchant().toLowerCase()))
				&& (filter.getStatus() == null || transaction.getStatus().equals(filter.getStatus()));
	}



}
