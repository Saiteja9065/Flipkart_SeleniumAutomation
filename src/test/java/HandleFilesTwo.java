import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFilesTwo{

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
        chromeprefs.put("profile.default_content_settings.popups", "0");
        chromeprefs.put("download.default_directory", "C:\\Users\\Lenovo\\Downloads");
        options.setExperimentalOption("prefs", chromeprefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/p/page7.html");

        // driver.findElement(By.xpath("//a[contains(text(),ZIP file)]")).click();
        driver.findElement(By.linkText("ZIP file")).click();

        Thread.sleep(2000);

        File file = new File("C:\\Users\\Lenovo\\Downloads\\test.zip");
        if (file.exists()) {
            System.out.println("File downloaded successfully: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
        }


    }
}