package com.abt.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.springframework.stereotype.Component;

import com.abt.exceptions.APIException;
import com.abt.models.Transaction;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class JsonTransactionsLoader {

	private List<Transaction> transactions;

	@PostConstruct
	public void loadTransactions() throws APIException {

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			transactions = objectMapper.readValue(new File("src/main/resources/transactionsMock.json"),
					new TypeReference<List<Transaction>>() {
					});

		} catch (StreamReadException e) {
			throw new APIException("FILE_READING_ERROR");
		} catch (DatabindException e) {
			throw new APIException("INVALID_FILE_FORMAT");
		} catch (IOException e) {
			throw new APIException("FILE_READING_ERROR");
		}
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

}
