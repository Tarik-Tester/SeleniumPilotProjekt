package com.sogeti.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page");


    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By: '" + by.toString());

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By: '" + by.toString());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        System.out.println("Trying to click on:'" + element.toString());

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on:'" + element.toString());

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charSequences) {

        System.out.println("Value of the:'" + element.toString() + "before any changes made");

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charSequences) {
        System.out.println("Element value changed to:'" + element.toString());

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String url, WebDriver driver) {
        System.out.println("beforSwitch to: '" + url + "'");

    }

    @Override
    public void afterSwitchToWindow(String url, WebDriver driver) {
        System.out.println("AfterSwitch to: '" + url + "'");

    }

    @Override
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occured: " + error);

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
