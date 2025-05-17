package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Library;
import reusableFunctions.SeleniumReusablle;

public class FilterPage extends Library {
    SeleniumReusablle se; // WebDriver instance for interacting with the browser
    public FilterPage(WebDriver driver) {
        // Constructor for FilterPage class
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select")
    WebElement minimumAmount;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")
    WebElement maximumAmount;

    @FindBy(xpath="//div[text()='SAMSUNG']/preceding-sibling::div")
    WebElement brandName;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div[1]/section[7]/div[1]/div")
    public WebElement ramCategory;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div[1]/section[7]/div[2]/div/div[5]/div/label/div[2]")
    public
    WebElement ramSize;

    // @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div[1]/section[9]/div/div")
    @FindBy(xpath="//div[text()='Battery Capacity']")
    WebElement batteryCapacity;

    @FindBy(xpath="//div[text()='5000 - 5999 mAh']/preceding-sibling::div")
    WebElement batteryCapacityValue;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]")
    public WebElement beforeFilterResult;

    @FindBy(xpath="//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]")
    public WebElement afterFilterResult;

    public void selectMinimumAmount(){
        se = new SeleniumReusablle(driver);
        se.dropdown(minimumAmount,"10000");
    }

    public void selectMaximumAmount(){
        se = new SeleniumReusablle(driver);
        se.dropdown(maximumAmount,"30000");
    }

    public void selectBrandName(){
        se.ClickElement(brandName);
    }

    public void selectRamSize(){
        se.scrollToElement(ramCategory);
        se.waits();
        se.ClickElement(ramSize);
    }

    public void selectBatteryCapacity(){
        se.scrollToElementAndClick(batteryCapacity);
        se.waits();
        se.ClickElement(batteryCapacityValue);
    }
}
