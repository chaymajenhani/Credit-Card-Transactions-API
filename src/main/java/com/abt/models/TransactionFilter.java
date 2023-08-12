package com.abt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilter {
	
	private Double amount;
	private String merchant;
	private String status;
}
