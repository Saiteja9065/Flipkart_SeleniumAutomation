package StepDefinitions;

import Pages.AddtoCart;
import baseClass.Library;
import io.cucumber.java.en.*;
import reusableFunctions.SeleniumReusablle;

public class AddToCartTestCase extends Library{

    SeleniumReusablle se;
    AddtoCart addCart;

    @Given("user moves to login link")
    public void move_to_Login_Link(){ 
        se = new SeleniumReusablle(driver);
        addCart = new AddtoCart(driver);
        addCart.moveLoginLink();
        se.waits();
    }

    @When("user clicks on flipkart plus zone")
    public void move_to_fpz(){
        addCart.moveAndClickfpsLink();
        se.waits();
    }

    @And("user moves to house and Furniture category")
    public void move_to_hose_furniture(){
        addCart.moveHouseFurniture();
        se.waits();
    }

    @And("user goes to clocks page and selects price")
    public void select_clocks(){
        addCart.clickClocks();
        se.waits();
    }

    @And("user selects his required item")
    public void item_selection(){
        addCart.clickOnReqClock();
        se.waits();
    }

    @Then("user enters pincode to check if item can be delivered")
    public void item_delivery_check(){
        addCart.enterPincode();
        se.waits();
        addCart.assertDeliveryText();
        se.quitdriver();
    }
    
}
