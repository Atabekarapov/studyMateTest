package SeleniumPracticeDay4;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAPractice {
    public static void main(String[] args) throws InterruptedException {
        //go to https://demoqa.com/text-box
        // enter name
        // enter email
        // enter current address

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[contains(@id, 'userName')]"));
        fullName.sendKeys("Atabek");

        WebElement userEmail = driver.findElement(By.xpath("//input[@autocomplete='off' and @type='email']"));
        userEmail.sendKeys("atabek@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[starts-with(@id, 'cur')]"));
        currentAddress.sendKeys("123 John Street");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[starts-with(@id, 'per')]"));
        permanentAddress.sendKeys("885885 E Madison Street");

        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        List<WebElement> output = driver.findElements(By.xpath("//div[@id='output']//p"));
        for (WebElement element : output){
            System.out.println(element.getText());
            if(element.getText().contains("Name") && element.getText().contains("Atabek")){
                System.out.println("Pass: the name was displayed properly!");
            }
        }

    }
}

