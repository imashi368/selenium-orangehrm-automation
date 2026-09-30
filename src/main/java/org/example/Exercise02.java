package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise02 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");

        Thread.sleep(2000);

        // Click Contact Us
        driver.findElement(By.linkText("Contact us")).click();

        Thread.sleep(2000);

        // Verify GET IN TOUCH
        WebElement getInTouch =
                driver.findElement(By.xpath("//h2[contains(text(),'Get In Touch')]"));

        boolean testPassed = getInTouch.isDisplayed();

        // Name
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("John Smith");

        // Email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john@gmail.com");

        // Subject
        WebElement subject = driver.findElement(By.name("subject"));
        subject.sendKeys("Selenium Testing");

        // Message
        WebElement message = driver.findElement(By.id("message"));
        message.sendKeys("This is a Selenium WebDriver test.");

        // Validate
        if (!name.getAttribute("value").equals("John Smith")) {
            testPassed = false;
        }

        if (!email.getAttribute("value").equals("john@gmail.com")) {
            testPassed = false;
        }

        if (!subject.getAttribute("value").equals("Selenium Testing")) {
            testPassed = false;
        }

        if (!message.getAttribute("value")
                .equals("This is a Selenium WebDriver test.")) {
            testPassed = false;
        }

        if (testPassed) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }

        driver.quit();
    }
}