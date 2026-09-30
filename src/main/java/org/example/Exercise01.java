package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // 1. Launch Chrome and maximize
        driver.manage().window().maximize();

        // 2. Open Automation Exercise
        driver.get("https://automationexercise.com/");

        Thread.sleep(2000);

        // 3. Verify homepage
        if (driver.getTitle().contains("Automation Exercise")) {
            System.out.println("Homepage displayed successfully");
        } else {
            System.out.println("Homepage verification failed");
        }

        // 4. Click Signup / Login
        driver.findElement(By.linkText("Signup / Login")).click();

        Thread.sleep(2000);

        // 5. Enter name and email
        driver.findElement(By.xpath("//input[@data-qa='signup-name']"))
                .sendKeys("John Smith");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys("testuser06082026@gmail.com");

        // 6. Click Signup
        driver.findElement(By.xpath("//button[@data-qa='signup-button']"))
                .click();

        Thread.sleep(3000);

        // 7. Verify account information page
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 8. First Name textbox
        WebElement firstName =
                driver.findElement(By.id("first_name"));

        if (firstName.isDisplayed() && firstName.isEnabled()) {
            System.out.println("First Name textbox is displayed and enabled");
        }

        // 9. Enter three text fields
        firstName.sendKeys("John");

        driver.findElement(By.id("last_name"))
                .sendKeys("Smith");

        driver.findElement(By.id("address1"))
                .sendKeys("Colombo, Sri Lanka");

        // 10. Select radio button
        driver.findElement(By.id("id_gender1")).click();

        // 11. Validate
        boolean testPassed = true;

        if (!firstName.getAttribute("value").equals("John")) {
            testPassed = false;
        }

        if (!driver.findElement(By.id("last_name"))
                .getAttribute("value").equals("Smith")) {
            testPassed = false;
        }

        if (!driver.findElement(By.id("address1"))
                .getAttribute("value")
                .equals("Colombo, Sri Lanka")) {
            testPassed = false;
        }

        // 12. Result
        if (testPassed) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }

        Thread.sleep(2000);

        driver.quit();
    }
}