package com.sogeti.pages;

import com.sogeti.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class AutomationPage extends Base {

    @FindBy(className = "page-heading")
    public WebElement AutomationWording;

    @FindBy(xpath = "//*[@class= 'selected has-children  expanded level2 hover']")
    public WebElement AutomationIsAktiv;

    @FindBy(xpath = "//*[@class= 'selected  current expanded']")
    public WebElement ServicesIsAktiv;


    public AutomationPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
}
