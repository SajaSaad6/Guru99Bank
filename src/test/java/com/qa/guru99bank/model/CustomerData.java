package com.qa.guru99bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qa.guru99bank.enums.Gender;

public class CustomerData {

    private String name;
    private Gender gender;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String mobile;
    private String email;
    private String password;

    
    public CustomerData(@JsonProperty("name") String name, @JsonProperty("gender") Gender gender, 
    					@JsonProperty("dob") String dob, @JsonProperty("address") String address,
                        @JsonProperty("city") String city, @JsonProperty("state") String state, 
                        @JsonProperty("pin") String pin, @JsonProperty("mobile")String mobile,
                        @JsonProperty("email")String email, @JsonProperty("password")String password) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public void setName(String name) {
    	this.name = name;
    }
    
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) {
    	this.gender = gender;
    }
    
    public String getDob() { return dob; }
    public void setDob(String dob) {
    	this.dob = dob;
    }
    
    public String getAddress() { return address; }
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getCity() { return city; }
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getState() { return state; }
    public void setState(String state) {
    	this.state = state;
    }
    
    public String getPin() { return pin; }
    public void setPin(String pin) {
    	this.pin = pin;
    }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) {
    	this.mobile = mobile;
    }
    
    public String getEmail() { return email; }
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPassword() { return password; }
    public void setPassword(String password) {
    	this.password = password;
    }

    public CustomerData copy() {
    	return new CustomerData(this.name,
    	        this.gender,
    	        this.dob,
    	        this.address,
    	        this.city,
    	        this.state,
    	        this.pin,
    	        this.mobile,
    	        this.email,
    	        this.password
    	    );
    }
    @Override
    public String toString() {
        return "CustomerData [name=" + name + ", gender=" + gender + ", dob=" + dob +
               ", address=" + address + ", city=" + city + ", state=" + state +
               ", pin=" + pin + ", mobile=" + mobile + ", email=" + email +
               ", password=" + password + "]";
    }
}
