package SeleniumCSS;

import jdk.jshell.execution.Util;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;

import static utilities.JsUtils.click;

public class MagentoHW {
    //1. go to https://magento.softwaretestingboard.com/ --> done
    //2. click on "Sale" --> done
    //3. click on "Women's deals" -->
    //4. choose size, color of the first product and add to cart --> done
    //5. click on add to cart for a second product --> done
    //6. choose size, color, quantity and add to cart --> done
    //7. go to cart --> done
    //8. click on "Proceed to Checkout" --> done
    //9. checkout --> done // I printed checkout at the end!
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testMagento() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//span[contains(text(), 'Sale')]")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//span[contains(text(), 'Shop Women’s Deals')]")).click();
        js.executeScript("window.scrollBy(0,450)", "");
        driver.findElement(By.xpath("//div[@class='swatch-opt-1983']//div[@class='swatch-attribute size']//div[@class='swatch-attribute-options clearfix']//div[@id='option-label-size-143-item-171']")).click();
//        Thread.sleep(5000);
//        UtilWait.waitUntilElementIsClickable(driver, 10, By.cssSelector("div[class='swatch-option color selected']"));
        driver.findElement(By.xpath("//div[@class='swatch-opt-1983']//div[@class='swatch-attribute color']//div[@class='swatch-attribute-options clearfix']//div[@class='swatch-option color' and @id='option-label-color-93-item-50']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//form[@action='https://magento.softwaretestingboard.com/checkout/cart/add/uenc/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9wcm9tb3Rpb25zL3dvbWVuLXNhbGUuaHRtbA%2C%2C/product/1983/']//button[@class='action tocart primary']//span[contains(text(), 'Add to Cart')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='swatch-opt-1935']//div[@class='swatch-attribute size']//div[@class='swatch-attribute-options clearfix']//div[@id='option-label-size-143-item-171']")).click();
        driver.findElement(By.xpath("//div[@class='swatch-opt-1935']//div[@class='swatch-attribute color']//div[@class='swatch-attribute-options clearfix']//div[@id='option-label-color-93-item-52']")).click();
        UtilWait.waitUntilElementIsClickable(driver, 5, By.xpath("//form[@data-product-sku='WSH02']//button[@class='action tocart primary']//span[contains(text(), 'Add to Cart')]"));
        driver.findElement(By.xpath("//form[@data-product-sku='WSH02']//button[@class='action tocart primary']//span[contains(text(), 'Add to Cart')]")).click();
        js.executeScript("window.scrollBy(0,-400)", "");
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        System.out.println("Checkout button worked!");
//        driver.quit();

//        driver.close();
//        driver.navigate().refresh();
        driver.close();

    }
}
