package com.qa.guru99bank.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru99banck.enums.ErrorInput;
import com.qa.guru99banck.enums.Gender;
import com.qa.guru99bank.datatest.CustomerData;

public class NewCustomerPage extends BasePage{

	public NewCustomerPage(WebDriver driver) {
		super(driver);
	}

	private By customerNameFields = By.name("name");
	private By dateOfBirthField = By.id("dob");
	private By addressField = By.name("addr");
	private By cityField = By.name("city");
	private By stateField = By.name("state");
	private By pinField = By.name("pinno");
	private By mobileNumberField = By.name("telephoneno");
	private By emailField = By.name("emailid");
	private By passwordField = By.name("password");
	
	private By submitButton = By.name("sub");
	private By resetButton = By.name("res");
	
	private By customerTable = By.id("customer");
	
	private By newCustomerLink = By.linkText("New Customer");
	
	public void clikcNewCustomerLink() {
		clickElement(newCustomerLink);
	}
	public void selectGender(Gender gender) {
		clickElement(By.xpath("//input[@value='" + gender.getValue() + "']"));
	}

	public void createNewCustomer(CustomerData data) 
	{
		enterText(customerNameFields, data.getName());
		selectGender(data.getGender());
		enterText(dateOfBirthField, data.getDob());
		enterText(addressField, data.getAddress());
		enterText(cityField, data.getCity());
		enterText(stateField, data.getState());
		enterText(pinField, data.getPin());
		enterText(mobileNumberField, data.getMobile());
		enterText(emailField, data.getEmail());
		enterText(passwordField, data.getPassword());
		
		clickSubmitButton();
	}
	
	public void clickSubmitButton() {
		clickElement(submitButton);	
	}
	
	public void clickResetButton() {
		clickElement(resetButton);		
	}
	
	public String getErrorMessage(ErrorInput input) {
		return getText(input.getLocator());
	}
	
	public Map<String, String> getCustomerDetails() {
		return getTableDetails(customerTable);
	}
	
}
