package hooks;

import baseClass.Library;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reusableFunctions.SeleniumReusablle;

import java.io.IOException;

public class HooksImplementation extends Library {

    SeleniumReusablle se;
    public static Scenario scenario;

    @Before
    public void setUp(Scenario cucumberScenario) throws IOException {
        scenario = cucumberScenario;
        launchapplication();
    }

    @After
    public void tearDown(Scenario cucumberScenario){
        scenario = cucumberScenario;
        se = new SeleniumReusablle(driver);
        se.attachScreenshot(scenario);
        driver.quit();
    }
}
