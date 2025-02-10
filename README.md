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
- **Test Data**: Uses external files ( JSON) for data-driven testing.
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
├── .github              #workflows
     ├── maven-ci.yml          # CI/CD pipeline configuration
├── allure-results/       # Allure report results
│   ├── pages/                # Page Object Model classes
│   ├── utils/                # Utility classes
    ├── testng.xml            # TestNG configuration
│-- src/test/java/
│   ├── tests/                # Test scripts

│-- src/test/resources/
│   ├── data/                 # Test data files
    ├──[config.properties]
│  
│   

│   
│-- pom.xml                   # Project dependencies & build configuration
│-- README.md                 # Project documentation
```

project video running with TestNG.xml
https://drive.google.com/file/d/1wuDrhYDBiJXsEJmrwtLypzEv11iE4It-/view?usp=sharing