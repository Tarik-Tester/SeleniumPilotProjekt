package com.sogeti.TestCases;

import com.sogeti.base.Base;
import com.sogeti.pages.AutomationPage;
import com.sogeti.pages.HomePage;
import com.sogeti.seleniumHelper.Helper;
import com.sogeti.tools.ScreenshotUtil;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;


public class CountryTest extends Base {

    AutomationPage automation;
    HomePage home;
    Helper helper = new Helper();

    public CountryTest() throws IOException {

    }

    @Parameters({"browser"})
    @BeforeMethod
    public void StartBrowser(String browser) throws IOException {
        SetUp(browser);
        automation = new AutomationPage();
        home = new HomePage();
        Helper helper = new Helper();
        helper.click(home.acceptCookie);

    }

    @AfterMethod
    public void close() {
        cleanUp();
    }

    @Test
    public void AllCountry(Method method) throws IOException, InterruptedException {

        int fehler = 0;
        List<String> fehler_liste = new ArrayList<>();

        ArrayList<String> Cityliste = new ArrayList<String>();
        Cityliste.add("Sogeti Belgium");
        Cityliste.add("Sogeti Finland");
        Cityliste.add("Sogeti France");
        Cityliste.add("Sogeti Deutschland");
        Cityliste.add("Sogeti Ireland");
        Cityliste.add("Sogeti Luxembourg");
        Cityliste.add("We Make Technology Work | Sogeti");
        Cityliste.add("Sogeti Norge");
        Cityliste.add("Sogeti España");
        Cityliste.add("Sogeti Sverige");
        Cityliste.add("Sogeti UK");
        Cityliste.add("Sogeti USA");


        helper.click(home.WorldWide);
        List<WebElement> countryList = home.Country_l.findElements(By.tagName("a"));
        int count = countryList.size();
        //System.out.println(country_l.findElements(By.tagName("a")).size());
        for (int i = 0; i < count; i++) {
            helper.waitForClickable(countryList.get(i), 5);
            countryList.get(i).click();
            //countryList.get(i).getText();
            System.out.println("*********" + countryList.get(i).getText() + "**********");
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            //driver.switchTo().window(tabs2.get(1));
            helper.wechselzuTab1();
            Thread.sleep(1000);
            String actualResult = home.getTitle();
            String expectedResult = Cityliste.get(i);
            System.out.println("*********" + Cityliste.get(i) + "**********");


            try {
                Assert.assertTrue(actualResult.contains(expectedResult));
            } catch (AssertionError e) {
                ScreenshotUtil.takePicture(method.getName());
                fehler++;
                fehler_liste.add("Eine Abweichung ist aufgetretten: \n Expected: - " + expectedResult + "\n Actual: - " + actualResult);
            }
            // ScreenshotUtil.takePicture(method.getName());
            Thread.sleep(1000);

            //driver.close();
            helper.closeTab1();
            //driver.switchTo().window(tabs2.get(0));
            helper.wechselZureuckZuTab0();
        }
        if (fehler > 0) {

            System.out.println("\nTestfall ist failed, folgende Abweichungen sind aufgetretten: \n");
            for (int i = 0; i < fehler_liste.size(); i++) {
                System.out.println(fehler_liste.get(i) + "\n");
            }
            fail("\n Test failed \n");

        }


    }


}
