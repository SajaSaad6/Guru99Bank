package com.qa.guru99bank.utils;

public class DataGenerator {

	public static String generateEmail(String name) {
		long timestamp = System.currentTimeMillis();
		return name + timestamp + "@test.com";
	}
}
