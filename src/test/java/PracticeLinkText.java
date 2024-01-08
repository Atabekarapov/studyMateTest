import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class PracticeLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement redirectLink = driver.findElement(By.linkText("Redirect Link"));
        redirectLink.click();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
//        driver.quit();

        driver.findElement(By.linkText("Checkboxes")).click();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.linkText("Dynamic Content")).click();
        driver.navigate().back();

        System.out.println("Try partial link text");

        driver.findElement(By.partialLinkText("Broken Images")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();

        List<WebElement> listOfDynamicLinks = driver.findElements(By.partialLinkText("Dynamic"));
        System.out.println(listOfDynamicLinks.size());
        for(WebElement element : listOfDynamicLinks){{
            element.click();
            System.out.println("The new page url: " + driver.getCurrentUrl());
            driver.navigate().back();
        }}
    }

    public static class Driver {
        private static WebDriver driver = null;
        public static WebDriver getDriver(String browser){
            if(driver != null){
                return driver;
            }
            switch (browser){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                case "safari":
                    driver = new SafariDriver();
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

            /*
            this is pageLoadTimeout, waits until the page is fully loaded
             */

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            return driver;
        }

        public static void closeDriver(){
            if(driver != null){
                driver.quit();
            }
        }

        public static void main(String[] args) {

        }
    }
}
