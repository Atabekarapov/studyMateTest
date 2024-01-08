package SeleniumXpath2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class CashWiseHW {
    //1. Go to https://cashwise.us/main --> done
    //2. Verify URL contains "cashwise"  --> done
    //3. Verify "accounting@gmail.com" is present on top left --> done
    //4. Verify "sign in" button is present --> done
    //5. Verify "sign up" button is present -->
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testCashWise1(){
        driver.get("https://cashwise.us/main");
        System.out.println(driver.getCurrentUrl().contains("cashwise")); //true
        if(driver.findElement(By.xpath("//div[@class='css-1270swg']//div[@class='css-oo7pew']//p[@class='css-1it55co' and (text()='accounting@gmail.com')]")).getText()
                .equals("accounting@gmail.com")){
            System.out.println("PASS: email is present");
        }
        else{
            System.out.println("FAIL: email is not present");
        }
        if(driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1o6c4rv']")).getText().equalsIgnoreCase("Sign in")){
            System.out.println("PASS: sign in button is present");
        }
        else{
            System.out.println("FAIL: sign in button is not present");
        }
        if(driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root css-1jmsc0p']")).getText().equalsIgnoreCase("Sign up")){
            System.out.println("PASS: sign up button is present");
        }
        else{
            System.out.println("FAIL: sign up button is not present");
        }
    }
    @Test
    public void testCashWise2() throws InterruptedException {
        //1. Go to https://cashwise.us/main --> done
        //2. Click on "sign up" button --> done
        //3. Provide any email --> done
        //4. Provide 4 chars password -->
        //5. Verify "Password must be at least 6 characters" message pops up
        driver.get("https://cashwise.us/main");
        driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1o6c4rv']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id=':r3:']")).sendKeys("admin12345@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd");
        driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-hl90zr']")).click();
        if(driver.findElement(By.xpath("//div[@class='css-1s14sjg']//p[@class='css-7ndbs7']")).getText().equalsIgnoreCase("Password must be at least 6 characters")){
            System.out.println("PASS: message popped up");
        }
        else{
            System.out.println("FAIL: message didn't pop up");
        }

    }
}
