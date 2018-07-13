package com.capgemini.steps;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CGLoanEx9Steps {
    private final OurWebDriver browser;

    public CGLoanEx9Steps() throws MalformedURLException {
        browser = BrowserFactory.getWebDriver();
    }

    @Given("^the customer wants information about a loan$")
    public void theCustomerWantsInformationAboutALoan() throws Throwable {
        browser.get(System.getProperty("user.dir") + "\\src\\main\\resources\\index.html");
        Thread.sleep(1000);
    }

    @When("^the customer wants a loan for \"([^\"]*)\"$")
    public void theCustomerWantsALoanFor(final String loanType) throws Throwable {
        final List<WebElement> myListOfElements = browser.findElements(By.cssSelector("div[ng-hide='page!=1'] button.btn"));
        for (final WebElement mySingleElement : myListOfElements) {
            if (mySingleElement.getText().equals(loanType)) {
                mySingleElement.click();
                break;
            }
        }
    }

    @Then("^the customer receives the information text \"([^\"]*)\"$")
    public void theCustomerReceivesTheInformationText(final String text) throws Throwable {
        browser.waitForVisible(By.cssSelector("button.close"));
        assertThat(browser.findElement(By.cssSelector("p#tiptext")).getText(), is(text));
    }

    @Given("^I want a car loan$")
    public void iWantACarLoan() throws Throwable {
        browser.get(System.getProperty("user.dir") + "\\src\\main\\resources\\index.html");
        browser.waitForVisible(By.cssSelector("input[value='Car-loan']"));
        browser.findElement(By.cssSelector("input[value='Car-loan']")).click();
        Thread.sleep(1000);
    }

    @When("^I loan the amount of \"(\\d+)\" euro$")
    public void iLoanTheAmountOfEuro(final Integer amount) throws Throwable {
        browser.findElement(By.cssSelector("input[name='amount']")).sendKeys(amount.toString());
        browser.findElement(By.cssSelector("button#submitButton1")).click();

        browser.waitForVisible(By.cssSelector("[ng-hide='page!=2'] h2"));
        browser.findElement(By.cssSelector("input#knowledge_yes")).click();
        browser.findElement(By.cssSelector("[ng-hide='page!=2'] #submitButton")).click();

        browser.waitForVisible(By.cssSelector("h2"));
        final Faker faker = new Faker();
        browser.findElement(By.cssSelector("input#name")).sendKeys(faker.superhero().name());
        if (faker.bool().bool()) {
            browser.findElement(By.cssSelector("label[for='man']")).click();
        } else {
            browser.findElement(By.cssSelector("label[for='woman']")).click();
        }

        //TODO check birthday
        final Date birthDay = faker.date().birthday(18, 65);
        final SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
        browser.findElement(By.cssSelector("input#dob")).sendKeys(dt1.format(birthDay));
        browser.findElement(By.cssSelector("input#address")).sendKeys(faker.address().streetAddressNumber());
        browser.findElement(By.cssSelector("input#grossIncome")).sendKeys("" + faker.number().numberBetween(15000, 150000));

        final int amountOfMaritialOptions = browser.findElements(By.cssSelector("select#staat option")).size();
        browser.findElement(By.cssSelector("select#status option:nth-child(" + faker.number().numberBetween(2, amountOfMaritialOptions) + ")")).click();

        final int amountOfIncomeOptions = browser.findElements(By.cssSelector("select#typeinkomen option")).size();
        browser.findElement(By.cssSelector("select#typegrossIncome option:nth-child(" + faker.number().numberBetween(2, amountOfIncomeOptions) + ")")).click();

        final String fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\paymentslip.txt";
        browser.findElement(By.cssSelector("input#paymentslip")).sendKeys(fileLocation);

        browser.waitForClickable(By.cssSelector("[ng-hide='page!=3'] #submitButton")).click();
        browser.waitForVisible(By.cssSelector("h2"));
    }

    @Then("^I can get it$")
    public void iCanGetIt() throws Throwable {

        assertThat(browser.findElement(By.cssSelector("[ng-hide='page!=4'] h2")).getText(), is("Confirm data"));
    }
}