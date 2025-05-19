package reusableFunctions;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Library;

public class SeleniumReusablle extends Library {

    public SeleniumReusablle(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterValue(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Unable to enter value in the field: " + element.toString());
            e.printStackTrace();
        }
    }

    public void ClickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void getTitle() {
        try {
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
        } catch (Exception e) {
            System.out.println("Unable to get the page title.");
            e.printStackTrace();
        }
    }

//    public void getScreenshot(String fileName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//
//        try {
//            String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
//            FileUtils.copyFile(source, new File(path));
//            System.out.println("Screenshot taken: " + path);
//        } catch (Exception e) {
//            System.out.println("Unable to take screenshot.");
//            e.printStackTrace();
//        }
//    }

    public void getMultipleResultText(List<WebElement> elements) {
        try {
            for (WebElement element : elements) {
                System.out.println("Search result: " + element.getText());
            }
        } catch (Exception e) {
            System.out.println("Unable to get the text of the elements.");
            e.printStackTrace();
        }
        System.out.println(elements.size() + " search results found.");
    }

    public void getElementText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println("Element text is: " + text);
        } catch (Exception e) {
            System.out.println("Unable to get the text of the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void dropdown(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            System.out.println("Unable to select value from dropdown: " + element.toString());
            e.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to the element and click: " + element.toString());
            e.printStackTrace();
        }
    }

    public void waitForElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout
            wait.until(ExpectedConditions.visibilityOf(element)); // Wait until the element is visible
            System.out.println("Element is visible: " + element.toString());
        } catch (Exception e) {
            System.out.println("Unable to wait for the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void waits() {
        try {
            Thread.sleep(5000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
    public void mouseHoverOnElement(WebElement element){
        try{
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found: " + element.toString());
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Unable to perform mouse hover on the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void mouseHoverOnElementAndClick(WebElement element){
        try{
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found: " + element.toString());
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Unable to perform mouse hover on the element: " + element.toString());
            e.printStackTrace();
        }
    }

    public void quitdriver() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Unable to quit the driver.");
            e.printStackTrace();
        }
    }
    public void closeDriver() {
        try {
            driver.close();
        } catch (Exception e) {
            System.out.println("Unable to close the driver.");
            e.printStackTrace();
        }
    }

    public void windowHandling(WebElement element){
        String parentWindow = driver.getWindowHandle();
        element.click();
        System.out.println(parentWindow);
        Set<String> allWindows = driver.getWindowHandles();

        for(String window : allWindows){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + window);
            }
        }

    }

    public void attachScreenshot(Scenario cucumberScenario){
        try {
            // Take screenshot as file
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + System.currentTimeMillis() + ".png";
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);

            // Attach for Cucumber HTML report
            byte[] screenshotBytes = Files.readAllBytes(destFile.toPath());
            cucumberScenario.attach(screenshotBytes, "image/png", "Flipkart_seleniumautomation");

            // Attach for ExtentReports (ExtentCucumberAdapter will pick up from path)
            cucumberScenario.log("Screenshot: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Unable to take or attach screenshot.");
            e.printStackTrace();
        }

    }

    

    

}

