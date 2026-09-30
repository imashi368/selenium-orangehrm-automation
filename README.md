# Selenium Test Automation: OrangeHRM Demo

Selenium WebDriver test automation scripts written in Java (Maven) for the public
[OrangeHRM demo application](https://opensource-demo.orangehrmlive.com/).
Built as hands-on practice in functional web testing and UI test automation.

## Scenarios covered (`OrangeHRMLab03`)
1. Login with valid credentials
2. Employee registration (PIM → Add Employee), confirmed by waiting for the new employee's profile header
3. Employee search (PIM → Employee List)
4. Leave application (Leave → Apply)
5. Recruitment: adding a candidate
6. Logout

Other classes in `src/main/java/org/example` cover individual flows such as valid login
(`OrangeHRMLogin`), invalid login (`OrangeHRMInvalidLogin`) and module navigation
(`OrangeHRMNavigation`).

## Tech stack
- Java 23 (Oracle OpenJDK 23.0.1)
- Selenium WebDriver 4.34.0
- Maven
- Google Chrome
- IntelliJ IDEA

## Approach
- Explicit waits (`WebDriverWait`, `ExpectedConditions`) to handle dynamic page loading
- XPath and name-based locators to find page elements
- `try/catch/finally` with `driver.quit()` so the browser always closes
- Each scenario prints its result to the console

## How to run
1. Clone the repository:
   `git clone https://github.com/imashi368/selenium-orangehrm-automation.git`
2. Open the project in IntelliJ IDEA (or any Maven-compatible IDE) and let Maven
   download the dependencies
3. Make sure Google Chrome is installed
4. Run any class in `src/main/java/org/example`, for example `OrangeHRMLab03`

## Notes
This project uses the public OrangeHRM demo site for practice only. The login details
are the demo site's publicly shown credentials, and all test data is fictional.

## Author
C.P. Imashi Fernando | [LinkedIn](https://www.linkedin.com/in/imashi-fernando/)
