package SeleniumPracticeDay4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeCSS {
    public static void main(String[] args) {
        /*
        1. go to https://demoqa.com/books
        2. in search field, search for "Git Pocket Guide"
        3. verify Author is "Richard E. Silverman
        4. verify "Login" button is displayed and clickable
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60000));




        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
        String bookName = "Git Pocket Guide";

        WebElement searchBox = driver.findElement(By.cssSelector("input#searchBox"));
        searchBox.sendKeys(bookName);

        String actualAuthorName = driver.findElement(By.xpath("//div[text()='Richard E. Silverman']")).getText();
        String expectedAuthorName = "Richard E. Silverman";
        if(actualAuthorName.equals(expectedAuthorName)){
            System.out.println("PASS");
        }
        WebElement loginButton = driver.findElement(By.cssSelector("button.btn-primary"));
        if (loginButton.isDisplayed()){
            System.out.println("PASS, the button is there");
        }
    }
}
