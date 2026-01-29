package com.qa.guru99bank.datatest;

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

    public CustomerData(String name, Gender gender, String dob, String address,
                        String city, String state, String pin, String mobile,
                        String email, String password) {
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
    public Gender getGender() { return gender; }
    public String getDob() { return dob; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPin() { return pin; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "CustomerData [name=" + name + ", gender=" + gender + ", dob=" + dob +
               ", address=" + address + ", city=" + city + ", state=" + state +
               ", pin=" + pin + ", mobile=" + mobile + ", email=" + email +
               ", password=" + password + "]";
    }
}
