package CheckBoxAndRadioButton;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

/*
1. Go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html --> done
2. From "Dropdown Menu(s)" select: Python, Maven, Javascript --> done
3. From "Checkboxe(s)" select all 4 checkboxes --> done
4. From "Radio Button(s)" select Blue --> done
5. From "Selected & Disabled" select Pumpkin --> done
6. From "Checkboxe(s)" deselect checkbox option 1 & 2 --> done
7. From "Radio Button(s)" select Green --> done
8. From "Dropdown Menu(s)" select: Java --> done
 */
public class Assignment1 {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
//        Thread.sleep(5000);
        Select select = new Select(driver.findElement(By.xpath("//select[@class='dropdown-menu-lists' and @id='dropdowm-menu-1']")));
        select.selectByIndex(2);
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']")));
        select1.selectByIndex(1);
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']")));
        select2.selectByIndex(2);

        driver.findElement(By.xpath("//input[@value='option-1']")).click();
        driver.findElement(By.xpath("//input[@value='option-2']")).click();
        driver.findElement(By.xpath("//input[@value='option-4']")).click();

        driver.findElement(By.xpath("//input[@value='blue']")).click();

        driver.findElement(By.xpath("//input[@value='pumpkin']")).click();

        driver.findElement(By.xpath("//input[@value='option-1']")).click();
        driver.findElement(By.xpath("//input[@value='option-2']")).click();

        driver.findElement(By.xpath("//input[@value='green']")).click();

        Select selectJava = new Select(driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']")));
        selectJava.selectByIndex(0);
    }

}
