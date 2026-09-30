package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise03 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://automationexercise.com/");

        Thread.sleep(3000);

        // Click Products
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

        Thread.sleep(3000);

        // Verify Products page
        WebElement allProducts = driver.findElement(
                By.xpath("//h2[contains(text(),'All Products')]")
        );

        if (allProducts.isDisplayed()) {
            System.out.println("Products page displayed successfully");
        } else {
            System.out.println("Products page not displayed");
        }

        // Search Blue Top
        WebElement searchBox = driver.findElement(
                By.id("search_product")
        );

        searchBox.clear();
        searchBox.sendKeys("Blue Top");

        Thread.sleep(1000);

        // Click Search
        driver.findElement(
                By.id("submit_search")
        ).click();

        Thread.sleep(3000);

        // Find Blue Top specifically
        WebElement blueTop = driver.findElement(
                By.xpath("//div[contains(@class,'productinfo')]//p[normalize-space()='Blue Top']")
        );

        // Get product name
        String productName = blueTop.getText();

        System.out.println("Product Name: " + productName);

        // Validate
        if (productName.equalsIgnoreCase("Blue Top")) {

            System.out.println("Test Case Passed");

        } else {

            System.out.println("Test Case Failed");
        }

        Thread.sleep(2000);

        driver.quit();
    }
}