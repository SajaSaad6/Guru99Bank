package com.qa.guru99bank.enums;

public enum AccountType {

	CURRENT("Current"),
	SAVINGS("Savings");
	
	private final String value;
	
	AccountType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
