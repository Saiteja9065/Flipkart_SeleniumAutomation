package StepDefinitions;

import Pages.TitlePriceSearch;
import baseClass.Library;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reusableFunctions.SeleniumReusablle;

public class TitlePrice_TestCase extends Library {
    
    SeleniumReusablle se;
    TitlePriceSearch tps;

    @Given("user enter search text in search box")
    public void enter_search_text(){
        tps = new TitlePriceSearch(driver);
        se = new SeleniumReusablle(driver);
        tps.enterSearchtext("t shirts");
        se.waits();
    }

    @When("user clicks the search icon")
    public void click_search_icon(){
        tps.clickSearchIcon();
        se.waits();
    }

    @Then("^user must see his/her search result and get title and price")
    public void get_title_and_price_of_items(){
        tps.getMultipleResultsdata();
        se.quitdriver();
    }

}
