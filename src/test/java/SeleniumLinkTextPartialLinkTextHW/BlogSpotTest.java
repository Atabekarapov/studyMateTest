package SeleniumLinkTextPartialLinkTextHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

/*
1. Go to https://omayo.blogspot.com/ --> done
2. From "Older Newslette" dropdown select option: doc 3
3. In "Text Area Field", enter hello
 */
public class BlogSpotTest {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void test1(){
        driver.get("https://omayo.blogspot.com/");
        Select select = new Select(driver.findElement(By.id("drop1")));
        select.selectByIndex(3);
        js.executeScript("window.scrollBy(0, 250)", "");
        driver.findElement(By.id("ta1")).sendKeys("hello");
    }
}
