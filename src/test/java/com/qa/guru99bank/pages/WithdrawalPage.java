package com.qa.guru99bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalPage extends BasePage{

	public WithdrawalPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountNoInput = By.name("accountno");
	private By amountInput = By.name("ammount");
	private By descriptionInput = By.name("desc");

	private By submitButton = By.name("AccSubmit");
	private By resetButton = By.name("res");

	private By withdrawalText = By.className("heading3");
	
	private By withdrawalLink = By.linkText("Withdrawal");
	
	public String getWithdrawalText() {
		return getText(withdrawalText);
	}
	public void enterAccountNo(String accountNo) {
		enterText(accountNoInput, accountNo);
	}
	
	public void enterAmount(String amount) {
		enterText(amountInput, amount);
	}
	
	public void enterDescription(String text) {
		enterText(descriptionInput, text);
	}
	
	public void clickSubmitButton() {
		clickElement(submitButton);
	}
	
	public void clickResetButon() {
		clickElement(resetButton);
	}
	
	public void clickWithdrawalLink() {
		clickElement(withdrawalLink);
	}
	
	public void withdrawal(String accountNo, String amount, String text) {
		enterAccountNo(accountNo);
		enterAmount(amount);
		enterDescription(text);
		
		clickSubmitButton();
		
	}
}
