package SeleniumXpath1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

public class Task1 {
        /*
        Login to https://www.saucedemo.com/
Add "Sauce Labs Bolt T-Shirt" to cart
Add "Sauce Labs Fleece Jacket" to cart
Go to cart
Remove "Sauce Labs Fleece Jacket" from cart
Click on "Continue Shopping"
Add "Sauce Labs Onesie" to cart
Go to cart  // --> done)))
Verify the price of "Sauce Labs Bolt T-Shirt" is 15.99 //---> done)))
Click on "Checkout" // ---> done )))
Enter following credentials:
first name: John
last name: Doe
zip code: 12345
Click on Finish
Verify "Back Home" button is displayed

         */
        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testDemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        js.executeScript("window.scrollBy(0,-250)", "");

        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("continue-shopping")).click();
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        js.executeScript("window.scrollBy(0,-350)", "");
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        if(driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText().equals("$15.99")){
            System.out.println("PASS: price is $15.99");
        }
        else{
            System.out.println("FAIL: Price are not the same");
        }
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.id("checkout")).click();
        js.executeScript("window.scrollBy(0,-150)", "");
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.id("continue")).click();
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']")).click();
        if(driver.findElement(By.id("back-to-products")).equals(driver.findElement(By.id("back-to-products")))){
            System.out.println("PASS: Back Home button is displayed!");
        }
        else{
            System.out.println("FAILED: Back Home button is not displayed!");
        }
        //TASK 2:
        //Login to https://www.saucedemo.com/
        //Click on Menu on top left
        //Click on "About" option
        //Verify the URL has changed to "https://saucelabs.com/"

    }
    @Test
    public void testDemo2(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("about_sidebar_link")).click();
        if(driver.getCurrentUrl().equals("https://saucelabs.com/")){
            System.out.println("PASS: URL changed");
        }
        else{
            System.out.println("FAILED: URL didn't change");
        }
    }


}
