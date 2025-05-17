package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Library;
import reusableFunctions.SeleniumReusablle;

public class TitlePriceSearch extends Library{
    SeleniumReusablle se;
    
    public TitlePriceSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='q']")
    WebElement searchbox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchIcon;

    @FindBy(xpath = "//div[@class='hCKiGj']/.")
    List<WebElement> reqSearchResult;

    public void enterSearchtext(String text){
        se = new SeleniumReusablle(driver);
        se.EnterValue(searchbox, text);
    }

    public void clickSearchIcon(){
        se.ClickElement(searchIcon);
    }

    public void getMultipleResultsdata(){
        se = new SeleniumReusablle(driver);
        se.getMultipleResultText(reqSearchResult);
    }
    


}
