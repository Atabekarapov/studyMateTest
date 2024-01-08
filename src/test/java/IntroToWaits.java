import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class IntroToWaits {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to https://www.eatthismuch.com/
        2. choose 2000 calories
        3. in 3 meals
        4. click on Generate
        5. verify amount of calories in Today's plan is less than given
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.eatthismuch.com/");

        WebElement caloriesInputField = driver.findElement(By.id("cal_input"));
        int givenCalories = 2000;
        caloriesInputField.sendKeys("2000");

        Select numOfMealsDropDown = new Select(driver.findElement(By.id("num_meals_selector")));
        numOfMealsDropDown.selectByValue("3");

        WebElement generateButton = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-orange gen_button']"));
        generateButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.plan_calories"), "Calories"));
//        Thread.sleep(5000);

        WebElement totalCalories = driver.findElement(By.xpath("//div[@class='plan_calories text-medium']"));
        String totalCaloriesText = totalCalories.getText(); // "2007 Calories"
        System.out.println("Total calories: " + totalCaloriesText);

        int actualCalories = Integer.parseInt(totalCaloriesText.split(" ")[0]);
        int caloriesDifference = actualCalories-givenCalories;
        if(caloriesDifference >= 100){
            System.out.println("Failed: the mount of calories more than 100");
        }
        else{
            System.out.println("PASSED: the amount of calories within 100 range");
        }

        //FLUENT WAIT PRACTICE
//        Wait<WebDriver> wait1 = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(60))
//                .pollingEvery(Duration.ofSeconds(20))
//                .ignoring(NoSuchElementException.class);
//        wait1.until(ExpectedConditions.elementToBeClickable(By.id("")));
//
//    Driver.closeDriver();
    }
}

//pageLoadTimeOut wait

