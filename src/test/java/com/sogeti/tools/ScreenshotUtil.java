package com.sogeti.tools;

import com.sogeti.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil extends Base {
    public ScreenshotUtil() throws IOException {
    }


    public static void takePicture(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\tdkhirec\\IdeaProjects\\sogeti.com\\src\\test\\Screenshots\\"+name+".png"));
    }


}
