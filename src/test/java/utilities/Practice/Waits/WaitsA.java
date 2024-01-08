package utilities.Practice.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.UtilWait;

public class WaitsA {
    public static void explicitClickable(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        UtilWait.waitUntilElementIsClickable(driver, 10, By.xpath("//form[@id='input-example']/input"));

        driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Hello");

    }
    public static void explicitInvisible(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();
        UtilWait.waitUntilElementIsVisible(driver, 5, By.xpath("//h4[.='Hello World!']"));


    }
}
