package com.abt.repositories;

import java.util.List;
import com.abt.models.Transaction;
import com.abt.models.TransactionFilter;

public interface TransactionRepository {
	
	List<Transaction> findAll();
	
	List<Transaction> findWithFilter(TransactionFilter filter);
	
}
