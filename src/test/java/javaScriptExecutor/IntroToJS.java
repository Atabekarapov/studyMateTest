package javaScriptExecutor;

import jdk.jshell.execution.Util;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utilities.Driver;
import utilities.UtilWait;
import java.time.Duration;
import java.util.List;

public class IntroToJS {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void EatThisMuch() throws InterruptedException {
        driver.get("https://www.eatthismuch.com/");
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/food/browse/?type=recipe']")));
        for (int page = 1; page < 6; page++) {
            Thread.sleep(5000);
            printFoods(driver, page);

            Thread.sleep(5000);
            if(page < 5){
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/food/browse/?type=recipe&page=" + (page + 1) + "']")));
            }
        }
    }
    public void printFoods(WebDriver driver, int page){
        WebElement foodContainer = driver.findElement(By.xpath("//div[@class='row food_result']"));
        System.out.println("Page: " + page);
        for (WebElement foodElement : foodContainer.findElements(By.xpath("//div[@class='result_name col-3']"))) {
            System.out.println(foodElement.getText());
        }
    }
    @Test
    public void testSendKeys(){
        /*
        1. go to https://www.eatthismuch.com/app/registration
        2.
         */


        driver.get("https://www.eatthismuch.com/app/registration");

        WebElement username = driver.findElement(By.xpath("(//div[@class='svelte-1brqcpa'])[1]/input"));
        WebElement email = driver.findElement(By.xpath("(//div[@class='svelte-1brqcpa'])[2]/input"));
        WebElement password = driver.findElement(By.xpath("(//div[@class='svelte-695ua8'])[1]/input"));

        js.executeScript("arguments[0].value= 'atabekarapov';" +
                "arguments[1].value='atabekarapov@gmail.com';" +
                "arguments[2].value='hello!1234';", username, email, password);

    }
    @Test
    public void testCheckbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].checked=true;", checkbox1);
//        js.executeScript("arguments[1].checked=false;", checkbox2);
        js.executeScript("arguments[0].checked=true;", "arguments[1].checked=false;", checkbox1, checkbox2);

    }
    @Test
    public void testScrollDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        System.out.println(driver.manage().window().getSize().getHeight());
        System.out.println(driver.manage().window().getSize().getWidth());
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 500)");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");

    }
}


