package com.qa.guru99bank.datatest;

import org.openqa.selenium.By;

public enum ErrorInput {

    NAME(By.id("message")),
    DATE(By.id("message24")),
    ADDRESS(By.id("message3")),
    CITY(By.id("message4")),
    STATE(By.id("message5")),
    PIN(By.id("message6")),
    MOBILE(By.id("message7")),
    EMAIL(By.id("message9")),
    PASSWORD(By.id("message18")),
	USERID(By.id("message23"));
    private final By locator;

    ErrorInput(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
