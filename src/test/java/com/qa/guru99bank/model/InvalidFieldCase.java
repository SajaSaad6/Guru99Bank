package com.qa.guru99bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidFieldCase {
	
	@JsonProperty("case")
	private String caseName;
	private String field;
	private CustomerData customerData;
	private String expectedMessage;
	
	public String getCaseName() {return caseName; }
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	public String getField() { return field; }
	public void setField(String field) {
		this.field = field;
	}
	
	public CustomerData getCustomerData() { return customerData; }
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
	
	public String getExpectedMessage() { return expectedMessage; }	
	public void setExpectedMessage(String expectedMessage) {
		this.expectedMessage = expectedMessage;
	}
	

}
