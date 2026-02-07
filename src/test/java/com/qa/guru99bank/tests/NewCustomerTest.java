package com.qa.guru99bank.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru99bank.config.JsonDataReader;
import com.qa.guru99bank.enums.ErrorInput;
import com.qa.guru99bank.model.CustomerData;
import com.qa.guru99bank.model.InvalidFieldCase;
import com.qa.guru99bank.model.InvalidFieldData;
import com.qa.guru99bank.pages.LoginPage;
import com.qa.guru99bank.pages.NewCustomerPage;
import com.qa.guru99bank.testdata.AlertMessages;
import com.qa.guru99bank.testdata.ExpectedMessages;
import com.qa.guru99bank.testdata.SuccessMessages;
import com.qa.guru99bank.utils.DataGenerator;
import com.qa.guru99bank.utils.TestDataUtils;

public class NewCustomerTest extends BaseTest{

	private LoginPage loginPage;
	private NewCustomerPage newCustomerPage;
	
	@BeforeMethod
	public void testSetup() {
		loginPage = new LoginPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		
		loginPage.login(userId, password);	
		newCustomerPage.clickNewCustomerLink();
	}
	
	@Test (description = "Verify add a new customer successfully")
	public void testAddValidNewCustomer() {
		
		/*
		 * PosgreSQL Usage
		 * CustomerData custoemr = new CustomerData("sally", Gender.FEMALE, "01-01-1990", "Street 21", 
		 *	"Madrid", "Spain", "123456", "1234567890", 
		 *	"sally7@test.test", "1234");
		 *
		 * newCustomerPage.createNewCustomer(custoemr);
		
		 * Map<String, String> newCustomer = newCustomerPage.getCustomerDetails();
		
		
		 * CustomerDAO.saveCustomerId(newCustomer);
		*/
		
		CustomerData customer = JsonDataReader.getValidCaseByName("NewCustomer").getCustomerData();
		customer.setEmail(DataGenerator.generateEmail(customer.getName()));
		
		newCustomerPage.createNewCustomer(customer);
		String actualMessage = newCustomerPage.getSuccessMessage();		
		
		Assert.assertEquals(actualMessage, 
				SuccessMessages.CUSTOMER_REGISTERED,
				"Expected customer registeration success message: " + actualMessage);
	}
	
	@Test (description = "Verify fields has inline validation")
	public void testFieldsValidation() {
		
		SoftAssert softAssert = new SoftAssert();

		InvalidFieldData data = JsonDataReader.readInvalidFieldData();
				
		for (InvalidFieldCase testCase : data.getInvalidFieldCases()) {
			
			newCustomerPage.fillNewCustomerFields(testCase.getCustomerData());
			
			String actualMessage = newCustomerPage.getErrorMessage(ErrorInput.fromField(testCase.getField()));
			
			softAssert.assertEquals(actualMessage, testCase.getExpectedMessage(),
					"Validation failed for field: " + testCase.getField() +
			        " | Expected: " + testCase.getExpectedMessage() +
			        " | Actual: " + actualMessage);
		}
		softAssert.assertAll();
	}
	
	@Test (description = "Verify inline error for empty fields")
	public void testInlineErrorForEmptyfields() {
		SoftAssert softAssert = new SoftAssert();

		CustomerData baseValid = JsonDataReader.getValidCaseByName("EmptyFields").getCustomerData();
		
		for (String field : List.of("name", "dob", "address", 
									"city", "state", "pin", "mobile", 
									"email", "password")) {
			
			CustomerData testData = baseValid.copy();
			
			TestDataUtils.setEmpty(testData, field);
			
			newCustomerPage.fillNewCustomerFields(testData);
			
			String actualMessage = newCustomerPage.getErrorMessage(ErrorInput.fromField(field));
			
			softAssert.assertEquals(actualMessage, ExpectedMessages.forEmpty(field),
					"Failed for field: " + field);
			
		}
		softAssert.assertAll();
	}
	
	@Test (description = "Verify add new customer with empty name fails")
	public void testSubmitWithEmptyName() {
		CustomerData data = JsonDataReader.getInvalidCaseByName("empty_name").getCustomerData();
		
		newCustomerPage.createNewCustomer(data);
		
		Assert.assertEquals(newCustomerPage.getAlertMessage(), 
				AlertMessages.FILL_ALL_FIELDS,
				"Expected alert indicating customer cannot be created with empty name");
	}
	
	@Test (description = "Verify can't add new customer with same email")
	public void testNewCustomerWithExistEmail() {
		CustomerData customer = JsonDataReader.getValidCaseByName("NewCustomer").getCustomerData();
		customer.setEmail(DataGenerator.generateEmail(customer.getName()));
		
		newCustomerPage.createNewCustomer(customer);
		newCustomerPage.clickNewCustomerLink();
		
		CustomerData duplicateCustomer = customer.copy();
		newCustomerPage.createNewCustomer(duplicateCustomer);
		
		Assert.assertEquals(newCustomerPage.getAlertMessage(), 
				AlertMessages.EXISTING_EMAIL,
				"Expected an alert indicates email exist");
	}
	
	@AfterMethod
	public void teardown() {
		super.tearDown();
	}
	
}
