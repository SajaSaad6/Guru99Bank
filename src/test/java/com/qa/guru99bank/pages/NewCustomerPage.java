package com.qa.guru99bank.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru99bank.datatest.CustomerData;
import com.qa.guru99bank.datatest.ErrorInput;
import com.qa.guru99bank.datatest.Gender;

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
		Map<String, String> customerData = new HashMap<>();
		
		WebElement table = driver.findElement(By.id("customer"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			
			if (cells.size() == 2) {
				String key = cells.get(0).getText().trim();
				String value = cells.get(1).getText().trim();
				customerData.put(key,  value);
			}
		}
		return customerData;
	}
	
	//Alert errorMessage "please fill all fields"
}
