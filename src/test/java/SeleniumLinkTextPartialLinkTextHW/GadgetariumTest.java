package SeleniumLinkTextPartialLinkTextHW;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class GadgetariumTest {
    /*
    1. Go to https://gadgetarium.us/ --> done
    2. Click on "Delivery" tab --> done
    3. Verify "Pay by card online" text is visible --> done
    4. Verify "Cash upon receipt" text is visible -->
    5. Verify "By card upon receipt" text is visible --> done
    6. Click on "FAQ" tab -->
    7. Verify "Frequently asked questions" text is visible --> done
    8. Click on "How can I order?" --> done
    9. Verify "You can easily order using our online platform." text is visible --> done
    10. Click on "Catalog -> Smartphones -> Apple"
    11. Click on "Show more" button
     */
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://gadgetarium.us/");
        driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3' and contains(text(), 'Delivery')]")).click();
        js.executeScript("window.scrollBy(0,300)", "");
        if(driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3' and contains(text(), 'Pay by card online')]")).getText().contains("Pay by card online")){
            System.out.println("PASS: text contained");
        }
        else{
            System.out.println("FAIL: text is not contained");
        }
        if(driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3' and contains(text(), 'Cash')]")).getText().contains("Cash upon")){
            System.out.println("PASS: text contained");
        }
        else{
            System.out.println("FAIL: text is not contained");
        }
        js.executeScript("window.scrollBy(0, -400)", "");
        driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3' and starts-with(text(), 'F')]")).click();
        Thread.sleep(3000);
        if(driver.findElement(By.xpath("//p[starts-with(text(), 'Frequ')]")).getText().contains("Frequently")){
            System.out.println("PASS: word is contained");
        }
        else{
            System.out.println("FAIL: word is not contained");
        }
        js.executeScript("window.scrollBy(0, 250)", "");
        driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 title css-9l3uo3' and starts-with(text(), 'How')]")).click();
        if(driver.findElement(By.xpath("//p[contains(text(), 'You can eas')]")).getText().contains("You can easily")){
            System.out.println("PASS: word is contained");
        }
        else{
            System.out.println("FAIL: word is not contained");
        }
        driver.findElement(By.xpath("//span[@class='MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel']")).click();

        WebElement element = driver.findElement(By.xpath("//a[@href='/item/1' and @class='flexgrow']"));
        actions.moveToElement(element).perform();

        WebElement element1 = driver.findElement(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container grid_container css-1d3bbye']/div)[2]"));
        actions.moveToElement(element1).click().perform();




    }
}
