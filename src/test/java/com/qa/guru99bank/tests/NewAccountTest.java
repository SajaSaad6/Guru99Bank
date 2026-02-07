package com.qa.guru99bank.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.guru99bank.enums.AccountType;
import com.qa.guru99bank.pages.LoginPage;
import com.qa.guru99bank.pages.NewAccountPage;
import com.qa.guru99bank.pages.NewCustomerPage;
import com.qa.guru99bank.testdata.AlertMessages;
import com.qa.guru99bank.testdata.SuccessMessages;
import com.qa.guru99bank.utils.CustomerTestHelper;

public class NewAccountTest extends BaseTest{

	private LoginPage loginPage;
	private NewCustomerPage newCustomerPage;
	private NewAccountPage newAccountPage;
	
	private String deposit = "10000";
	private String fakeCustomerId = "123455";
	private String lowDeposit = "200";
	
	@BeforeTest
	public void prepareTest() {
		
	}
	
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
		newAccountPage = new NewAccountPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		
		loginPage.login(userId, password);		
	}
	
	
	@Test (description = "Verify creating new account successfull for a a valid customer ID")
	public void testValidNewAccount() {
		
		String customerId = CustomerTestHelper.createCustomerAndGetId(newCustomerPage, "NewAccount");
		
		newAccountPage.clickNewAccountLink();
		newAccountPage.createNewAccount(customerId, AccountType.CURRENT, deposit);
		
		String actualMessage = newAccountPage.getSuccessfullMessage();
		
		Assert.assertEquals(actualMessage, 
				SuccessMessages.ACCOUNT_GENERATED,
				"Expected success message after account creation: " + actualMessage);
	}
	
	@Test (description = "Verify display error when creating an account with non-existing customer ID")
	public void testFakeCustomerId() {
	
		newAccountPage.clickNewAccountLink();		
		newAccountPage.createNewAccount(fakeCustomerId, AccountType.CURRENT, deposit);
		
		Assert.assertEquals(newAccountPage.getAlertMessage(), 
				AlertMessages.CUSTOMER_NOT_FOUND,
				"Expected 'Customer Not Found' alert for invalid customer ID.");
	}
	
	@Test (description = "Verify display error when initial deposit is below minmum required amount")
	public void testLowDeposit() {
		
		String customerId = CustomerTestHelper.createCustomerAndGetId(newCustomerPage, "NewAccount");
		
		newAccountPage.clickNewAccountLink();
		newAccountPage.createNewAccount(customerId, AccountType.CURRENT, lowDeposit);
		
		Assert.assertEquals(newAccountPage.getAlertMessage(), 
				AlertMessages.INITIAL_DEPOSIT_TOO_LOW,
				"Expected minimum deposit validation alert");
	}
	
	@AfterMethod
	public void teardown() {
		super.tearDown();
	}
	
}
