package StepDefinitions;

import Pages.BabyKidsToys;
import baseClass.Library;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import reusableFunctions.SeleniumReusablle;

public class HoverToys_TestCase extends Library{

    SeleniumReusablle se; // WebDriver instance for interacting with the browser
    BabyKidsToys bt; // Page object for BabyKidsToys

    @Given("user selects the Fashion category")
    public void select_fashion_category(){
        bt= new BabyKidsToys(driver);
        bt.hoverFashionCategory();
        bt.hoverKidsCategory();
    }

    @When("user hovers and clicks on the Baby and Kids category")
    public void hover_babyKids_category(){
        bt.selectAllForKids();
        bt.hoverOnBabyKidsCategory();
    }

    @And("user moved the cursor to outdoor toys")
    public void select_outdoor_toys(){
        bt.selectOutdoorToysCategory();
    }

    @And("user clicks on price high to low link")
    public void Select_pricehightolow(){
        bt.selectPriceHighToLow();
    } 

    @And("user must see relevant products based on the selected category")
    public void relevant_products(){
        bt.reviewresults();
    }
    
}
