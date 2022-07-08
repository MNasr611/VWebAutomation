package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverFactory;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class DriverFactory {
    public WebDriver driver ;

    public WebDriver createDriver() {
//      WebDriver driver = new ChromeDriver();
        driver = WebDriverFactory.createChromeWebDriver();
//        driver = new ChromeDriverManager().createDriver();
//        driver = WebDriverFactory.createChromeWebDriver();
        return driver;
    }





}
