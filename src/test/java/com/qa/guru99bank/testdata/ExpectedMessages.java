package com.qa.guru99bank.testdata;

public class ExpectedMessages {

	public static String forEmpty(String field) {
		switch (field) {
        case "name":
        	return "Customer name must not be blank";
        	
        case "dob":
        	return "Date Field must not be blank";
        	
        case "address":
        	return "Address Field must not be blank";
        	
        case "city":
        	return "City Field must not be blank";
        	
        case "state":
        	return "State must not be blank";
        case "pin": 
        	return "PIN Code must not be blank";
        	
        case "mobile":
        	return "Mobile no must not be blank";
        	
        case "email": 
        	return "Email-ID must not be blank";
        	
        case "password":
        	return "Password must not be blank";
        	
        default:
        	return null;
    }
	}
}
