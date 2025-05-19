package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"StepDefinitions","hooks"},
        plugin = {"pretty",
            "html:target/cucumber-reports.html",      // HTML report
            "json:target/cucumber-reports/cucumber.json", // JSON report
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-reports/extent-report.html"},
        monochrome = true

)

public class Runner extends AbstractTestNGCucumberTests{
    // This class is used to run the Cucumber tests with JUnit
    // It specifies the location of feature files and step definitions
    // The plugin option generates a report in HTML format
}

