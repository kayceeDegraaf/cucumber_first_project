package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
   CarvanaCarFinderPage carvanaCarFinderPage;
   CarvanaTryCarFinderPage carvanaTryCarFinderPage;
   CarvanaSellTradePage carvanaSellTradePage;
   CarvanaGetOfferPage carvanaGetOfferPage;
   CarvanaLoanCalcPage carvanaLoanCalcPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaTryCarFinderPage = new CarvanaTryCarFinderPage();
        carvanaSellTradePage = new CarvanaSellTradePage();
        carvanaGetOfferPage = new CarvanaGetOfferPage();
        carvanaLoanCalcPage = new CarvanaLoanCalcPage();
    }
    //NOTE: CAR FINDER COMES LATE -- IMPLEMENT A WAITER

    //@todo : first scenario

    //1. (S1) When user clicks on “CAR FINDER” menu item
    //2. (S2) When user clicks on "SELL/TRADE" menu item
    //3. (S3) And user clicks on "AUTO LOAN CALCULATOR" menu item
    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String menuItem) {
        carvanaHomePage.clickOnMenuLink(menuItem);
    }

    //1. (S1) Then user should be navigated to “https://www.carvana.com/help-me-search/”
    //2. (S1) Then user should be navigated to “https://www.carvana.com/help-me-search/qa”
    //3. (S2) Then user should be navigated to "https://www.carvana.com/sell-my-car"
    @Then("user should be navigated to {string}")
    public void userThenNavigatesTo(String url){
        Assert.assertEquals(url,driver.getCurrentUrl());
    }

    //1. (S1) And user should see "WHAT CAR SHOULD I GET?" text
    //2. (S1) And user should see "Car Finder can help! Answer a few quick questions to find the right car for you." text
    //3. (S1) And user should see "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?" text
    //4. (S1) And user should see "Select up to 4 in order of importance" text
    //5. (S2) And user should see "GET A REAL OFFER IN 2 MINUTES" text
    //6. (S2) And user should see "We pick up your car. You get paid on the spot." text
    //7. (S2) Then user should see "We couldn’t find that VIN. Please check your entry and try again." text
    @Then("user should see {string} text")
    public void user_should_see_text(String heading) {
        switch (heading){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaCarFinderPage.heading1.isDisplayed());
                Assert.assertEquals(heading, carvanaCarFinderPage.heading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaCarFinderPage.heading3.isDisplayed());
                Assert.assertEquals(heading, carvanaCarFinderPage.heading3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaTryCarFinderPage.pageHeadLine.isDisplayed());
                Assert.assertEquals(heading, carvanaTryCarFinderPage.pageHeadLine.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaTryCarFinderPage.pageSubHeading.isDisplayed());
                Assert.assertEquals(heading, carvanaTryCarFinderPage.pageSubHeading.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSellTradePage.mainHeading.isDisplayed());
                Assert.assertEquals(heading, carvanaSellTradePage.mainHeading.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellTradePage.subHeading.isDisplayed());
                Assert.assertEquals(heading, carvanaSellTradePage.subHeading.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Assert.assertTrue(carvanaGetOfferPage.errorMessage.isDisplayed());
                Assert.assertEquals(heading, carvanaGetOfferPage.errorMessage.getText());
                break;
            default:
                throw new NotFoundException("The heading is not defined properly in the feature file!!!");


    }
    }

    //1. (S1) And user should see “TRY CAR FINDER” link
    @Then("user should see {string} link")
    public void user_should_see_link(String link) {
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isEnabled());
        Assert.assertEquals(link,carvanaCarFinderPage.tryCarFinderLink.getText());
    }

    //1. (S1) When user clicks on “TRY CAR FINDER” link
    @When("user clicks on {string} link")
    public void user_clicks_on_link(String link) {
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isEnabled());
        carvanaCarFinderPage.tryCarFinderLink.click();
    }


    //@todo : second scenario

    //1. (S2) When user clicks on "VIN" button
    //2. (S2) And user clicks on "GET MY OFFER" button
    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        switch (button){
            case "VIN":
                Assert.assertTrue(carvanaSellTradePage.vinButton.isDisplayed());
                Assert.assertTrue(carvanaSellTradePage.vinButton.isEnabled());
                carvanaSellTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                Assert.assertTrue(carvanaSellTradePage.getYourOfferButton.isDisplayed());
                Assert.assertTrue(carvanaSellTradePage.getYourOfferButton.isEnabled());
                carvanaSellTradePage.getYourOfferButton.click();
                break;
            default:
                throw new NotFoundException("The button is not defined properly in the feature file!!!");
        }
    }

    //1. (S2) And user enters vin number as "12345678912345678"
    @When("user enters vin number as {string}")
    public void user_enters_vin_number_as(String vin) {
        carvanaSellTradePage.vinInputBox.sendKeys(vin);
    }



    //@todo : third scenario

    //1. (S3) When user hovers over on "FINANCING" menu item
    @When("user hovers over on {string} menu item")
    public void user_hovers_over_on_menu_item(String menuItem) {
        if (menuItem.equals("FINANCING")) {
            ActionsUtil.moveToElement(carvanaHomePage.financeLink);
        } else {
            throw new NotFoundException("The link is not defined properly in the feature file!!!");
        }
    }

    //1. (S3) When user enters "Cost of Car I want" as "10,000"
    //2. (S3) And user enters "What is Your Down Payment?" as "1,500"
    @When("user enters {string} as {string}")
    public void user_enters_as(String calculatorOptions, String priceInDollars) {
        switch (calculatorOptions){
            case "Cost of Car I want":
                carvanaLoanCalcPage.priceInputBox.sendKeys(priceInDollars);
                break;
            case "What is Your Down Payment?":
                carvanaLoanCalcPage.downPaymentInputBox.sendKeys(priceInDollars);
                break;
            default:
                throw new NotFoundException("The input box is not defined properly in the feature file!!!");
        }
    }

    //1. (S3) And user selects "What’s Your credit Score?" as "Excellent: 780"
    //2. (S3) And user selects "Choose Your Loan Terms" as "60 Months"
    @When("user selects {string} as {string}")
    public void user_selects_as(String option, String answer) {
        switch (option){
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanCalcPage.creditScoreDropdown, answer);
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanCalcPage.loanTermDropDown, answer);
                break;
            default:
                throw new NotFoundException("The drop down menu is not defined properly in the feature file!!!");
        }
    }

    //1. (S3) Then user should see the monthly payment as "154.00"
    @Then("user should see the monthly payment as {string}")
    public void user_should_see_the_monthly_payment_as(String string) {
        Assert.assertTrue(carvanaLoanCalcPage.loanCalculatorResult.isDisplayed());
        Assert.assertEquals(string, carvanaLoanCalcPage.loanCalculatorResult.getText());
    }






}
