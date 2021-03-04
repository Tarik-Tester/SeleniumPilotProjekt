package com.sogeti.pages;

import com.sogeti.base.Base;
import com.sogeti.seleniumHelper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;

public class HomePage extends Base {
    @FindBy(xpath = "//*[@class='acceptCookie' or contains(@class,'eu-cookie-compliance-secondary-button btn')]")
    public WebElement acceptCookie;
    @FindBy(xpath = "//*[text()='Worldwide']")
    public WebElement WorldWide;

    @FindBy (className = "country-list")
    public WebElement Country_l;

    @FindBy(xpath = "//*[text()='Services']")
    public WebElement Services;

    @FindBy(xpath = "//*[text()='Automation']")
    public WebElement Automation;

    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    Helper helper = new Helper();
    public String getTitle(){
        String actualResultTitle = driver.getTitle();
        return actualResultTitle;
    }

    public void  automationOnKlick() {
        helper.mouseOver(Services);
        helper.mouseOver(Automation);
        helper.click(Automation);
    }

    public void acceptCookie(){
        acceptCookie.click();
    }


}
