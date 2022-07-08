package core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;


public class Hooks {
    private static WebDriver driver;
    private final Config config = new Config();
    private DriverFactory factory = new DriverFactory();


    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        Hooks.driver = driver;
    }

    public static void embedScreenshot(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "embedScreenShot");
        } catch (WebDriverException | NullPointerException e) {
            System.out.println("Failed to take embed Screenshot");
        }
    }

    @Before(order = 1)
    public void beforeAll(Scenario scenario) {
        if (!scenario.getId().contains(" ")) {
            if (driver == null) {
                setDriver(factory.createDriver());
            }
            driver.get(config.getUrl().toString());
            PageFactory.initElements(driver, this);

        }
    }


    @After
    public void afterAll(Scenario scenario) {
        try {
            if (scenario.isFailed()) embedScreenshot(scenario);
        } catch (Exception e) {
            System.out.println("Failed to take screenshot");
        }
        driver.quit();
    }

}
