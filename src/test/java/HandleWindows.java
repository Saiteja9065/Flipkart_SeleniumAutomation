import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandleWindows {

    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        JavascriptExecutor ex = (JavascriptExecutor) driver;

// Scroll to and click each footer link
WebElement link1 = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[1]"));
ex.executeScript("arguments[0].scrollIntoView(true);", link1);
link1.click();

WebElement link2 = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[2]"));
ex.executeScript("arguments[0].scrollIntoView(true);", link2);
link2.click();

WebElement link3 = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[3]"));
ex.executeScript("arguments[0].scrollIntoView(true);", link3);
link3.click();

WebElement link4 = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[4]"));
ex.executeScript("arguments[0].scrollIntoView(true);", link4);
link4.click();

        Set<String> Handles = driver.getWindowHandles();
        List<String> hlist = new ArrayList<String>(Handles);
        if (switchToRightWindow("Facebook", hlist)) {
            System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
        }
    }

        public static boolean switchToRightWindow(String windowTitle, List<String> hlist){
            for(String h : hlist){
                String title = driver.switchTo().window(h).getTitle();
                if(title.contains(windowTitle)) {
                    System.out.println("found the right window..");
                    return true;
                }
            }
            return false;

        }

}

