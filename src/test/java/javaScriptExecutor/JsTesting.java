package javaScriptExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class JsTesting {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testJS() throws InterruptedException {
        driver.get("https://www.eatthismuch.com/");
        Thread.sleep(5000);
        js.executeScript("argument[0].click();", driver.findElement(By.xpath("(/html/body/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/ul/li[4]/a/text())[1]")));


    }

}
