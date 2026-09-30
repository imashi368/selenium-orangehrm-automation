package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogin {
    public static void main(String[] args) throws InterruptedException {
        // 1. Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // 2. Maximize browser window
        driver.manage().window().maximize();

        // 3. Open OrangeHRM Demo Website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 4. Wait for page to load
        Thread.sleep(3000);

        // 5. Enter Username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // 6. Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // 7. Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // 8. Wait for dashboard to load
        Thread.sleep(5000);

        // 9. Print page title
        System.out.println("Page Title: " + driver.getTitle());

        // Check dashboard features / URL after login
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("dashboard")) {
            System.out.println("Dashboard elements and features are displayed successfully after login!");
        } else {
            System.out.println("Dashboard not loaded properly.");
        }

        // 10. Close browser
        driver.quit();
    }
}