import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IntroToSelectClass {
    public static void main(String[] args) {
        /*
        1. go to blazedemo.com
        2. choose Boston as departure city
        3. choose London as destination city
        4. click on "Find flights"
        5. validate "Flights from Boston to London:"
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");

        WebElement departure = driver.findElement(By.name("fromPort"));
        Select departureDropDown = new Select(departure);

        departureDropDown.selectByValue("Boston");

        System.out.println(departureDropDown.getAllSelectedOptions().get(0).getText());
        WebElement destination = driver.findElement(By.name("toPort"));
        Select destinationDropDown = new Select(destination);
        destinationDropDown.selectByVisibleText("London");

        WebElement findFlightsButton = driver.findElement(By.cssSelector("input.btn"));
        findFlightsButton.click();

        String actualText = driver.findElement(By.xpath("//table[@class='table']//preceding::h3")).getText();
        if(actualText.equals("Flights from Boston to London:")){
            System.out.println("Found flights!");
        }
        else {
            System.out.println("fail");
        }
    }

}


