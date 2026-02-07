package com.qa.guru99bank.utils;

import com.qa.guru99bank.model.CustomerData;

public class TestDataUtils {

	public static void setEmpty(CustomerData data, String field) {
        switch (field) {
            case "name" -> data.setName("");
            case "gender" -> data.setGender(null);
            case "dob" -> data.setDob("");
            case "address" -> data.setAddress("");
            case "city" -> data.setCity("");
            case "state" -> data.setState("");
            case "pin" -> data.setPin("");
            case "mobile" -> data.setMobile("");
            case "email" -> data.setEmail("");
            case "password" -> data.setPassword("");
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        }

	}
}
