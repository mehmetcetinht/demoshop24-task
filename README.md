# Demoshop24 Test Automation Project
## _Accenture Technical Task_

Test Automation framework in maven using Java & Selenium is created with:

- Maven 3.8.0
- Java 8
- Selenium 3.141.59
- TestNG 6.14.3
- Log4j 2.14.1
- Surefire Plugin 3.0.0-M3

## Executing Tests

- Test can be executed from command line (AllTests test suite will be executed with the command given below). 
```sh
mvn clean test
```
- Browser value is parametric which accept as value  “Chrome” or “Firefox". When the browser is not specified, tests will be executed at chrome.
- Drivers 'chromedriver(version 89) and 'geckodriver' are included in the project.
- Tests can be executed parallel by adding `parallel="tests" thread-count="{count}"` line to suite xml files.

## Screenshots and Reports 

To verify pages in tests, screenshot method is added. Screenshots are all png types and under the test-output file; seperated by date, suit name, test name, test method name, time and screenshot names. 

Framework has Surefire plugin for reporting. Reports are under the file target, surefire-reports.
Both "_emailable-report.html_" and "_index.html_" could be used for reports.
