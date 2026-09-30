package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMInvalidLogin {
    public static void main(String[] args) throws InterruptedException {
        // 1. Launch Google Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // 2. Open OrangeHRM Demo login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for 3 seconds to let the page load
        Thread.sleep(3000);

        // 3. Enter invalid username and password
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("InvalidUser");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("WrongPassword");

        // 4. Click the Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the error message to appear
        Thread.sleep(3000);

        // 5. Capture the error message displayed by the application
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(@class, 'alert-content-text')]"));
        String actualMessage = errorMessage.getText();

        String expectedMessage = "Invalid credentials";

        // 6. Compare displayed message with expected message
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }

        // 7. Close the browser
        driver.quit();
    }
}