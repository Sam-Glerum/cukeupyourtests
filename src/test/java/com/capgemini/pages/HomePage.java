package com.capgemini.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends BasePage {

    private By carLoanRadio = By.cssSelector("input[value='Car-loan']");
    private By miniLoanRadio = By.cssSelector("input[value='Mini-loan']");
    private By personalLoanRadio = By.cssSelector("input[value='Personal loan']");
    private By tipText = By.cssSelector("p#tiptext");
    private By closeButton = By.cssSelector("button.close");

    public void selectLoanTypeCarLoan() throws Throwable {
        browser.findElement(carLoanRadio).click();
        Thread.sleep(1000);
    }

    public void selectLoanTypeMiniLoan() throws Throwable {
        browser.findElement(miniLoanRadio).click();
        Thread.sleep(1000);
    }

    public void selectLoanTypePersonalLoan() throws Throwable {
        browser.findElement(personalLoanRadio).click();
        Thread.sleep(1000);
    }

    public void clickINeedALoanFor(String loanType) {
        final List<WebElement> myListOfElements = browser.findElements(By.cssSelector("div[ng-hide='page!=1'] button.btn"));
        for (final WebElement mySingleElement : myListOfElements) {
            if (mySingleElement.getText().equals(loanType)) {
                mySingleElement.click();
                break;
            }
        }
    }

    public void validateTipText(String text) throws IOException {
        browser.waitForVisible(closeButton);
        Assert.assertEquals(text, browser.findElement(tipText).getText());
    }

}
