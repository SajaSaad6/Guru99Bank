package com.qa.guru99bank.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99banck.enums.Gender;
import com.qa.guru99bank.datatest.CustomerData;
import com.qa.guru99bank.pages.LoginPage;
import com.qa.guru99bank.pages.NewCustomerPage;

public class NewCustomerTest extends BaseTest{

	private LoginPage loginPage;
	private NewCustomerPage newCustomerPage;
	private CustomerData validCustomerData;
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		
		loginPage.login(userId, password);	
		newCustomerPage.clikcNewCustomerLink();
	}
	
	@Test
	public void testValidNewCustomer() {
		
		validCustomerData = new CustomerData("sally", Gender.FEMALE, "1990/01/01", "Street 21", 
			"Madrid", "Spain", "123456", "1234567890", 
			"sally@test.test", "1234");
		newCustomerPage.createNewCustomer(validCustomerData);
		
		Map<String, String> newCustomer = newCustomerPage.getCustomerDetails();
		Assert.assertTrue(newCustomer.containsKey("Customer ID"),
				"Customer Should get a customer Id: Customer ID" + newCustomer.get("Customer ID"));
	}
	
	
}
