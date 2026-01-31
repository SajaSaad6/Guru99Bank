package com.qa.guru99bank.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public String alertMessage;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public boolean isRedirectedTo(String expectedUrlPart) {
		return wait.until(ExpectedConditions.urlContains(expectedUrlPart));
	}
	
	
	protected void handleAlertIfPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			alertMessage = "";
			log.debug("No alert present. Conitnuing execution.");
		}
	}
	
	protected void enterText(By locator, String text) {
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		el.clear();
		el.sendKeys(text);
	}
	
	protected void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	protected String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	
	protected Map<String, String> getTableDetails(By tableName) {
		Map<String, String> customerData = new HashMap<>();
		
		WebElement table = driver.findElement(tableName);
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
}
