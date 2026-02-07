package com.qa.guru99bank.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99bank.pages.LoginPage;

public class LoginTest extends BaseTest{

	private LoginPage loginPage;
	
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void testValidLogin() {
		loginPage.login(userId, password);
		
		Assert.assertEquals(loginPage.getWelcomeMessage(), 
				"Welcome To Manager's Page of Guru99 Bank",
				"User should redirected to manager page and shows welcome message");
	}
	
	@AfterMethod
	public void teardown() {
		super.tearDown();
	}
}
