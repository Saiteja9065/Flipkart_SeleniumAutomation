package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources_new/Features/",
        glue = "StepDefinitions",
        plugin = {"pretty",
            "html:target/cucumber-reports.html",      // HTML report
            "json:target/cucumber-reports/cucumber.json", // JSON report
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-reports/extent-report.html"},
        monochrome = true

)

public class Runner extends AbstractTestNGCucumberTests {
    // This class is used to run the Cucumber tests with JUnit
    // It specifies the location of feature files and step definitions
    // The plugin option generates a report in HTML format
}

