package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Launch Google Chrome
        WebDriver driver = new ChromeDriver();

        // 2. Open the YouTube website
        driver.get("https://www.youtube.com");

        // 3. Print the page title in the console
        System.out.println("Title: " + driver.getTitle());

        // 4. Wait for 5 seconds
        Thread.sleep(5000);

        // 5. Close the browser
        driver.quit();
    }
}