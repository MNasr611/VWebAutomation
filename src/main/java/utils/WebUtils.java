package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebUtils {

    public static void waitForVisible(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement getElementFromList(WebDriver driver, final WebElement listElement, final int index) {
        waitForVisible(driver, listElement);
        final Select selectList = new Select(listElement);
        return (selectList.getOptions().get(index));
    }

    public static void implicitWait(WebDriver driver, final int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void scrollElementIntoView(WebDriver driver, final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", webElement);
        implicitWait(driver, 50);
    }
}
