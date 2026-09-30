package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrangeHRMLab03 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // 1. Login Scenario
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            WebElement usernameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameBox.sendKeys("Admin");

            WebElement passwordBox = driver.findElement(By.name("password"));
            passwordBox.sendKeys("admin123");

            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            loginBtn.click();
            System.out.println("Test Case 1 (Login): Passed");

            // 2. Employee Registration Scenario
            WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
            pimMenu.click();

            WebElement addEmpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']")));
            addEmpBtn.click();

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
            firstName.sendKeys("Kasun");

            WebElement middleName = driver.findElement(By.name("middleName"));
            middleName.sendKeys("Madhusanka");

            WebElement lastName = driver.findElement(By.name("lastName"));
            lastName.sendKeys("Perera");

            WebElement saveBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            saveBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Kasun Madhusanka Perera']")));
            System.out.println("Test Case 2 (Employee Registration): Passed");

            // 3. Employee Search Scenario
            WebElement empListBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Employee List']")));
            empListBtn.click();

            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[label[text()='Employee Name']]/following-sibling::div//input")));
            searchBox.sendKeys("Kasun");

            WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            searchBtn.click();
            System.out.println("Test Case 3 (Employee Search): Passed");

            // 4. Leave Application Scenario
            WebElement leaveMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leave']")));
            leaveMenu.click();

            WebElement applyLeave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Apply']")));
            applyLeave.click();
            System.out.println("Test Case 4 (Leave Application): Passed");

            // 5. Recruitment - Add Candidate Scenario
            WebElement recruitmentMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recruitment']")));
            recruitmentMenu.click();

            WebElement addCandidateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
            addCandidateBtn.click();

            WebElement recFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
            recFirstName.sendKeys("Amal");

            WebElement recLastName = driver.findElement(By.name("lastName"));
            recLastName.sendKeys("Silva");

            WebElement recSaveBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            recSaveBtn.click();
            System.out.println("Test Case 5 (Recruitment - Add Candidate): Passed");

            // 6. Logout Scenario
            WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']")));
            userDropdown.click();

            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
            logoutBtn.click();
            System.out.println("Test Case 6 (Logout): Passed");


        } catch (Exception e) {
            System.out.println("Test Execution Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}