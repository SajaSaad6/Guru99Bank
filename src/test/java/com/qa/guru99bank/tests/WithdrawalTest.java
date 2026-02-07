package com.qa.guru99bank.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99bank.enums.AccountType;
import com.qa.guru99bank.pages.LoginPage;
import com.qa.guru99bank.pages.NewAccountPage;
import com.qa.guru99bank.pages.NewCustomerPage;
import com.qa.guru99bank.pages.WithdrawalPage;
import com.qa.guru99bank.testdata.AlertMessages;
import com.qa.guru99bank.testdata.SuccessMessages;
import com.qa.guru99bank.utils.CustomerTestHelper;

public class WithdrawalTest extends BaseTest{

	private LoginPage loginPage;
	private NewCustomerPage newCustomerPage;
	private NewAccountPage newAccountPage;
	private WithdrawalPage withdrawalPage;
	
	private String initialDeposit = "10000";
	private String description = "test";
	private String validWithdrawal = "500";
	private String excessiveWithdrawal = "15000";
	
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
		newAccountPage = new NewAccountPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		withdrawalPage = new WithdrawalPage(driver);
		
		loginPage.login(userId, password);
	}
	
	private String createCustomerAndAccount(String caseName, AccountType accountType,
			String depositAmount) {
		
		String customerId = CustomerTestHelper.createCustomerAndGetId(newCustomerPage, caseName);
		
		newAccountPage.clickNewAccountLink();
		newAccountPage.createNewAccount(customerId, accountType, depositAmount);
		
		return newAccountPage.getAccountDetails().get("Account ID");
		
	}
	
	@Test (description = "Verify user with valid account can withdraw money ",
	groups = {""})
	public void testWithdrawal() {
		String accountNo = createCustomerAndAccount("Withdrawal", AccountType.SAVINGS, initialDeposit);
		withdrawalPage.clickWithdrawalLink();
		withdrawalPage.withdrawal(accountNo, validWithdrawal, description);
		
		assertEquals(withdrawalPage.getWithdrawalText(), 
				SuccessMessages.WITHDRAWAL + accountNo,
				"Expect successful withdrawal: " );
	}
	
	@Test (description = "Verify user cannot withdraw more than account balance")
	public void testWithdrawalWithLowAccountBalance() {
		String accountNo = createCustomerAndAccount("Withdrawal", AccountType.SAVINGS, initialDeposit);
		withdrawalPage.clickWithdrawalLink();
		withdrawalPage.withdrawal(accountNo, excessiveWithdrawal, description);
		
		assertEquals(withdrawalPage.getAlertMessage(), 
				AlertMessages.LOW_BALANCE,
				"Expect alert indicating the balance is low");
	}
	
	@AfterMethod
	public void teardown() {
		super.tearDown();
	}
}
