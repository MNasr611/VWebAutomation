package core;

import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;


public class DriverFactory {
    public WebDriver driver;

    public WebDriver createDriver() {
        driver = WebDriverFactory.createChromeWebDriver();

        return driver;
    }


}
