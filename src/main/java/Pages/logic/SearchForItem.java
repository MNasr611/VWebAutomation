package Pages.logic;


import Pages.po.Home;
import core.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static utils.WebUtils.scrollElementIntoView;


public class SearchForItem extends Home {
    WebDriver driver;
    List<WebElement> webElements;

    public void Searching(String searchElement) {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
        searchBar.sendKeys(searchElement);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void validateNumberOfAdLinks(int number) {
        webElements = driver.findElements(By.xpath("//div[@class]//span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle')]"));
        //a[@href]/span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle') and contains(@dir, 'ltr')]
        //div[@class]//span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle')]
        //a[@href]/span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle')]
        Assert.assertTrue(number < webElements.size());
    }

    public void confirmTitleIsDisplayedInAdLinks() {
        for (int i = 0; i < webElements.size(); i++) {
            String title = webElements.get(i).getText();
            if(title != null){
            try {
                scrollElementIntoView(driver, webElements.get(i));
                Assert.assertTrue(webElements.get(i).isDisplayed());
                System.out.println("Title is :"+title);
            } catch (Exception e) {
                System.out.println("Not Valid Link");
            }}

        }
    }


}

