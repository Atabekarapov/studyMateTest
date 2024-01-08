package utilities.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class Test1 {

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hi")));


//        driver.findElement(By.id("username")).sendKeys(Config.getValue("username"));
//        driver.findElement(By.id("password")).sendKeys(Config.getValue("password"));


    }
}
