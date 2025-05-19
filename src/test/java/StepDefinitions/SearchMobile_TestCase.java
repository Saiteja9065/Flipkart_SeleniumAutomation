package StepDefinitions;

import java.io.IOException;

import Pages.SearchPage;
import baseClass.Library;
import io.cucumber.java.en.*;
import reusableFunctions.SeleniumReusablle;

public class SearchMobile_TestCase extends Library {
    SearchPage sp;
    SeleniumReusablle se; // WebDriver instance for interacting with the browser
    // This class is a placeholder for the test case related to searching for mobile devices.
    // It will contain the necessary methods and logic to perform the search functionality tests.
    // The actual implementation will depend on the specific requirements and framework being used.
    @Given("user launched the flipkart application")
    public void launchapp() throws IOException{
        // Code to launch the Flipkart application goes here
        sp = new SearchPage(driver);
        se = new SeleniumReusablle(driver);
    }

    @When("user close the popup")
    public void close_popup(){
        sp.handleLoginPopup();
        System.out.println(driver.getTitle());
        // Code to close the popup goes here
        
    }

    @Then("user must navigate to home page")
    public void navigate_to_home_page(){
        // Code to navigate to the home page goes here
        sp.homePageScreen();
    }

    @Given("user enter text in search box")
    public void enter_text_in_search_box(){
        // Code to enter text in the search box goes here
        sp.Search("mobile");
    }

    @When("user click on search button")
    public void click_on_search_button(){
        sp.clickSearch();
    }

    @Then("user must navigate to search result page")
    public void navigate_to_search_result_page(){
        sp.searchPageScreen();
        System.out.println(driver.getTitle());
    }

    @And("extract the product names from search result page")
    public void extract_product_names(){
        sp.getSearchResultsText();
    }

    @And("print the fourth product from the list")
    public void print_fourth_product(){
        sp.getReqSearchResultText();
    }
}
