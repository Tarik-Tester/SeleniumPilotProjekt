package com.sogeti.seleniumHelper;

import com.sogeti.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;

public class Helper extends Base {


    public Helper() throws IOException {
        super();
    }

    public String getURL() {
        String actualResultUrl = driver.getCurrentUrl();
        return actualResultUrl;
    }

    public String getTitle() {
        String actualResultTitle = driver.getTitle();
        return actualResultTitle;
    }


    public boolean isDisplayed(WebElement element) {

        boolean isDisplayed = element.isDisplayed();
        return isDisplayed;
    }
    public String getText(WebElement element) {
        return element.getText();
    }
    public void waitForClickable(WebElement by, int timer) {
        int attempts = 0;
        while (attempts < 4) {
            try {
                WebDriverWait exists = new WebDriverWait(driver, timer);
                exists.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
                break;
            } catch (WebDriverException e) {
                System.out.println("Element nicht klickbar, wird noch mal versucht...");
                System.out.println(e);
            }
            if (attempts == 3) {
                System.out.println("Element kann nicht geklickt werden");
                Assert.fail();
            }
            attempts++;
        }
    }

    public boolean elementExists(WebElement element, int timer) {
        try {
            WebDriverWait exists = new WebDriverWait(driver, timer);
            exists.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            // exists.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf( element)));
            return true;
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException | NoSuchWindowException e) {
            return false;
        }
    }
    public void mouseOver(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void click(WebElement element){
        waitForClickable(element,5);
        element.click();
    }

    public void wechselzuTab1(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void wechselZureuckZuTab0(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
    }
    public void closeTab1(){
        driver.close();
    }

}
