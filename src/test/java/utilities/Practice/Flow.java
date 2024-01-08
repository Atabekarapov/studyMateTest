package utilities.Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Flow {
    /**
     * This method should be used when we need to click on a dynamic webElement and
     * ignore NoSuchElementException if it appears
     *
     * @param locator is the element to be clicked
     * @param driver  is driver to connect to UI
     * @author Atabek Arapov
     */
    public static void safeClick(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
        } catch (NoSuchElementException | ElementClickInterceptedException e) {
            System.out.println("Element not found!");
            e.printStackTrace();
        }
    }

    /**
     * This method will safely try to switch to iframe
     *
     * @param driver  is the driver to connect to UI
     * @param locator is the WebElement of iframe to switch to
     * @author Atabek Arapov
     */
    public static void safeSwitchToFrame(WebDriver driver, By locator) {
        try {
            driver.switchTo().frame(driver.findElement(locator));
        } catch (NoSuchFrameException e) {
            System.out.println("No iframe to switch to!");
            e.printStackTrace();
        }
    }

    /**
     * This method safely switches to new window by windowhandle or by name
     * in case if there is no window, it ignores the Exception
     *
     * @param driver             to get to UI
     * @param nameOrWindowHandle is unique ID of Window to switch to
     * @author Atabek Arapov
     */
    public static void safelySwitchToWindow(WebDriver driver, String nameOrWindowHandle) {
        try {
            driver.switchTo().window(nameOrWindowHandle);

        } catch (NoSuchWindowException e) {
            System.out.println("No window to switch to was found. Check the windowHandle or name!");
            e.printStackTrace();
        }
    }

    /**
     * This method checks if driver is in main parent window, and then only switch to new window
     * if driver is already in new window, that method will not switch
     *
     * @param driver             to get to UI
     * @param parentWindowHandle is the parent window
     * @param nameOrWindowHandle is unique ID of Window to switch to
     * @author Atabek Arapov
     */
    public static void safelySwitchToWindow(WebDriver driver, String parentWindowHandle, String nameOrWindowHandle) {
        try {
            if (driver.getWindowHandle().equals(parentWindowHandle)) {
                driver.switchTo().window(parentWindowHandle);
            }

        } catch (NoSuchWindowException e) {
            System.out.println("No window to switch to was found. Check the windowHandle or name!");
            e.printStackTrace();
        }
    }

    /**
     * This method tries to cloick on WebElement multiple times
     * before throwing NoSuchElementException
     *
     * @param driver       to connect to UI
     * @param locator      element to be clicked
     * @param numOfRetries number of click retries
     * @author Atabek Arapov
     */
    public static void clickWithRetries(WebDriver driver, By locator, int numOfRetries) throws InterruptedException {
        for (int i = 1; i <= numOfRetries; i++) {
            try {
                Thread.sleep(1000);
                driver.findElement(locator).click();
                break;
            } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException |
                     InterruptedException e) {
                System.out.println("Failed to click on the WebElement. Retry #" + i);
                System.out.println("Trying again ...");
                e.printStackTrace();

            }
        }
    }

    /**
     * This method safely sends keys to locator and ignores the Exception if failed to send keys
     *
     * @param driver  to connect to UI
     * @param locator to send keys to
     * @param keys    String to send
     * @author Atabek Arapov
     */
    public static void safeSendKeys(WebDriver driver, By locator, String keys) {
        try {
            driver.findElement(locator).sendKeys(keys);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Failed to send keys: " + keys);
            e.printStackTrace();
        }
    }

    /**
     * This method takes screenshot and stores it in a file
     * @param driver to connect to UI
     * @param pathToFile pathToFile and fileName of the screenshot
     * @author Atabek Arapov
     */
    public static void takeScreenshot(WebDriver driver, String pathToFile) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            //copy file from src to new path
            FileUtils.copyFile(src, new File(pathToFile));
        } catch (IOException e) {
            System.out.println("Failed to store screenshot in given file. Check the file path!");
            System.out.println("The file path provided" + pathToFile);
        }
    }
}
