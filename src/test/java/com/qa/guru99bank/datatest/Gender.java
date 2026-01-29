package com.qa.guru99bank.datatest;

public enum Gender {
	MALE("m"), FEMALE("f");
    private final String value;
    Gender(String value) { this.value = value; }
    public String getValue() { return value; }
}
