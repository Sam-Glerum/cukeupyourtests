package com.capgemini.steps;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import com.capgemini.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;

import static com.capgemini.utils.FileHelper.getRootPath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CGLoansSteps {
    private final OurWebDriver browser;

    public CGLoansSteps() throws MalformedURLException {
        browser = BrowserFactory.getWebDriver();
    }

    @Given("^I have opened the loan request page$")
    public void iHaveOpenedTheLoanRequestPage() throws Throwable {
        browser.get("file:///" + getRootPath() + "/src/main/resources/index.html");
        Thread.sleep(1000);
    }

    @When("^I select a loan type$")
    public void iSelectLoanTypePersonalLoan() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.selectLoanTypePersonalLoan();
    }

    @When("^I select loan type 'Car-loan'$")
    public void iSelectLoanTypeCarLoan() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.selectLoanTypeCarLoan();
    }

    @When("^the amount I want to borrow is '(\\d+)'$")
    public void theAmountIWantToBorrowIs(final Integer amount) throws Throwable {
        browser.findElement(By.cssSelector("input[name='amount']")).sendKeys(amount.toString());
    }

    @When("^I continue to explanation$")
    public void iContinueToExplanation() throws Throwable {
        Thread.sleep(1000);
        browser.findElement(By.cssSelector("button#submitButton1")).click();
        Thread.sleep(1000);
    }

    @When("^I select that I have knowledge about loans$")
    public void iSelectThatIHaveKnowledgeAboutLoans() throws Throwable {
        browser.findElement(By.cssSelector("input#knowledge_yes")).click();
    }

    @When("^I select that I do not have knowledge about loans$")
    public void iSelectThatIDoNotHaveKnowledgeAboutLoans() throws Throwable {
        browser.findElement(By.cssSelector("input#knowledge_no")).click();
    }

    @And("^I continue to personal data$")
    public void iContinueToPersonalData() throws Throwable {
        Thread.sleep(1000);
        browser.findElement(By.cssSelector("[ng-hide='page!=2'] #submitButton")).click();
        Thread.sleep(1000);
    }

    @When("^I fill the name as \"([^\"]*)\"$")
    public void iFillTheNameAs(final String name) throws Throwable {
        browser.findElement(By.cssSelector("input#name")).sendKeys(name);
    }

    @And("^I am a male$")
    public void iAmAMale() throws Throwable {
        browser.findElement(By.cssSelector("label[for='man']")).click();
    }

    @And("^I am born on (\\d+-\\d+-\\d+)$")
    public void iAmBornOn(final String date) throws Throwable {
        browser.findElement(By.cssSelector("input#dob")).sendKeys(date);
    }

    @And("^I live on \"([^\"]*)\"$")
    public void iLiveOn(final String address) throws Throwable {
        browser.findElement(By.cssSelector("input#address")).sendKeys(address);
    }

    @And("^I have an income of (\\d+)$")
    public void iHaveAnIncomeOf(final Integer income) throws Throwable {
        browser.findElement(By.cssSelector("input#grossIncome")).sendKeys(income.toString());
    }

    @And("^I am married$")
    public void iAmMarried() throws Throwable {
        browser.findElement(By.cssSelector("select#status option[value='married']")).click();
    }

    @And("^I have a permanent contract$")
    public void iHaveAPermanentContract() throws Throwable {
        browser.findElement(By.cssSelector("select#typegrossIncome option[value='permanent contract']")).click();
    }

    @And("^I upload my payment slip$")
    public void iUploadMyPaymentSlip() throws Throwable {
        final String fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\paymentslip.txt";
        browser.findElement(By.cssSelector("input#paymentslip")).sendKeys(fileLocation);
    }

    @And("^I continue to submit the loan request$")
    public void iContinueToSubmitTheLoanRequest() throws Throwable {
        Thread.sleep(1000);
        WebElement element = browser.findElement(By.cssSelector("[ng-hide='page!=3'] #submitButton"));
        browser.scrollToElement(element);
        element.click();
        Thread.sleep(1000);
    }

    @Then("^I have to confirm my data$")
    public void iHaveToConfirmMyData() throws Throwable {
        assertThat(browser.waitForVisible(By.cssSelector("[ng-hide='page!=4'] h2")).getText(), is("Confirm data"));
        Thread.sleep(5000);
    }

}