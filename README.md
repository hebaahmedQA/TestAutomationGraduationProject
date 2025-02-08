 Test Automation Graduation Project

 1. Project Scope
- Demo Website: Automation Exercise Demo Website.
- Test Adaptation: Implementing test cases on both GUI and API layers following the Test Automation Pyramid to ensure efficient execution.

 2. Test Cases to Automate
The project automates the following test cases:
1. Register User
2. Login User with correct email and password
3. Login User with incorrect email and password
4. Logout User
5. Register User with existing email

 3. Automation Framework Design
### **Structure:**
- **Test Scripts**: Implemented using the Page Object Model (POM) for GUI automation.
- **Test Data**: Uses external files (CSV, JSON, or Excel) for data-driven testing.
- **Configurations**: Stores URLs, environment details, and browser settings.
- **Reporting**: Generates reports using Allure.
- **Parallel Execution**: Supports parallel test execution for efficiency.

## 4. Libraries/Tools
- **Programming Language**: Java
- **Automation Libraries**:
    - **Web GUI**: Selenium WebDriver
    - **API**: Rest-Assured
    - **Test Runner**: TestNG
    - **Reporting**: Allure Reporting
- **CI/CD**: GitHub Actions for automated test execution and report generation.

## 5. Folder Structure
```
TestAutomationProject/
│-- src/main/java/
│   ├── pages/                # Page Object Model classes
│   ├── utils/                # Utility classes
│-- src/test/java/
│   ├── tests/                # Test scripts
│   ├── data/                 # Test data files
│-- src/test/resources/
│   ├── testng.xml            # TestNG configuration
│   ├── allure-results/       # Allure report results
│-- .github/workflows/
│   ├── maven-ci.yml          # CI/CD pipeline configuration
│-- pom.xml                   # Project dependencies & build configuration
│-- README.md                 # Project documentation
```

project video running with TestNG.xml
https://drive.google.com/file/d/1WAPN-Ho9mWpGHVGVd3f6Qr4ZtnZe1GcJ/view?usp=sharing

project video with testcases runs individual
https://drive.google.com/file/d/1IAXjg2kSFcLbY5Gh0NBHW7eXWpnxi41r/view?usp=sharing