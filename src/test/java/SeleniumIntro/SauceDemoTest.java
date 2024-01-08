package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    public static void main(String[] args) throws InterruptedException {
        //This part is for opening the website
        String url = "https://www.saucedemo.com/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // This part is for username, password, login
        String userName = "standard_user";
        String password = "secret_sauce";
        WebElement usernameType = driver.findElement(By.id("user-name"));
        WebElement passwordType = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameType.sendKeys(userName);
        passwordType.sendKeys(password);
        loginButton.click();
        //printing current url
        System.out.println("Current url: " + driver.getCurrentUrl());
        //adding items to bag
        String[] itemsToBag = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt"};
        for(String items : itemsToBag){
            WebElement addButton = driver.findElement(By.xpath("//div[text()='"+ items+ "']/../../following-sibling::div/button"));
            //div[text()='Sauce Labs Backpack']/../../following-sibling::div/button
           Thread.sleep(1000);
            addButton.click();
        }
        //going to cart clicking checkout
        WebElement itemsCart = driver.findElement(By.id("shopping_cart_container"));
        itemsCart.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        //providing information about the person who bought these items
        String firstName = "Mike";
        String lastName = "Barrett";
        String zipCode = "60628";

        WebElement firstNameType = driver.findElement(By.id("first-name"));
        WebElement lastNameType = driver.findElement(By.id("last-name"));
        WebElement zipCodeType = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));
        firstNameType.sendKeys(firstName);
        lastNameType.sendKeys(lastName);
        zipCodeType.sendKeys(zipCode);
        continueButton.click();

        //clicking on finish
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        //verifying the url
        String predictedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String realUrl = driver.getCurrentUrl();
        if(realUrl.equals(predictedUrl)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
