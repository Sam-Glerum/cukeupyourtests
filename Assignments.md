# Assignments

All the files which you will need to edit in these assignments are located in **src/test/java/com/capgemini** or **src/test/resources/features**.
> It might be a good idea to open the local html file that is used in the first assignments in a chrome browser (**src/main/resources/index.html**).

## Exercise 1

 1. In **loan.feature**, Right-click on the scenario name 'request a car loan' and choose 'Run Scenario...'
 2. As you can see the webpage gives an error message because the desired amount to borrow is lower than the minimum. 
    Update the step "**And** the amount I want to borrow is '1000'" so that this error message is no longer given. Run the scenario to check that it works.
> The steps are located in **steps/CGLoansSteps**
 3. Create the step "**And** I continue to explanation" (just remove the #). The background color of the step will turn into brown box, this means that there is no java connected to this step. 
    Use Alt + Enter, choose 'Create step definition', choose loan_steps (com.capgemini.steps).
 4. Check the generated java code, remove the auto generated `throw new PendingException();`. 
    This exception is generated to make sure that you understand java code a bit before you can run a successful execution.
 5. In IntelliJ, navigate to **index.html**, right-click on it and select 'Open in browser -> Chrome'. 
    In Chrome right-click the "Continue to explanation" button and select "Inspect" to identify the selector for this button.
 6. In IntelliJ use copy paste from the code in `iSelectLoanTypeCarLoan()` method, change the CSS selector to the selector you found in Chrome.
 7. Is `.click()` the right method to use here?
 8. Run the scenario

## Exercise 2

1. On the second page, check if the 'Chosen loan type' and 'Amount to borrow' values are what you expect.
> You can use Assert.assertEquals() to verify if the shown values are correct.
2. Run the scenario. Is your css selector working?
> The CheatSheet.docx has tips for finding unique selectors.
3. Create steps that allows you to continue to the personal data page

## Exercise 3

1. Create new steps for every field on the page. For every step, change the selector and use the correct interaction.
2. Can you upload a file?

## Exercise 4

1. Parameterize the input data in the step "**And** the amount I want to borrow is '1000'". (See Exercise 1.2)
2. Can you parameterize other data as well?

## Exercise 5

1. Navigate back to the first page of your loan request.
2. In loan.feature, create a new step after "**Given** I have opened the loan request page" to click the different options under "Why do you need a loan?".
> Use the Cheatsheet.docx to find good selectors for the buttons. You can also look into xpath selectors for this assignment.
3. Create a step to close the pop-up. What issues do you face?
> Use smart waits if elements are not immediately available.
4. Use Scenario Outlines to execute this scenario several times with different data.

## Exercise 6

1. Create a new scenario in the same feature file.
2. Reuse the steps from the first scenario, but choose different options and values where you can.
3. Execute the new scenario.

## Exercise 7

1. The website is responding too fast for your eyes to follow everything. 
   We can add screenshots at key points to see what is happening on each page. 
   Try adding screenshots at key points of your scenario and save these to view later on.
   ```java 
    //Store a screenshot in my temp folder
    File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source, new File("C:\\temp\\screenshot" + System.currentTimeMillis() + ".jpg"));
    ```
2. In Browser.properties you can choose in which webbrowser you want to run your tests. 
   Make sure your scenarios work on Firefox (firefox), Chrome (chrome) and InternetExplorer (ie) using the same code.

# Turn it up a notch

## Exercise 8

Random id's are occuring more often in websites, so is your test ready for this?

1. Open **src/main/resources/index.html** and search for below code (near line 361);
    ```javascript
    $scope.rid = '';
    $scope.rid2 = '';
    ```
2. Replace the code to;
    ```javascript
    $scope.rid = Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10) + ':';
    $scope.rid2 = Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10) + ':';
    ```
3. Run your scenario's again, fix what you need to fix.

## Exercise 9

1. Use [faker](https://github.com/DiUS/java-faker) to generate random data for the personal data you created in Exercise 3.

## Exercise 10

1. Create a BasePage as explained in [TAGuidelines.md](TAGuidelines.md)
2. Create 4 different pages, 1 for each html page in the assignment and fill it with the selectors as shown in the coding guidelines of [TAGuidelines.md](TAGuidelines.md). 
   Make sure your new pages extend the BasePage.
3. In your steps file, use functions on the pages to interact with the elements.

## Exercise 11

1. Reduce your Gherkin to **Given When Then** (preferrably 3 lines, max 4/5 lines) such that the core of the test is clear.
   This means that each method in your step function will do more than 1 action. In this way, your code has become more readable.
   
