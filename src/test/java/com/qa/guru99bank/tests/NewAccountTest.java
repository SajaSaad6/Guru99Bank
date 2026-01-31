package com.qa.guru99bank.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99bank.pages.LoginPage;
import com.qa.guru99bank.pages.NewAccountPage;

public class NewAccountTest extends BaseTest{

	private LoginPage loginPage;
	private NewAccountPage newAccountPage;
	
	private String customerId = "20894";
	private String deposit = "10000";
	
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
		newAccountPage = new NewAccountPage(driver);
		
		loginPage.login(userId, password);
		newAccountPage.clickNewAccountLink();
	}
	
	@Test
	public void testValidNewAccount() {
		newAccountPage.createNewAccount(customerId, "Current", deposit);
		
		Assert.assertEquals(newAccountPage.getSuccessfullMessage(), "Account Generated Successfully!!!");
	}
}
