package Pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.Library;
import reusableFunctions.SeleniumReusablle;

public class SearchPage extends Library {

    SeleniumReusablle se;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //takes the driver instance from the base class and initializes the page elements
        //using PageFactory to initialize the elements on the page.
        //takes driver instance of given class and initializes the page elements using PageFactory to initialize the elements on the page.
    }

    @FindBy(xpath="//input[@name='q']")
    WebElement searchBox; //search box element

    @FindBy(xpath="//span[normalize-space()='Login']")
    WebElement homepage;

    @FindBy(xpath="//span[@class='BUOuZu']")
    WebElement searchpage;

    @FindBy(xpath="/html/body/div[3]/div/span")
    WebElement closeLoginPopup;

    @FindBy(xpath="/html/body/div[3]/div")
    WebElement loginPopup;
                   
    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]")
    List<WebElement> searchResults;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div[5]/div/div/div/a/div[2]/div[1]")
    WebElement reqSearchResult;

    public void Search(String text){
        se = new SeleniumReusablle(driver);
        se.EnterValue(searchBox, text);
    }
    
    public void clickSearch(){
        searchBox.sendKeys(Keys.ENTER);
    }

    public void homePageScreen(){
        System.out.println("Home page is displayed: " + homepage.isDisplayed());
    }

    public void searchPageScreen(){
        System.out.println("Search page is displayed: " + searchpage.isDisplayed());
        System.out.println("Search page title is: " + driver.getTitle());
    }

    public void handleLoginPopup(){
        try{
            if(loginPopup.isDisplayed()){
                se = new SeleniumReusablle(driver);
                System.out.println("Login popup is displayed: " + loginPopup.isDisplayed());
                se.waits();
                se.ClickElement(closeLoginPopup);
            } else {
                System.out.println("Login popup is not displayed.");
            }
        }
        catch(NoSuchElementException e){
            System.out.println("Login popup is not displayed: " + e.getMessage());
        }
    }

    public void getSearchResultsText(){
        se = new SeleniumReusablle(driver);
        se.getMultipleResultText(searchResults);
    }

    public void getReqSearchResultText(){
        se = new SeleniumReusablle(driver);
        se.getElementText(reqSearchResult);
    }

}
