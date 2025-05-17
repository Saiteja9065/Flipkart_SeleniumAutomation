package StepDefinitions;

import Pages.FilterPage;
import baseClass.Library;
import io.cucumber.java.en.And;
import reusableFunctions.SeleniumReusablle;

public class FilterMobile_TestCase extends Library{
    FilterPage fp;
    SeleniumReusablle se;

    @And("user apply Minimum and maximum amount")
    public void apply_minimum_and_maximum_amount(){
        se = new SeleniumReusablle(driver);
        fp = new FilterPage(driver);
        System.out.println("Before Filter Result: ");
        se.getElementText(fp.beforeFilterResult);
        fp = new FilterPage(driver);
        fp.selectMinimumAmount();
        se.waits();
        fp.selectMaximumAmount();
        se.waits();
    }

    @And("user selects the Brand")
    public void select_brand_name(){
        fp.selectBrandName();
        se.waits();
    }
    
    @And("user selects the ram capacity")
    public void select_ram_capacity(){
        fp.selectRamSize();
        se.waits();
    }

    @And("user selects the battery capacity")
    public void select_battery_capacity(){
        se.waits();
        fp.selectBatteryCapacity();
        se.waits();
    }

    @And("user must see the filtered products based on the applied filters")
    public void filtered_products(){
        System.out.println("After Filter Result: ");
        se.getElementText(fp.afterFilterResult);
        se.waits();
        se.getScreenshot("FilteredProducts");
        se.quitdriver();
    }
}

