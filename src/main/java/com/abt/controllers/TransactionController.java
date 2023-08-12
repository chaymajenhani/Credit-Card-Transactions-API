package com.abt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abt.exceptions.APIException;
import com.abt.models.Response;
import com.abt.models.Transaction;
import com.abt.models.TransactionFilter;
import com.abt.services.TransactionServiceImpl;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController {
	@Autowired
	private TransactionServiceImpl transactionsService;


	@GetMapping
	public Response<List<Transaction>> FilterTransactions(@RequestParam(required = false) Double amount,
			@RequestParam(required = false) String merchant, @RequestParam(required = false) String status,
			@RequestParam(required = false) String sortField, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size

	) throws APIException {

		TransactionFilter filter = new TransactionFilter(amount, merchant, status);

		return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),
				transactionsService.getByQuery(filter, sortField, page, size));
	}
}
