package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Library;
import reusableFunctions.SeleniumReusablle;

public class AddtoCart extends Library {
    
    SeleniumReusablle se;
    public AddtoCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement LoginButton;

    @FindBy(xpath = "//li[normalize-space()='Flipkart Plus Zone']")
    WebElement fpz;
    
    @FindBy(xpath = "//*[@id='container']/div/div[2]/div/div/span[6]")
    WebElement homeFur;

    @FindBy(xpath = "//*[@id='container']/div/div[2]/div/div/div/div[4]/a[3]")
    WebElement clocks;

    @FindBy(xpath = "//div[@data-id='TCKGCHSVZDKNTHJF']")
    WebElement reqClock;

    @FindBy(xpath = "//input[@class='AFOXgu']")
    WebElement deliveryPincodeinput;

    @FindBy(xpath = "//span[normalize-space()='Check']")
    WebElement pinCodeCheck;

    @FindBy(xpath="//div[normalize-space()='Price -- Low to High']")
    WebElement priceLowtoHighSelect;

    @FindBy(xpath = "//div[text()='Delivery by']")
    WebElement deliveryText;

    public void moveLoginLink(){
        se = new SeleniumReusablle(driver);
        se.mouseHoverOnElement(LoginButton);
    }

    public void moveAndClickfpsLink(){
        se.mouseHoverOnElementAndClick(fpz);
    }

    public void moveHouseFurniture(){
        se.mouseHoverOnElement(homeFur);
    }

    public void clickClocks(){
        se.ClickElement(clocks);
        se.waits();
        se.ClickElement(priceLowtoHighSelect);
    }

    public void clickOnReqClock(){
        se.scrollToElementAndClick(reqClock);
    }

    public void enterPincode(){
        se.windowHandling(reqClock);
        se.waits();
        se.ClickElement(deliveryPincodeinput);
        se.waits();
        se.EnterValue(deliveryPincodeinput, "500032");
    }

    public void assertDeliveryText(){
       boolean isVisible = deliveryText.isDisplayed();
       if(isVisible){
        System.out.println("Delivery Text is displayed");
       }
       else{
        System.out.println("error in displaying element");
       }
    }



}
