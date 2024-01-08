package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class IntroToAlerts {
    /*
        go to https://demo.guru99.com/test/delete_customer.php
        enter customer id
        click on submit button
        get alert message and print it
        accept alert
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement customerIdField = driver.findElement(By.name("cusid"));
        customerIdField.sendKeys("24342");

        WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
        submitButton.click();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);


        driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        driver.switchTo().alert().accept();
    }
}
