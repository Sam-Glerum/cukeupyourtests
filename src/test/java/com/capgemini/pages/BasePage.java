package com.capgemini.pages;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BasePage {

    protected OurWebDriver browser = null;
    protected By topLink = By.cssSelector("h2 a");

    public BasePage() {
        try {
            browser = BrowserFactory.getWebDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String name) throws IOException {
        //Store a file in my temp folder
        File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\temp\\screenshot_" + name + "_" + System.currentTimeMillis() + ".jpg"));
    }
}
