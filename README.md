
## Guru99 Bank Automation Project
UI Test Automation Framework built for the Guru99 Banking web application using:

- Java
- Selenium WebDriver
- TestNG
- Jackson (JSON data-driven testing)
- Maven

The framework automates core banking functionalities such as customer creation, account management, and withdrawal transactions while validating both positive and negative scenarios.

## Project Structure
```
src
 ├── main
 └── test
      ├── java
      │     └── com.qa.guru99bank
      │            ├── config
      │            ├── testdata
      │            ├── enums
      │            ├── model
      │            ├── utils
      │            ├── pages
      │            └── tests
      │
      └── resources
            └── testdata
                  ├── customers_valid.json
                  ├── customers_invalid_fields.json
                  └── customer_business_rules
```

## Framework Design

#### Page Object Model (POM)
Each page has its own class
- loginPage
- NewCustomerPage
- NewAccountPage
- WithdrawalPage

#### Data-Driven Testing 
Input test data is stored in JSON files, the framework: 
- Reads Valid and invalid test cases
- Retrieves specfic test cases by name
- Supports multiple validation scenarios

#### Reusable Utilities 
The framework includes helper classes for:
- Generating dynamic emails
- Setting specific fields empty dynamically
- Creating customers and returning IDs
- Handling alert messages
- Common test setup logic

## Test Coverage

#### Customer Management

- Create new customer (valid data)
- Validate inline field errors
- Submit with empty fields
- Prevent duplicate email registration

#### Account Management
- Create new account
- Handle fake customer ID
- Validate minimum deposit rule
- Verify account creation confirmation

#### Withdrawal
- Successful withdrawal
- Prevent withdrawal with insufficient balance
- Validate confirmation table header
- Validate alert messages

## How to run the test
1. Clone the Repository

```
git clone <https://github.com/SajaSaad6/Guru99Bank.git>
```

2. Intall Dependencies

```
mvn clean install
```

3. Run Tests

```
mvn test
```

