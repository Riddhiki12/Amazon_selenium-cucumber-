package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




    public WebElement getSearchResult() {
        return searchResult;
    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")
    WebElement searchResult;






    public WebElement getRandomSearch() {
        return randomSearch;
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")
    WebElement randomSearch;





    public WebElement getDealButton() {
        return dealButton;
    }
    @FindBy(xpath = "//a[@href='/deals?ref_=nav_cs_gb']")
    WebElement dealButton;

    public WebElement getDealResult(){
        return dealResult;
    }

    @FindBy(xpath = "/html/body/div[1]/div[9]/div[1]/div/div/h1")
    WebElement dealResult;




    public WebElement getCategoryClick(){
        return categoryClick;
    }

    public WebElement getCategoryResult(){
        return  categoryResult;

    }


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[1]/ul/li[1]/span/a/span")
    WebElement categoryClick;

    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")
    WebElement categoryResult;





    public WebElement getReleaseClick(){
        return releaseClick;
    }

    public WebElement getReleaseResult(){
        return releaseResult;
    }

    @FindBy(xpath= "//a[@href='/new-releases/?ref_=nav_cs_newreleases']")
    WebElement releaseClick;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div/span[1]" )
    WebElement releaseResult;













}
