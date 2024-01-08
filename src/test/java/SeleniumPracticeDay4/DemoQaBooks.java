package SeleniumPracticeDay4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQaBooks {
    public static void main(String[] args) throws InterruptedException {
        //1. go to https://demoqa.com/books
        //2. click on Speaking JavaScripts
        //3. verify title is Speaking JavaScript
        //4. verify author is Axel Rauschmayer
        //5. verify pages number is 460
        //6. click on Back to book store button
        //7. verify url is "https://demoqa.com/books"
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize(); // maximize it, we still can see the tab bars
//        driver.manage().window().fullscreen(); // full screen it, we are not able to see it
//        driver.navigate().refresh(); //
//        driver.navigate().back(); //
//        driver.navigate().forward(); //

        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[contains(text(), 'Speaking JavaScript')]")).click();
        driver.getTitle();

        String actualTitle = driver.findElement(By.xpath("//div[@id='title-wrapper']/div[@class='col-md-9 col-sm-12']")).getText();
        if(actualTitle.equals("Speaking JavaScript")){
            System.out.println("Pass: title matches expected title");
        }
        driver.findElement(By.cssSelector("button#addNewRecordButton")).click();
    }
}
