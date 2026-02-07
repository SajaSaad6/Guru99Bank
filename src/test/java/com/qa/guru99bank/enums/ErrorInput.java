package com.qa.guru99bank.enums;

import java.util.Arrays;

import org.openqa.selenium.By;

public enum ErrorInput {

    NAME("name", By.id("message")),
    DATE("dob", By.id("message24")),
    ADDRESS("address", By.id("message3")),
    CITY("city", By.id("message4")),
    STATE("state", By.id("message5")),
    PIN("pin", By.id("message6")),
    MOBILE("mobile", By.id("message7")),
    EMAIL("email", By.id("message9")),
    PASSWORD("password", By.id("message18")),
	USERID("userId", By.id("message23")),
	CUSTOMERID("customerId", By.id("message14")),
	INITIALDEPOSITE("InitialDeposite", By.id("message19")),
	ACCOUNTNO("accountNo", By.id("message10")),
	PAYEESACCOUNTNO("payeesAccountNo", By.id("message1")),
	DESCRIPTION("description", By.id("message17")),
	OLDPASSWORD("oldPassword", By.id("message20")),
	NEWPASSWORD("newPassword", By.id("message21")),
	CONFIRMPASSWORD("confirmationPassword", By.id("message22")),
	FROMDATE("fromDate", By.id("message26")),
	TODATE("toDate", By.id("message27"));
	
	
	
    private final By locator;
    private final String field;

    ErrorInput(String field, By locator) {
    	this.field = field;
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
    
    public static ErrorInput fromField(String field) {
        return Arrays.stream(values())
                .filter(e -> e.field.equalsIgnoreCase(field))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown field: " + field));
    }
    
}
