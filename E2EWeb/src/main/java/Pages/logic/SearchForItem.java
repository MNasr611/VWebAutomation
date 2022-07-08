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
//        System.out.println(href.getSize());
//        List<WebElement> webElements = driver.findElements(By.xpath("//*[@class='yuRUbf' and @href]"));


    }

    public void validateNumberOfAdLinks(int number) {
//        webElements = driver.findElements(By.xpath("//*[contains(text(),'Car') or contains(text(),'Cars') or contains(text(),'Vehicle') and @a='href' and @dir='ltr']"));
//        Assert.assertTrue(webElements.size() > number);
//        System.out.println(webElements.size());
//        webElements = driver.findElements(By.xpath("//div[@role='heading' and @aria-level='3']/span[@dir='ltr']"));
//        webElements = driver.findElements(By.xpath("//*[@href]/span[@dir='ltr']"));
//        webElements = driver.findElements(By.xpath("//*[@href]/span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle')]"));
        webElements = driver.findElements(By.xpath("//span[contains(text(),'Cars') or contains(text(),'Car') or contains(text(),'Vehicle')]"));
//span[contains(text(),'Cars')]
//div[@role="heading"]/span[@dir="ltr"]
        System.out.println(webElements.size());
    }

    public void confirmTitleIsDisplayedInAdLinks() {
        for (int i = 0; i < webElements.size(); i++) {
            String text = webElements.get(i).getText();
            System.out.println("text");

            try {
                scrollElementIntoView(driver, webElements.get(i));
                Assert.assertTrue(webElements.get(i).isDisplayed());
            } catch (Exception e) {
                System.out.println("Not Valid Link");
            }

        }
    }


}

