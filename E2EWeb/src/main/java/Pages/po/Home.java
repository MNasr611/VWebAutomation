package Pages.po;

import core.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home extends Hooks {
    //extending hooks to enable
    //PageFactory.initElements(driver, this);
    @FindAll({
            @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    })
    public static WebElement searchBar;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//span[@dir='ltr']")
    })
    public static WebElement href;
}
