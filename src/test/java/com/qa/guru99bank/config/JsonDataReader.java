package com.qa.guru99bank.config;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.guru99bank.model.InvalidFieldCase;
import com.qa.guru99bank.model.InvalidFieldData;
import com.qa.guru99bank.model.ValidCustomersCase;
import com.qa.guru99bank.model.ValidCustomersData;

public class JsonDataReader {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	private static <T> T readJson(String path, Class<T> clazz) {
	    try {
	        File file = new File(
	            JsonDataReader.class
	                .getClassLoader()
	                .getResource(path)
	                .toURI()
	        );
	        return mapper.readValue(file, clazz);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to read JSON: " + path, e);
	    }
	}
	
	
	public static InvalidFieldData readInvalidFieldData() {
		return readJson("testdata/customers_invalid_fields.json",
		        InvalidFieldData.class
			    );
	}
	
	public static ValidCustomersData readValidCustomers() {
		return readJson(
		        "testdata/customers_valid.json",
		        ValidCustomersData.class
		    );
	}
	
	public static ValidCustomersCase getValidCaseByName(String caseName) {
		
		ValidCustomersData data = readValidCustomers();
		
		return data.getValidCustomers().stream()
				.filter(c -> c.getCaseName().equals(caseName))
				.findFirst().orElseThrow(() ->
					new RuntimeException("Test case not found: " + caseName));
	}
	
	public static InvalidFieldCase getInvalidCaseByName(String caseName) {
	    return readInvalidFieldData()
	            .getInvalidFieldCases()
	            .stream()
	            .filter(c -> c.getCaseName().equals(caseName))
	            .findFirst()
	            .orElseThrow(() ->
	                new RuntimeException("Invalid test case not found: " + caseName));
	}
}
