package exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.Practice.Flow;

public class PracticeHandlingException {
    @Test
    public void Test1() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

//        driver.findElement(By.id("ui-id-11")).click();
        Flow.clickWithRetries(driver, By.id("ui-id-11"), 3);
        System.out.println("Hello, this is the message after click");
        System.out.println("this is the next stop after we click on Jackets");
    }
    @Test
    public void testScreenshot(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        Flow.takeScreenshot(driver, "target/testResults/screenshot.png");

    }
}
