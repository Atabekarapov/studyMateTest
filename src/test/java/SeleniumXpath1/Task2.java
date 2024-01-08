package SeleniumXpath1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Task2 {
    //1. Go to https://www.saucedemo.com/ --> done
    //2. Login to the application --> done
    //3. Add every item to the cart (there are 6 of them) --> done
    //4. Go to cart --> done
    //5. Verify following texts are present on the page:
    //Your Cart --> done
    //QTY --> done
    //Description --> done
    //6. Remove Sauce Labs Fleece Jacket --> done
    //7. Checkout, provide first name, last name and zip code, continue --> done
    //8. Verify following texts are present:
    //Payment Information --> done
    //Shipping Information --> done
    //Price Total --> done
    //9. Verify total is 86.35 -->done
    //10. Finish --> done
    //11. Verify this text is present "Checkout: Complete!" --> done

    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testDemoTask2(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        js.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        js.executeScript("window.scrollBy(0,-400)", "");
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //verifying texts
        if(driver.findElement(By.xpath("//span[@class='title']")).getText().equals("Your Cart")){
            System.out.println("PASS: texts are same");
        }
        if(driver.findElement(By.xpath("//div[@class='cart_quantity_label']")).getText().equals("QTY")){
            System.out.println("PASS: texts are same");
        }
        if(driver.findElement(By.xpath("//div[@class='cart_desc_label']")).getText().equals("Description")){
            System.out.println("PASS: texts are same");
        }
        js.executeScript("window.scrollBy(0,400)", "");
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']")).click();
        js.executeScript("window.scrollBy(0,900)", "");
        if(driver.findElement(By.xpath("//div[contains(text(), 'Payment Information')]")).getText().equals("Payment Information")){
            System.out.println("PASS: texts are same");
        }
        else{
            System.out.println("FAIL: texts are not same");
        }
        if(driver.findElement(By.xpath("//div[contains(text(), 'Shipping Information')]")).getText().equals("Shipping Information")){
            System.out.println("PASS: texts are same");
        }
        else{
            System.out.println("FAIL: texts are not same");
        }
        if(driver.findElement(By.xpath("//div[contains(text(), 'Price Total')]")).getText().equals("Price Total")){
            System.out.println("PASS: texts are same");
        }
        else{
            System.out.println("FAIL: texts are not same");
        }
        if(driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText().equals("Total: $86.35")){
            System.out.println("PASS: Total is 86.35");
        }
        else{
            System.out.println("FAIL: Total is not 86.35");
        }
        driver.findElement(By.id("finish")).click();
        if(driver.findElement(By.xpath("//span[@class='title']")).getText().equals("Checkout: Complete!")){
            System.out.println("PASS: texts are same");
        }
        else{
            System.out.println("FAIL: texts are not same");
        }


    }
}
