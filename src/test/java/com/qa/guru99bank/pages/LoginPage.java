package com.qa.guru99bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru99bank.enums.ErrorInput;

public class LoginPage extends BasePage{

	
	private By userIDInput = By.name("uid");
	private By passwordInput = By.name("password");
	private By loginButton = By.name("btnLogin");
	private By resetButton = By.name("btnReset");
	
	private By welcomeText = By.className("heading3");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	public void enterUserID(String userId) {
		enterText(userIDInput, userId);
	}
	
	public void enterPassword(String password) {
		enterText(passwordInput, password);
	}
	
	public void clickLoginButton() {
		clickElement(loginButton);
	}
	
	public void clickResetButton() {
		clickElement(resetButton);
	}
	
	public void login(String id, String password) {
		enterUserID(id);
		enterPassword(password);
		clickLoginButton();
	}
	
	public String getErrorMessage(ErrorInput input) {
		return getText(input.getLocator());
	}
	
	public String getWelcomeMessage() {
		return getText(welcomeText);
	}
	
	

	
}
