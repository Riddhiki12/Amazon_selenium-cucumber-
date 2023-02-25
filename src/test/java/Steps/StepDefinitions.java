package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;


    public StepDefinitions(BrowserManager browserManager){
        this.driver=browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario){
        this.scenario = scenario;
    }


    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url= QaProps.getValue("url");
        driver.get(url);

        data = TestDataReader.getData(scenario.getName());
    }



    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        homePage= new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }


    @Then("the product result should be displayed")
    public void the_product_result_should_be_displayed() {
      String text = homePage.getSearchResult().getText();
      System.out.println(text);
      Assert.assertEquals(text, "\"Alexa\"");
    }





          // scenario for Deals and Discount

    @When("the user checks for deals and discounts")
    public void theUserChecksForDealsAndDiscounts() throws InterruptedException {
        homePage= new HomePage(driver);
        Thread.sleep(2000);
        homePage.getDealButton().click();

        homePage.getDealButton().sendKeys("Today's Deals");

    }

    @Then("the deals result should be displayed")
    public void theDealsResultShouldBeDisplayed() throws InterruptedException {
        String text = homePage.getDealResult().getText();
        System.out.println(text);

        Thread.sleep(2000);
        String ExpectedTitle = "Today's Deals";
        Assert.assertEquals(text, ExpectedTitle);
    }





          //Scenario for unknown product search

    @When("the user enter the unknown product name")
    public void theUserEnterTheUnknownProductName(){
        homePage= new HomePage(driver);

        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }
    @Then("the  unknown product result should be displayed")
    public void theUnknownProductResultShouldBeDisplayed() throws InterruptedException {
        String text = homePage.getRandomSearch().getText();
        System.out.println(text);
        Thread.sleep(2000);
        String ExpectedTitle = "No results for";

        Assert.assertEquals(text,ExpectedTitle);
    }





             // Scenario outline to search by the category

    @Then("the Category search result should be displayed")
    public void theCategorySearchResultShouldBeDisplayed() throws InterruptedException {
        String text = homePage.getCategoryResult().getText();
        Thread.sleep(5000);
        System.out.println(text);


        Assert.assertEquals(text, "\"Alexa\"");
    }


    @When("the user enters the product name")
    public void theUserEntersTheProductName() {
        homePage= new HomePage(driver);

        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }

    @And("User  searches for Echo Smart Speakers & Displays")
    public void userSearchesForEchoSmartSpeakersDisplays() throws InterruptedException {
        homePage= new HomePage(driver);
        Thread.sleep(5000);
        homePage.getCategoryClick().click();


    }


            //Scenario for new release feature

    @When("the user checks with the new releases")
    public void theUserChecksWithTheNewReleases() throws InterruptedException {

        homePage= new HomePage(driver);
        Thread.sleep(2000);
        homePage.getReleaseClick().click();
        Thread.sleep(2000);
        homePage.getReleaseClick().sendKeys("New Releases");

    }

    @Then("the new release result should be displayed")
    public void theNewReleaseResultShouldBeDisplayed() throws InterruptedException {
        String text = homePage.getReleaseResult().getText();
        System.out.println(text);
        Thread.sleep(5000);
        String ExpectedTitle = "Amazon Hot New Releases";
        Assert.assertEquals(text, ExpectedTitle);

    }
}

