**NinjaV7 — Selenium Automation Framework**
**Overview**

NinjaV7 is a Java-based Selenium automation framework built using industry-standard practices for scalable and maintainable test automation. The framework follows the Page Object Model (POM) design pattern and supports data-driven testing, parallel execution, and CI/CD integration.

This project was developed as part of a QA Automation Bootcamp to demonstrate real-world automation skills.

**Features**

✅ Selenium WebDriver + Java

✅ TestNG test framework

✅ Maven project structure

✅ Page Object Model (POM) design

✅ Data-Driven Testing using Excel

✅ Cross-browser testing (Chrome, Edge)

✅ Extent Reports for test results

✅ Jenkins CI/CD integration

✅ Reusable utility classes

✅ Config file for environment setup

**Tech Stack**
Tool	Purpose
Java	Programming Language
Selenium WebDriver	UI Automation
TestNG	Test Execution
Maven	Build & Dependency Management
Excel (Apache POI)	Data-Driven Testing
Jenkins	CI/CD
Git	Version Control
Extent Reports	Test Reporting

**Project Structure**
NinjaV7/
│── src/
│   ├── main/java/
│   │   ├── base/
│   │   ├── pages/
│   │   ├── utilities/
│   ├── test/java/
│   │   ├── testcases/
│── testdata/
│   ├── testdata.xlsx
│── reports/
│── pom.xml
│── testng.xml
│── config.properties
│── README.md

**Automated Scenarios**

The framework automates the following end-to-end flows:

Login functionality

Search product

Add to cart

Checkout process

Form validation

Error handling scenarios

**How to Run Tests**
Prerequisites

Make sure you have installed:

Java 11+

Maven

Git

Chrome browser

Steps to Execute

Clone the repository:

git clone https://github.com/Nitisha-19/NinjaV7.git
cd NinjaV7


Run tests using Maven:

mvn clean test


Run via TestNG suite:

mvn test -DsuiteXmlFile=testng.xml

Test Reports

After execution, open the Extent Report:

/reports/ExtentReport.html

 CI/CD Integration (Jenkins)

Create a new Jenkins job

Point to this GitHub repo

Use this build command:

mvn clean test


Publish Extent Report after build

**Author**

Nitisha Kondadhasula
QA Automation Engineer
GitHub: https://github.com/Nitisha-19
