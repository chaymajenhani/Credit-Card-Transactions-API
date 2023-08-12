package com.abt.services;

import java.util.List;

import com.abt.exceptions.APIException;
import com.abt.models.Transaction;
import com.abt.models.TransactionFilter;


public interface TransactionService {

	List<Transaction> getAll();
	List<Transaction> getByQuery(TransactionFilter filter,String sortField, Integer page, Integer size) throws APIException;
	
}
