package com.qa.guru99bank.utils;

import com.qa.guru99bank.config.JsonDataReader;
import com.qa.guru99bank.model.CustomerData;
import com.qa.guru99bank.pages.NewCustomerPage;

public class CustomerTestHelper {

	public static String createCustomerAndGetId(NewCustomerPage newCustomerPage, String caseName) {
		
		newCustomerPage.clickNewCustomerLink();
		CustomerData customer = JsonDataReader.getValidCaseByName(caseName).getCustomerData();
		customer.setEmail(DataGenerator.generateEmail(customer.getName()));
		newCustomerPage.createNewCustomer(customer);
		
		return newCustomerPage.getCustomerDetails().get("Customer ID");
		}
	
}
