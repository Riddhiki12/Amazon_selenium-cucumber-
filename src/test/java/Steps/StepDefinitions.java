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
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        homePage.getDealButton().click();
    }

    @Then("the deals result should be displayed")
    public void theDealsResultShouldBeDisplayed() throws InterruptedException {
        String url = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

        Assert.assertEquals(url,"https://www.amazon.in/deals?ref_=nav_cs_gb");
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
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        Assert.assertEquals(text, "\"aztp\"");
    }





             // Scenario outline to search by the category

    @Then("the Category search result should be displayed")
    public void theCategorySearchResultShouldBeDisplayed() throws InterruptedException {
        String text = homePage.getCategoryResult().getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        homePage.getCategoryClick().click();


    }


            //Scenario for new release feature

    @When("the user checks with the new releases")
    public void theUserChecksWithTheNewReleases() throws InterruptedException {

        homePage= new HomePage(driver);
        Wait wait1 = new FluentWait(driver)
                .withTimeout(15,TimeUnit.SECONDS)
                        .pollingEvery(7,TimeUnit.SECONDS)
                                .ignoring(Exception.class);
       homePage.getReleaseClick().click();




    }

    @Then("the new release result should be displayed")
    public void theNewReleaseResultShouldBeDisplayed() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String url =  driver.getCurrentUrl();

        Assert.assertEquals(url,"https://www.amazon.in/gp/new-releases/?ref_=nav_cs_newreleases");

    }
}

