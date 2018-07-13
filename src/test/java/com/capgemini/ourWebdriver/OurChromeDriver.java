package com.capgemini.ourWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.capgemini.ourWebdriver.BrowserFactory.getDriverFile;

/**
 * Created by dlammers on 2/27/2017.
 */
public class OurChromeDriver extends ChromeDriver implements OurWebDriver {

    private static OurChromeDriver browser;

    private OurChromeDriver() {

    }

    static OurChromeDriver getBrowser() {
        System.setProperty("webdriver.chrome.driver", getDriverFile("chrome"));
        if (browser == null) {
            browser = new OurChromeDriver();
        } else if (browser.getSessionId() == null) {
            browser = new OurChromeDriver();
        }
        return browser;
    }

    public WebElement waitForElement(final String selector) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public WebElement waitForElement(final By by) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForVisible(final String selector) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    public WebElement waitForVisible(final By by) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForClickable(final String selector) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public WebElement waitForClickable(final By by) {
        final WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void scrollToElement(final WebElement element) {
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForAjax() {
        final WebDriverWait webDriverWait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                final String scriptToExecute =
                        "return jQuery.active == 0;";
                final Boolean ajaxDone = Boolean.valueOf(((JavascriptExecutor) driver).executeScript(scriptToExecute).toString());
                return ajaxDone ? true : null;
            }
        });
    }

}
