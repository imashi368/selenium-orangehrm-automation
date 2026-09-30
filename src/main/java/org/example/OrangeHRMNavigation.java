package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMNavigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(5000);

        System.out.println("Dashboard Title: " + driver.getTitle());

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        Thread.sleep(4000);
        System.out.println("PIM Module Title: " + driver.getTitle());

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
        Thread.sleep(4000);
        System.out.println("Leave Module Title: " + driver.getTitle());

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
        Thread.sleep(4000);
        System.out.println("Recruitment Module Title: " + driver.getTitle());

        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("After Back (Leave Module): " + driver.getTitle());

        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("After Second Back (PIM Module): " + driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("After Forward (Leave Module): " + driver.getTitle());

        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println("After Refresh: " + driver.getTitle());

        driver.quit();
    }
}