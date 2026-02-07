package com.qa.guru99bank.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru99bank.enums.AccountType;

public class NewAccountPage extends BasePage{

	public NewAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private By customerIdInput = By.name("cusid");
	private By accountTypeDropDown = By.name("selaccount");
	private By initialDepositInput = By.name("inideposit");
	
	private By submitButton = By.name("button2");
	private By resetButton = By.name("reset");

	private By successfullMessage = By.xpath("//p[text()='Account Generated Successfully!!!']");
	
	private By accountTable = By.id("account");
	
	private By newAccountLink = By.linkText("New Account");
	
	public void clickNewAccountLink() {
		clickElement(newAccountLink);
	}
	public void selectAccountType(AccountType type) {
		Select select = new Select(driver.findElement(accountTypeDropDown));
		String value = type.getValue();
		select.selectByVisibleText(value);
	}
	
	public void enterCustomerId(String id) {
		enterText(customerIdInput, id);
	}
	
	public void enterInitialDeposit(String amount) {
		enterText(initialDepositInput, amount);
	}
	
	public void clickSubmitButton() {
		clickElement(submitButton);
	}
	
	public void clickResetButton() {
		clickElement(resetButton);
	}
	
	public void createNewAccount(String id, AccountType type, String amount) {
		enterCustomerId(id);
		selectAccountType(type);
		enterInitialDeposit(amount);
		clickSubmitButton();
	}
	
	public String getSuccessfullMessage() {
		return getText(successfullMessage);
	}
	
	public Map<String, String> getAccountDetails() {
		return getTableDetails(accountTable);
	}
}
