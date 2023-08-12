package com.abt.services;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.abt.exceptions.APIException;
import com.abt.models.Transaction;
import com.abt.models.TransactionFilter;
import com.abt.repositories.TransactionRepositoryImpl;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepositoryImpl transactionRepository;

	@Override
	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	@Override
	public List<Transaction> getByQuery(TransactionFilter filter, String sortField, Integer page, Integer size)
			throws APIException {
		List<Transaction> result;
		List<Transaction> filtredList = (filter != null) ? transactionRepository.findWithFilter(filter)
				: transactionRepository.findAll();
		if (sortField != null)
			sortByField(filtredList, sortField);

		result = (page != null && size != null) ? getPage(page, size, filtredList) : filtredList;

		return result;

	}

	private void sortByField(List<Transaction> transactions, String sortField) throws APIException {
		Comparator<Transaction> comparator;
		switch (sortField) {
		case "amount":
			comparator = Comparator.comparing(Transaction::getAmount);
			break;
		case "merchant":
			comparator = Comparator.comparing(Transaction::getMerchant);
			break;
		case "status":
			comparator = Comparator.comparing(Transaction::getStatus);
			break;
		case "date":
			comparator = Comparator.comparing(Transaction::getDate);
			break;

		default:
			throw new APIException(HttpStatus.BAD_REQUEST.value(),"INVALID_SORT_FIELD_VALUE");
		}

		Collections.sort(transactions, comparator);
	}

	private List<Transaction> getPage(Integer page, Integer size, List<Transaction> transactions) throws APIException {
		if (page <= 0 || page >= transactions.size())
			throw new APIException(HttpStatus.BAD_REQUEST.value(),"INVALID_PAGE_NUMBER");
		if (size <= 0)
			throw new APIException(HttpStatus.BAD_REQUEST.value(),"INVALID_SIZE_VALUE");

		Integer startIndex = (page - 1) * size;
		Integer endIndex = Math.min(startIndex + size, transactions.size());
		return transactions.subList(startIndex, endIndex);
	}

}
