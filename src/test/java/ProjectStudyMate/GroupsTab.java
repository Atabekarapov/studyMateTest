package ProjectStudyMate;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.UtilWait;

public class GroupsTab {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://codewiser.studymate.us/admin/groups");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin@codewise.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codewise123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/admin/groups']//li[@class='MuiListItem-root MuiListItem-gutters MuiListItem-padding sc-idXgbr VObHa css-1yo8bqd']")).click();
        driver.findElement(By.xpath("//header[@class='css-1v74z38']//button[@type='button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Group name");
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")).click();
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-bekps4'][text()='1']")).click();
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Hello there");
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium css-jlubt3']")).click();
//        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equals("https://codewiser.studymate.us/admin/groups?size=8&page=1")){
            System.out.println("PASS: Main page is correct");
        }
        else{
            System.out.println("FAIL: Main page is wrong");
        }
        driver.findElement(By.xpath("//header[@class='css-1v74z38']//button[@type='button']")).click();
        Thread.sleep(3000);
//        WebElement addPhoto = driver.findElement(By.xpath("//img[@class='sc-jRwbcX bmXWmJ']"));
//        addPhoto.click();
//        addPhoto.sendKeys("yex0Gcbi.jpg");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Groups");
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")).click();
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-bekps4'][text()='1']")).click();
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Hello there 2");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        if(driver.findElement(By.xpath("//div[contains(text(), 'Gr')]")).getText().contains("Gr")){
            System.out.println("PASS: New created groups exists in the main page");
        }
        else{
            System.out.println("FAIL: New created groups doesn't exist in the main page");
        }

    }
    @Test
    public void deleteButton(){

}
    @Test
    public void editButton(){

}
}
