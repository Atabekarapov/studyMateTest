package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alerts2 {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.allrecipes.com/recipe/235052/moms-potato-latkes/");
    }
}
