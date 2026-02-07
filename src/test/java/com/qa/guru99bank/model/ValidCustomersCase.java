package com.qa.guru99bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidCustomersCase {

	@JsonProperty("case")
	private String caseName;
	private CustomerData customerData;
	
	public String getCaseName() { return caseName; }
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	public CustomerData getCustomerData() { return customerData; }
	public void setCustomerData(CustomerData custoemrData) {
		this.customerData = custoemrData;
	}
}
