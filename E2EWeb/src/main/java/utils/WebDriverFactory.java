package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class WebDriverFactory {
    public static WebDriver createChromeWebDriver() {
        WebDriverManager.chromedriver().reset();
        WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
