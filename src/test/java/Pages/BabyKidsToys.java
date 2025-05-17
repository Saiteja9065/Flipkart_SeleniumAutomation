package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Library;
import reusableFunctions.SeleniumReusablle;

public class BabyKidsToys extends Library{

    SeleniumReusablle se; // WebDriver instance for interacting with the browser
    public BabyKidsToys(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[normalize-space()='Fashion']")
    WebElement fashionCategory;

    @FindBy(xpath="//a[text()='Kids']")
    WebElement KidsArrow;

    @FindBy(xpath="//a[text()='All']")
    WebElement allKidsItems;
    
    @FindBy(xpath="//span[normalize-space()='Baby & Kids']")
    WebElement babyKidsCategory;

    @FindBy(xpath="//*[@id='container']/div/div[2]/div/div/div/div[3]/a[6]")
    WebElement babyKidsToysCategory;

    @FindBy(xpath="//div[normalize-space()='Price -- High to Low']")
    WebElement priceHighToLowSelect;

    public void hoverFashionCategory(){
        se = new SeleniumReusablle(driver);
        se.mouseHoverOnElement(fashionCategory);
        se.waits();
    }
    
    public void hoverKidsCategory(){
        se.mouseHoverOnElement(KidsArrow);
        se.waits();
    }

    public void selectAllForKids(){
        se.ClickElement(allKidsItems);
        se.waits();
    }

    public void hoverOnBabyKidsCategory(){
        se.mouseHoverOnElement(babyKidsCategory);
        se.waits();
    }

    public void selectOutdoorToysCategory(){
        se.ClickElement(babyKidsToysCategory);
        se.waits();
    }

    public void selectPriceHighToLow(){
        se.ClickElement(priceHighToLowSelect);
        se.waits();
    }
}
