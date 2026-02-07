package com.qa.guru99bank.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	MALE("m"), 
	FEMALE("f");
	
    private final String value;
    
    Gender(String value) { 
    	this.value = value; 
    }
    
    public String getValue() { 
    	return value; 
    }
    
    @JsonCreator
    public static Gender fromString(String gender) {
        if (gender.equalsIgnoreCase("MALE") || gender.equalsIgnoreCase("m")) {
            return MALE;
        } else if (gender.equalsIgnoreCase("FEMALE") || gender.equalsIgnoreCase("f")) {
            return FEMALE;
        } else {
            throw new IllegalArgumentException("Unknown gender: " + gender);
        }
    }

    @JsonValue
    public String toJson() {
        return name();
    }
    
}
