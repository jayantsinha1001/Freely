#  Cucumber BDD Automation Framework (Selenium + Java)

---

##  Overview

This project is a **Test Automation Framework** built using **Selenium WebDriver, Cucumber (BDD), and Java**.
It follows the **Page Object Model (POM)** design pattern to ensure scalability, reusability, and maintainability.

The framework is designed to automate **web application testing** with clear separation between test logic and UI interactions.

---

##  Tech Stack

* **Java**
* **Selenium WebDriver**
* **Cucumber (BDD)**
* **JUnit**
* **Maven**

---

## Getting Started

### Prerequisites

Make sure you have:

* Java (JDK 8 or above)
* Maven installed
* Any IDE (IntelliJ / Eclipse)

---

##  How to Run Tests

### 1. Clean & Build Project

```bash
mvn clean install
```

---

### 2. Execute Tests

```bash
mvn clean test
```

---

## Running Tests with Tags

Tests can be executed using tags defined in the runner class:

```java
@CucumberOptions(
    tags = "@smoke"
)
```

 Example:

* `@smoke`
* `@regression`

---

## Test Reports

After execution, reports are generated at:

```bash
target/cucumber-reports/
```

Includes:

* HTML Report
* JSON Report

---

##  Framework Components

###  BasePage

* Contains reusable Selenium methods:

    * click
    * sendKeys
    * waits
    * element validations

---

###  DriverFactory

* Manages WebDriver initialization
* Supports browser setup and teardown

---

###  ConfigReader

* Reads configuration properties (URL, timeout, etc.)

---

###  Step Definitions

* Maps Gherkin steps to Java methods

---

###  Hooks

* Handles setup and teardown using:

    * `@Before`
    * `@After`

---

##  Best Practices Implemented

* Page Object Model (POM)
* Explicit waits (for stability)
* Reusable utility methods
* Clean separation of concerns
* Scalable folder structure

---

## Important Notes

* Do not commit `.idea/` or target folders
* Use `.gitignore` to exclude unnecessary files
* Ensure browser drivers are properly configured

---

## Future Enhancements

* Cross-browser execution
* Parallel execution
* CI/CD integration (GitHub Actions / Jenkins)
* Extent Reports integration

---

## Author

**Jayant Sinha**

