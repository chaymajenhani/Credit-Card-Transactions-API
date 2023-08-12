package com.abt.models;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private Long id;
	private Double amount;
	private String merchant;
	private String status;
	private Date date;
	
}
