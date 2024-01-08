package actions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class PracticeCopyPaste {
    public static WebDriver driver;
    @BeforeClass
    public static void initializeDriver(){
        driver = Driver.getDriver();

    }
    @AfterClass
    public static void cleanUp(){
//        driver.quit();
    }
    @Test
    public void TestCopyPaste(){
        /*
        1. go to https://demo.guru99.com/test/autoit.html
        2. enter name
        3. enter copy email
        4. paste it in comment section

         */
        driver.get("https://demo.guru99.com/test/autoit.html");

        WebElement iframe = driver.findElement(By.id("JotFormIFrame-72320244964454"));
        driver.switchTo().frame(iframe);

        WebElement name = driver.findElement(By.id("input_3"));
        name.sendKeys("codeWise");

        WebElement email = driver.findElement(By.id("input_4"));
        email.sendKeys("codeWise@gmail.com");

        WebElement commentSection = driver.findElement(By.id("input_6"));

        Actions actions = new Actions(driver);

        actions.keyDown(email, Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND);

        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND);

        actions.keyDown(commentSection, Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

    }


}
